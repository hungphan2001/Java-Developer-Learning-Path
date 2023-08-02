package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDAO){
		return runner->{
			demoTheBeforeAdvice(theAccountDao,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao,MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAcc = new Account();
		theAccountDao.addAccount(myAcc,true);

		//call the membership method
		theMembershipDAO.addSillyMember();
	}

}
