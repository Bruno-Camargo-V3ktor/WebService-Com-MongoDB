package dev.v3ktor.WebServiceComMongoDB.rest.controller;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/posts")
public class PostController {

    //ATRIBUTOS
    @Autowired
    private PostService service;

    //ENDPOINTS
    @GetMapping("/{ID}")
    public ResponseEntity<Post> getById( @PathVariable("ID") String id )
    {
        Post entity = service.getById(id);
        return ResponseEntity.ok( entity );
    }


}
