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


	@Bean
	CommandLineRunner initDatabase( CourseRepository courseRepository){
		return args -> {
			// courseRepository.deleteAll();
			for (int i = 0; i < 10; i++) {
				Course c = new Course();
				c.setName("Java Spring Boot "+ i);
				c.setCategory("back-end");
				courseRepository.save(c);
			}
		};
	}
}
