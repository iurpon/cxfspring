package ru.trandefil.spring.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.LoggedUser;

@Controller
public class RootController {

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

}
