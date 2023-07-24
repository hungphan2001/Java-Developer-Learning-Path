package com.example.study.springbootdemo.rest;

import com.example.study.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach anotherCoach,myCoach;

    //define constructor for dependency injection
    @Autowired
    public DemoController( @Qualifier("trackCoach") Coach theCoach,
                           @Qualifier("trackCoach") Coach theAnotherCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach =theAnotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach=another, " + (myCoach==anotherCoach);
    }
}
