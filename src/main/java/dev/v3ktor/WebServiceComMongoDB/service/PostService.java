package dev.v3ktor.WebServiceComMongoDB.service;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.model.repository.PostRepository;
import dev.v3ktor.WebServiceComMongoDB.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Post> getByTitle(String text)
    {
        return postRepository.findByTitleContainsIgnoreCase(text);
    }

}
