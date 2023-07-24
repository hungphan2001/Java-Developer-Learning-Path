package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			//createStudent(studentDAO);
			createMultiStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//queryStudents(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=5;
		System.out.println("Delete student with id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id : "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student....");
		myStudent.setFirstName("Hung");
		studentDAO.update(myStudent);
		System.out.println("Updated student : "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theLastName = studentDAO.findByLastName("Tran");
		for(Student lastName:theLastName){
			System.out.println(lastName);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of the students
		for(Student theStudent:theStudents){
			System.out.println(theStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

		//save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);

		//display the student object
		System.out.println("Save student. Generated id: "+tempStudent.getId());

		//retrieve student based on the id :primary key
		System.out.println("\nRetrieving student with id: "+tempStudent.getId());
		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: "+student);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Hung","Phan","hungphan2001@gmail.com");

		//save the student object
		studentDAO.save(tempStudent);

		//Display
		System.out.println("Created new student object..."+tempStudent.getId());
	}

	private void createMultiStudent(StudentDAO studentDAO) {
		//create the student object

		System.out.println("Creating new student object...");
		Student tempMultiStudent1 = new Student("Hai","Phan","haiphanvp@gmail.com");
		Student tempMultiStudent2 = new Student("Yen","Le","leyen111@gmail.com");
		Student tempMultiStudent3 = new Student("Tung","Tran","trantungabb@gmail.com");

		//save the student object
        studentDAO.save(tempMultiStudent1);
		studentDAO.save(tempMultiStudent2);
		studentDAO.save(tempMultiStudent3);

		//Display
		System.out.println("Created new student object..."+tempMultiStudent1.getId());
		System.out.println("Created new student object..."+tempMultiStudent2.getId());
		System.out.println("Created new student object..."+tempMultiStudent3.getId());
	}

}
