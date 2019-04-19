package ru.trandefil.spring.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.model.LoggedUser;

import javax.servlet.http.HttpSession;
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
    public String login() {
        return "login";
    }

    @GetMapping("/session")
    public String session(HttpSession httpSession){
        return "login";
    }

}
