package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createCourseAndReviews(appDAO);
			//createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
			//findInstructorDetailById(appDAO);
			//deleteInstructorDetailById(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourseById(appDAO);
			deleteCourseAndReviews(appDAO);
			//createInstructorWithCourses(appDAO);
			//findnstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorByIdJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//retrieveCourseAndReviews(appDAO);
		};
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 7;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 6;

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId =3;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("Tester");
		appDAO.update(tempInstructor);
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Zung - How To Score One Million Points");

		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor= new Instructor("Tung","Nguyen","tung@gmail.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("https://youtube.com","Video");

		// associate the objects
		tempInstructor.setInstructorDetail(tempinstructorDetail);
		//create some courses
		Course tempCourse1 = new Course("Air Voice Ultimate Guide");
		Course tempCourse2 = new Course("The Football Masterclass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
		// NOTE : this will ALSO save the courses
		// because of CasadeType.PERSIST
        //
		System.out.println("Saving instructor "+tempInstructor);
		System.out.println("The courses "+tempInstructor.getCourses());

		//save tempinstructor
		appDAO.save(tempInstructor);
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

	private void findInstructorById(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(" instructor : "+tempInstructor);
		System.out.println("the associate instructordetail only: "+tempInstructor.getInstructorDetail());
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

	private void findnstructorWithCourses(AppDAO appDAO) {
		int theId =9;
		System.out.println("Finding instructor id: "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println(" instructor : "+instructor);
		System.out.println("the associate courses only: "+instructor.getCourses());
		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId =9;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int theId =9;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}


	private void deleteInstructorById(AppDAO appDAO) {
		int theId =8;
		System.out.println("Delete instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId= 1;
		System.out.println("Delete instructordetail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =3;
		System.out.println("Delete instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId =5;
		System.out.println("Delete course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId =6;
		System.out.println("Delete course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

}
