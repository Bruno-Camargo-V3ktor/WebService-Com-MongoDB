package dev.v3ktor.WebServiceComMongoDB.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.model.repository.PostRepository;
import dev.v3ktor.WebServiceComMongoDB.rest.exception.ObjectNotFoundException;

@Service
public class PostService {

    //ATRIUBUTOS
    @Autowired
    private PostRepository postRepository;

    //QUERYS
    public Post getById(String id)
    {
        Post obj = postRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException(String.format("Object with id: (%s) not found", id)) );

        return obj;
    }

    public List<Post> getByTitleContains(String text)
    {
        return postRepository.findByTitleContainsIgnoreCase(text);
    }

    public List<Post> getByTitle(String text)
    {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSerach(String text, Instant minDate, Instant maxDate)
    {
        maxDate = maxDate.plus(1, ChronoUnit.DAYS);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
