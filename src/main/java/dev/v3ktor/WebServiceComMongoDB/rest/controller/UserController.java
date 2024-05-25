package dev.v3ktor.WebServiceComMongoDB.rest.controller;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    //ATRIBUTOS


    //ENDPOINTS
    @GetMapping()
    public ResponseEntity< List<User> > getAll()
    {
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> users = Arrays.asList(maria, alex);
        return ResponseEntity.ok( users );
    }

}
