package com.luv2code.cruddemo123;

import com.luv2code.cruddemo123.dao.AppDao;
import com.luv2code.cruddemo123.entity.Instructor;
import com.luv2code.cruddemo123.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo123Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo123Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO){
		return runner -> {
		//	createInstructor(appDAO);

		//	findInstructor(appDAO);

			//deleteInstructor(appDAO);

		//	findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDao appDAO) {

		int theId=3;
		System.out.println("Deleting Instructor datail id : "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done");






	}

	private void findInstructorDetail(AppDao appDAO) {
		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail : "+ tempInstructorDetail);
		System.out.println("associated instructor : "+tempInstructorDetail.getInstructor());
		System.out.println("done");



	}

	private void deleteInstructor(AppDao appDAO) {
		int theId=1;
		System.out.println("deleting instructor id : "+ theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDao appDAO) {
		int theId=2;
		System.out.println("finding instructor id : "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor : "+ tempInstructor);
		System.out.println("the associated instructor detail : "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDAO) {
		/*
		Instructor tempInstructor =
				new Instructor("chad","darby","darby@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code !!!");

		*/

		Instructor tempInstructor =
				new Instructor("madhu","patel","madhu@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","guitar");



		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor : "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("save");

	}
}
