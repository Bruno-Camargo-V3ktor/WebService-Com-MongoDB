package dev.v3ktor.WebServiceComMongoDB.model.repository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> { }