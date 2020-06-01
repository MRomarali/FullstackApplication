package se.ecutb.OmarAli.todo_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String home(){
        return "login-form";
    }

    @GetMapping("/accessdenied")
    public String getAccessDenied(){
        return "access-denied";
    }
}
