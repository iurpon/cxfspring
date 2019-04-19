package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.generated.AuthEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService(endpointInterface = "ru.trandefil.spring.generated.AuthEndPoint")
public class AuthEndPointImpl implements AuthEndPoint {

    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    @WebMethod
    public Result login(@NonNull final String name, @NonNull final String password) {
        try {
            final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
            final Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new Result(authentication.isAuthenticated());
        } catch (AuthenticationException e) {
            return new Result(e);
        }
    }

    @Override
    @WebMethod
    public Result logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new Result(false);
    }

    @Override
    @WebMethod
    public LoggedUser logged() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoggedUser loggedUser = null;
        if (principal instanceof UserDetails) loggedUser = (LoggedUser) principal;
        System.out.println("============================== logged user is null");
        return loggedUser ;
    }

}
