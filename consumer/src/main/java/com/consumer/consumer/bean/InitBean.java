package com.consumer.consumer.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InitBean {

    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate(){
        return new RestTemplate() ;
    }

}
