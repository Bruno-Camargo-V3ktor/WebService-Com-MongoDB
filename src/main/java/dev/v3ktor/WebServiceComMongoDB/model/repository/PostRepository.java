package dev.v3ktor.WebServiceComMongoDB.model.repository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainsIgnoreCase(String text);

}