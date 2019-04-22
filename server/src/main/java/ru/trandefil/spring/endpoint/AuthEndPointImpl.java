package ru.trandefil.spring.endpoint;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.dto.UserDTO;
import ru.trandefil.spring.generated.AuthEndPoint;
import ru.trandefil.spring.model.LoggedUser;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.trandefil.spring.generated.AuthEndPoint")
public class AuthEndPointImpl implements AuthEndPoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    @WebMethod
    public Result login(@NonNull final String name, @NonNull final String password) {
        try {
            logger.info("============================ auth end point  logint with authmanager : " + authenticationManager);
            final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
            final Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            LoggedUser loggedUser = null;
            if (principal instanceof UserDetails){
                logger.info("========================== principal instance of UserDetails");
                loggedUser = (LoggedUser) principal;
            }

            return new Result(authentication.isAuthenticated());
        } catch (AuthenticationException e) {
            return new Result(e);
        }
    }

    @Override
    @WebMethod
    public UserDTO logged() {
        logger.info("======================== authendpoint logged()");
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoggedUser loggedUser = null;
        if (principal instanceof UserDetails){
            logger.info("========================== principal instance of UserDetails");
            loggedUser = (LoggedUser) principal;
        }
        logger.info("============================== logged user is null ? " + loggedUser + "  , principal ? " + principal);
        return loggedUser == null ? new UserDTO() : new UserDTO(loggedUser);
    }

}
