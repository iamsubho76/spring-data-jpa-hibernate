package com.org.spring.data.jpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.spring.jpa.hibernate.model.Course;
import com.org.spring.jpa.hibernate.repository.CourseRepository;

@SpringBootApplication
public class HibernateDemoApplication  implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Course course = repository.findById(10001L);
		
		logger.info("Course 10001 -> {}", course);
		
		repository.save(new Course("Microservices in 100 Steps"));
		
		repository.playWithEntityManager();
		
		repository.deleteById(10001L);
		
	}
}
