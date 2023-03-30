package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

    @GetMapping(path="/hello")
    String helloWorld(){
        return "hello";
    }

}
