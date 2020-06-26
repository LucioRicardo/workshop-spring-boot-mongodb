package com.lucioaraujo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucioaraujo.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
