package com.example.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.data.jpa.entity.User;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User,Integer>{

}
