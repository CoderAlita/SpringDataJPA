package com.example.data.jpa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.data.jpa.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends CrudRepository<User,Integer>{

    public List<User> findByName(String name);

    public List<User> findByCityAndStatus(String city, String status);


    @Query("select name from User u")
    public List<String> getUsersName();

    @Query("select u from User u where u.city =:c ")
    public List<User> getUserByCity(@Param("c") String city);
}
