package dev.v3ktor.WebServiceComMongoDB.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;


public interface UserRepository extends MongoRepository<User, String> {  }