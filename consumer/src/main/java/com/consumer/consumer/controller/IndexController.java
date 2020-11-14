package com.consumer.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/login.html")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "hello";
    }
}
