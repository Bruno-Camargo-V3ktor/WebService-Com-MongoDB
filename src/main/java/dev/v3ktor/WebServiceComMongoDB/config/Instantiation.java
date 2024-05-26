package dev.v3ktor.WebServiceComMongoDB.config;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    //MÉTODOS
    @Override
    public void run(String... args) throws Exception
    {
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll( Arrays.asList(maria, alex, bob) );
    }

}
