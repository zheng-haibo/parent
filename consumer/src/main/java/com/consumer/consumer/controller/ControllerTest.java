package com.consumer.consumer.controller;


import com.consumer.consumer.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @Autowired
    private ServiceTest serviceTest;

    @Value("${server.port}")
    private int port;

    @GetMapping("/consumer")
    public String send(){
        return serviceTest.send();
    }

    @GetMapping("/hello")
    public String initGet(){
        return "hello" + port;
    }

}
