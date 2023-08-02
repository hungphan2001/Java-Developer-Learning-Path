package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add of our related advices

    //let us start with an @Before advice

//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=======>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=======>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*(com.example.aopdemo.Account))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=======>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*(com.example.aopdemo.Account, ..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=======>>> Executing @Before advice on method");
//    }
}
