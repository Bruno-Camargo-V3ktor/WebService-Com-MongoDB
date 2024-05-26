package dev.v3ktor.WebServiceComMongoDB.config;

import dev.v3ktor.WebServiceComMongoDB.model.entity.Post;
import dev.v3ktor.WebServiceComMongoDB.model.entity.User;
import dev.v3ktor.WebServiceComMongoDB.model.repository.PostRepository;
import dev.v3ktor.WebServiceComMongoDB.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration @Profile("test")
public class Instantiation implements CommandLineRunner {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    //MÉTODOS
    @Override
    public void run(String... args) throws Exception
    {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll( Arrays.asList(maria, alex, bob) );

        Post post1 = new Post(null, Instant.parse("2018-03-21T14:52:09Z"), "Partiu Viagem!", "Vou viajar para São Paulo, abraços", maria);
        Post post2 = new Post(null, Instant.parse("2018-03-23T18:12:13Z"), "Bom dia!", "Acordei feliz hoje!", maria);


        postRepository.saveAll( Arrays.asList(post1, post2) );
    }

}
