package dev.v3ktor.WebServiceComMongoDB.service;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.model.repository.UserRepository;
import dev.v3ktor.WebServiceComMongoDB.rest.dto.UserDTO;
import dev.v3ktor.WebServiceComMongoDB.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    //QUERYS
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

    public User insert(User obj)
    {
        return userRepository.insert(obj);
    }

    public void deleteById(String id)
    {
        User obj = userRepository.findById(id)
                        .orElseThrow( () -> new ObjectNotFoundException(String.format("Object with id: (%s) not found", id)) );
        userRepository.delete(obj);
    }

    public User updateById(String id, User obj)
    {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException(String.format("Object with id: (%s) not found", id)) );

        user.setName( obj.getName() );
        user.setEmail( obj.getEmail() );

        return userRepository.save( user );
    }

    //MÉTODOS
    public User fromDTO(UserDTO dto)
    {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
