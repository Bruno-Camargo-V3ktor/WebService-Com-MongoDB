package dev.v3ktor.WebServiceComMongoDB.rest.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.service.PostService;

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


    @GetMapping("/titlesearch")
    public ResponseEntity< List<Post> > getByTitle( @RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "c", defaultValue = "true") Boolean c )
    {
        System.out.println(c);
        List<Post> posts;
        if(c) { posts = service.getByTitleContains(text); }
        else { posts = service.getByTitle(text); }

        return ResponseEntity.ok( posts );
    }

    @GetMapping("/fullsearch")
    public ResponseEntity< List<Post> > getbyFilter(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "1999-01-01") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    )
    {
        Instant min_date = Instant.parse( String.format("%sT00:00:00Z", minDate) );
        Instant max_date;

        if(maxDate.isEmpty()) { max_date = Instant.parse( String.format("%sT00:00:00Z", LocalDate.now()) ); }
        else{ max_date = Instant.parse( String.format("%sT00:00:00Z", maxDate) ); }

        return ResponseEntity.ok( service.fullSerach(text, min_date, max_date) );
    }

}
