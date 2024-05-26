package dev.v3ktor.WebServiceComMongoDB.service;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.model.repository.UserRepository;
import dev.v3ktor.WebServiceComMongoDB.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    //MÉTODOS
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public User getById(String id)
    {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException(String.format("Object with id: (%s) not found", id)) );

        return user;
    }

}
