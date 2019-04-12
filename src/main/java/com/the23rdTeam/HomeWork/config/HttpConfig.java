package com.the23rdTeam.HomeWork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {

    /*
    1) Spring boot application이 시작될 때 함께 시작되는 Spring Container가
    @Bean annotation이 붙은 메소드를 평생 한 번만 실행!
    2) 실행 후 반환받은 RestTemplate 객체를 container에 보관!
    3) 프로젝트 안 @Autowired annotation과 함께 RestTemplate 필드 선언 시,
    Container 안에서 보관 중인 RestTemplate 객체를 주입(DI)해 줌.
     */
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
