package dev.v3ktor.WebServiceComMongoDB.rest.controller;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    //ATRIBUTOS
    @Autowired
    private UserService service;

    //ENDPOINTS
    @GetMapping()
    public ResponseEntity< List<User> > getAll()
    {
        return ResponseEntity.ok( service.getAll() );
    }

}
