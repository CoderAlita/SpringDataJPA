package com.example.data.jpa;

import com.example.data.jpa.dao.UserRepository;
import com.example.data.jpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
		UserRepository repo = context.getBean(UserRepository.class);
		User user= new User();
		user.setName("CoderAlita");
		user.setCity("Mumbai");
		user.setStatus("Java Developer");
		User u =repo.save(user);

		System.out.println(u);
	}

}
