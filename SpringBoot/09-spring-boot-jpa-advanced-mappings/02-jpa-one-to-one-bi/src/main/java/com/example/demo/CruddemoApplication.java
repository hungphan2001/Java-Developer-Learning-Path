package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
			//findInstructorDetailById(appDAO);
			//deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId= 1;
		System.out.println("Delete instructordetail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding instructor id: "+theId);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println(" instructordetail : "+instructorDetail);
		System.out.println("the associate instructordetail only: "+instructorDetail.getInstructor());
		System.out.println("Done");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId =2;
		System.out.println("Delete instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(" instructor : "+tempInstructor);
		System.out.println("the associate instructordetail only: "+tempInstructor.getInstructorDetail());
		System.out.println("Done");
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor= new Instructor("Hoang","Ha","agggggg@gmail.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("https://youtube.com","ZZZZ");

		tempInstructor.setInstructorDetail(tempinstructorDetail);

		System.out.println("Saving instructor "+tempInstructor);

		//save tempinstructor
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

}
