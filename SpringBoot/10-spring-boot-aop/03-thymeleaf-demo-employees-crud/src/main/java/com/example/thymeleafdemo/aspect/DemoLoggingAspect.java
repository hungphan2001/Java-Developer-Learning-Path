package com.example.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //setup logger

    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations with controller
    @Pointcut("execution(* com.example.thymeleafdemo.controller.*.*(..))")
    public void forControllerPackage(){

    }

    //setup pointcut declarations with service
    @Pointcut("execution(* com.example.thymeleafdemo.service.*.*(..))")
    public void forServicePackage(){

    }

    //setup pointcut declarations with dao
    @Pointcut("execution(* com.example.thymeleafdemo.dao.*.*(..))")
    public void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() ||forServicePackage() ||forDaoPackage() ")
    public void forAppFlow(){

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("======>> in @Before : calling method: "+method);

        //display the arguments to the method

        //get the arguments
        Object [] args = joinPoint.getArgs();

        //loop thru and display args
        for(Object tempArrg :args){
            myLogger.info("=====>argument: "+tempArrg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint,Object theResult){

        //display method we are returning from
        String method = joinPoint.getSignature().toLongString();
        myLogger.info("=====> in @AfterReturning: calling method: "+method);

        //display data returned
        myLogger.info("=====> in result: "+theResult);
    }
}
