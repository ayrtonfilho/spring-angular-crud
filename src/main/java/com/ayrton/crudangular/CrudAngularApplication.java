package com.ayrton.crudangular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayrton.crudangular.model.Course;
import com.ayrton.crudangular.repository.CourseRepository;


@SpringBootApplication
public class CrudAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAngularApplication.class, args);
	}


	// @Bean
	// CommandLineRunner initDatabase( CourseRepository courseRepository){
	// 	return args -> {
	// 		// courseRepository.deleteAll();
	// 		for (int i = 0; i < 4; i++) {
	// 			Course c = new Course();

	// 			if(i > 2){

	// 				c.setName("aava Spring Boot "+ i);
	// 				c.setCategory("back-end");
	// 				courseRepository.save(c);
	// 			}else{

	// 				c.setName("Zava Spring Boot "+ i);
	// 				c.setCategory("back-end");
	// 				courseRepository.save(c);
	// 			}
	// 		}
	// 	};
	// }
}
