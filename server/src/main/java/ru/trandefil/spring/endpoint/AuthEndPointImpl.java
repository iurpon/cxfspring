package ru.trandefil.spring.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.trandefil.spring.LoggedUser;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.generated.AuthEndPoint;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.trandefil.spring.generated.AuthEndPoint")
public class AuthEndPointImpl  implements AuthEndPoint {

    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public Result login(String name, String password) {
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
    public Result logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new Result(false);
    }

    @Override
    public LoggedUser logged() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoggedUser loggedUser = null;
        if(principal instanceof UserDetails) loggedUser = (LoggedUser) principal;
        return loggedUser;
    }

}
