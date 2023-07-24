package com.example.study.springbootdemo.config;

import com.example.study.springbootdemo.common.Coach;
import com.example.study.springbootdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquaVina")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
