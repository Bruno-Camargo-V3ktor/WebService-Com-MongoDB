package dev.v3ktor.WebServiceComMongoDB.model.repository;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    @Query(" { 'title': { $regex: ?0, $options: '' } } ")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainsIgnoreCase(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Instant minDate, Instant maxDate);

}