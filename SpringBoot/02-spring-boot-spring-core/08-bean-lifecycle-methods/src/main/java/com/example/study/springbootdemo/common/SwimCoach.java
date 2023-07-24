package com.example.study.springbootdemo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warn up";
    }
}
