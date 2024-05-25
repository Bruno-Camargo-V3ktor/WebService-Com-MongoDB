package dev.v3ktor.WebServiceComMongoDB.model.repository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends MongoRepository<User, String> {  }