package pl.jakubz.simplehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    public LoginController() {
    }

    @GetMapping("/loginForm")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/denied")
    public String accessDenied(){
        return "access-denied";
    }
}
