package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=======>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for(Object tempArg: args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                //downcast and print Account specific stuff
                Account theAccount =(Account) tempArg;
                System.out.println("Acc name: "+theAccount.getName());
                System.out.println("Acc level: "+theAccount.getLevel());
            }
        }

    }

    //Will not show if not have this method
    @Before("execution(void toorrmow())")
    public void performApiAnalyticsa(){
        System.out.println("\n=======>>> Performing API analytics");
    }
}
