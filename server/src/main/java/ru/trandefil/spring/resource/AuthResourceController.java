package ru.trandefil.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.dto.Result;

@RestController
@RequestMapping(value = "/rest")
public class AuthResourceController {

    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    private AuthenticationManager authenticationManager;

//    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result login(@RequestParam("name") String name, @RequestParam("password") String password) {
        try {
            final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
            final Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new Result(authentication.isAuthenticated());
        } catch (AuthenticationException e) {
            return new Result(e);
        }
    }

    @GetMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return new Result(false);
    }

    @GetMapping(value = "/loggedUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public LoggedUser logged(){
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoggedUser loggedUser = null;
        if(principal instanceof UserDetails) loggedUser = (LoggedUser) principal;
        return loggedUser;
    }

}
