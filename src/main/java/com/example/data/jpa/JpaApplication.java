package com.example.data.jpa;

import com.example.data.jpa.dao.UserRepository;
import com.example.data.jpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
		UserRepository repo = context.getBean(UserRepository.class);

//		Save

		User user1= new User();
		user1.setName("CoderAlita");
		user1.setCity("Mumbai");
		user1.setStatus("Java Developer");
		User u =repo.save(user1);

		System.out.println("-------------Save user-------------" );
		System.out.println(u);

//		save All
		User user2= new User();
		user2.setName("Ramesh");
		user2.setCity("Pune");
		user2.setStatus("Python Developer");

		User user3= new User();
		user3.setName("Neha");
		user3.setCity("Thane");
		user3.setStatus(".Net Developer");

		List users = List.of(user2,user3);
		Iterable<User> list = repo.saveAll(users);
		System.out.println("-------------Save all users-------------" );
		System.out.println(list);

		//Retrive
		Optional<User>  user4 = repo.findById(2);
		if(user4.isPresent())
			System.out.println("Retrive user" + user4.get());

//		Retrive all
		Iterable<User> allUser =repo.findAll();
		System.out.println("-------------Get All users-------------");
		allUser.forEach(System.out::println);

		//Update

		Optional<User> obj = repo.findById(52);
		User user5= null;
		if(obj.isPresent()){
			user5= obj.get();
		}
		user5.setStatus("Tester");

		User update =repo.save(user5);
		System.out.println("-------------User's status updated-------------");
		System.out.println(user5);



//		DeleteById
		repo.deleteById(53);
		System.out.println("Deleted user by id");

		//DeleteAll list of obj
		Iterable<User> list1 = repo.findAllById(List.of(102,103));
		repo.deleteAll(list1);
		System.out.println("All list of users deleted");
		//Delete all users from table
		repo.deleteAll();
		System.out.println("All users deleted");



	}

}
