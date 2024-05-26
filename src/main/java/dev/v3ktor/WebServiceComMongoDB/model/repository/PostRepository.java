package dev.v3ktor.WebServiceComMongoDB.model.repository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    @Query(" { 'title': { $regex: ?0, $options: '' } } ")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainsIgnoreCase(String text);

}