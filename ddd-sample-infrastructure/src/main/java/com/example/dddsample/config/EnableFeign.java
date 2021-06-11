package com.example.dddsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2021/6/10.
 *
 * @author Beiyuan Zhang
 */
@Configuration
public class EnableFeign {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
