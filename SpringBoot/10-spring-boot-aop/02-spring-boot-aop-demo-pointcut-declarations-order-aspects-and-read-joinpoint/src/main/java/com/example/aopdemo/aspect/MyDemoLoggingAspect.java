package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    public Object afterGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @Around on method: "+method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now let us execute the method
        Object result = null;
        try{
            result =proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //throw exception
//            throw e;
            result = "Major accident! But no worries,your private AOP helicoper is on the way";
        }

        // get end timestamp
        long end =System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;

        System.out.println("\n======> Duration is: "+duration/1000.0+"seconds");

     return result;
    }
    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccount(..))")
    public void atferFinallyFindAccountsAdvice(JoinPoint joinPoint){
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @After (finally) on method: "+method);
    }
    @AfterThrowing(
            pointcut =  "execution(* com.example.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc){

        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterThrowing on method: "+method);

        //log the exception
        System.out.println("\n======> The exception is: "+theExc);

        //let us post-process the data ... let us modify it  :)
    }


    @AfterReturning(
            pointcut =  "execution(* com.example.aopdemo.dao.AccountDAO.findAccount(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        //print out which method we are advising on
        String method = joinPoint.getSignature().toLongString();
        System.out.println("\n=====> Executing @AfterReturning on method: "+method);

        //print out the results of the method call data
        System.out.println("\n=====> Result: "+result);

        //let us post-process the data ... let us modify it  :)
        coverAccountNameToUpperCase(result);
    }

    private void coverAccountNameToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account tempAccount: result){

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name of the account
            tempAccount.setName(theUpperName);
        }
    }

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
