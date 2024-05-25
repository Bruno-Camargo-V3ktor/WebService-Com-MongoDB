package dev.v3ktor.WebServiceComMongoDB.service;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.model.repository.UserRepository;
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

}
