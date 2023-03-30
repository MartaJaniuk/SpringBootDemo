package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

    //stworzyć jsp login.jsp do logowania
    @GetMapping(path="/logowanie")
    String login(){
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    public String home() { return "home"; }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() { return "info for admin"; }

    @GetMapping("/about")
    @ResponseBody
    public String about() { return "Here you can find some details for logged users"; }
}
