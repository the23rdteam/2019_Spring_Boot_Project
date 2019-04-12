package com.the23rdTeam.HomeWork.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
