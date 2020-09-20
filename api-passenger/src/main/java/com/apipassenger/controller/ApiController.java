package com.apipassenger.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public String index(){
        return "ApiPassenger" + "-" + port;
    }

}
