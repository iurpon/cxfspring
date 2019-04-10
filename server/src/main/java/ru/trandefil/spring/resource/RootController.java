package ru.trandefil.spring.resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.LoggedUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
public class RootController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String root() {
        LoggedUser loggedUser = LoggedUser.getLoggedUser();
        return "hello";
    }

    @GetMapping("/hello")
    public String yo() {
        return "hello";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

/*    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        logger.info(":::::logout");
*//*        HttpServletResponse response1 = response;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response1,authentication);*//*
        return "login";
    }*/

}
