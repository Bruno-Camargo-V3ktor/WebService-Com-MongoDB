package dev.v3ktor.WebServiceComMongoDB.rest.controller;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.rest.dto.UserDTO;
import dev.v3ktor.WebServiceComMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    //ATRIBUTOS
    @Autowired
    private UserService service;

    //ENDPOINTS
    @GetMapping()
    public ResponseEntity< List<UserDTO> > getAll()
    {
        List<User> users = service.getAll();
        List<UserDTO> dtos = users.stream().map( (user) -> new UserDTO(user) ).toList();

        return ResponseEntity.ok( dtos );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById( @PathVariable("id") String id )
    {
        User obj = service.getById(id);
        return ResponseEntity.ok( new UserDTO(obj) );
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(  @RequestBody UserDTO obj ) throws URISyntaxException
    {
        User user = service.fromDTO(obj);
        user = service.insert(user);

        return ResponseEntity.created( new URI("/api/users")).body( new UserDTO(user) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById( @PathVariable("id") String id )
    {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{ID}")
    public ResponseEntity<UserDTO> updateById( @PathVariable("ID") String id, @RequestBody UserDTO obj )
    {
        User user = service.updateById(id, service.fromDTO(obj));
        return ResponseEntity.ok( new UserDTO(user) );
    }

    @GetMapping("/{ID}/posts")
    public ResponseEntity< List<Post> > getPostsByUserId(@PathVariable("ID") String id )
    {
        User obj = service.getById(id);
        return ResponseEntity.ok( obj.getPosts() );
    }

}
