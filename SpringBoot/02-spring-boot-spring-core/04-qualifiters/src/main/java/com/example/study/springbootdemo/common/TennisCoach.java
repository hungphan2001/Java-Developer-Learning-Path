package com.example.study.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 35 minutes for tennis practice";
    }
}
