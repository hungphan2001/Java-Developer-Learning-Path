package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService){
		return runner->{
			//demoTheBeforeAdvice(theAccountDao,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDao);
			//demoTheAfterThrowAdvice(theAccountDao);
			//demoTheAfterAdvice(theAccountDao);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data =theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String data =theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDao) {
		List<Account> theAcc = null;
		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAcc = theAccountDao.findAccount(tripWire);
		} catch (Exception exception){
			System.out.println("\n\nMain Program: ... caught exception: "+exception);
		}
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("-------");
		System.out.println(theAcc);
		System.out.println("\n");

	}

	private void demoTheAfterThrowAdvice(AccountDAO theAccountDao) {
		List<Account> theAcc = null;
		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
           theAcc = theAccountDao.findAccount(tripWire);
		} catch (Exception exception){
			System.out.println("\n\nMain Program: ... caught exception: "+exception);
		}
		System.out.println("\n\nMain Program: demoTheAfterThrowAdvice");
		System.out.println("-------");
		System.out.println(theAcc);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao,MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Meo");
		myAccount.setLevel("Zoo");
		theAccountDao.addAccount(myAccount, true);
		theAccountDao.doWork();

		//call the accountdao getter/setter methods

		theAccountDao.setName("foobar");
		theAccountDao.setServiceCode("silver");

		String name = theAccountDao.getName();
		String code = theAccountDao.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDao){
		List<Account> theAcc = theAccountDao.findAccount();
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("-------");
		System.out.println(theAcc);
		System.out.println("\n");
	}

}
