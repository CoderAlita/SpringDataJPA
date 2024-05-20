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

		User user7= new User();
		user7.setId(52);
		user7.setName("Laxman");
		user7.setCity("Mathura");
		user7.setStatus("Tester");
		repo.save(user7);
		Optional<User> obj = repo.findById(52);
		User user5= null;
		if(obj.isPresent()){
			user5= obj.get();
		}
		user5.setStatus("MERN stack Developer");

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

//		Custom finder methods

		User user6= new User();
		user6.setName("Madhuri");
		user6.setCity("Kolkata");
		user6.setStatus("Full stack Developer");
		repo.save(user6);
		List<User> findByName =repo.findByName("Madhuri");
		System.out.println("------------------+findByName------------------");
		System.out.println(findByName);

		List<User> result =repo.findByCityAndStatus("Kolkata","Full stack Developer");
		System.out.println("-------------------------findByCityAndStatus--------------------");
		System.out.println(result);

		List<String> names = repo.getUsersName();
		System.out.println("-------------------------------All Users name----------------------");
		System.out.println(names);

		List<User> results =repo.getUserByCity("Kolkata");
		System.out.println("--------------------------getUserByCity------------------------");
		System.out.println(results);

		List<User> result1 = repo.getAllUsers();
		System.out.println("-------------------------getAllUsrs----------------------");
		System.out.println(result1);


	}

}
