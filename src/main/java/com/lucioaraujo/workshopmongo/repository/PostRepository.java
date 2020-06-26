package com.lucioaraujo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucioaraujo.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
