package com.consumer.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceTest {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "back")
    public String send(){
        return restTemplate.getForObject("http://api-passenger-1/hello",String.class);
    }


    public String back(){
        return "hystrix";
    }
}
