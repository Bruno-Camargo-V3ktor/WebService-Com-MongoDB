package dev.v3ktor.WebServiceComMongoDB.model.entity;

import dev.v3ktor.WebServiceComMongoDB.rest.dto.AuthorDTO;
import dev.v3ktor.WebServiceComMongoDB.rest.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "post")
public class Post {

    //ATRIBUTOS
    @Id
    private String id;
    private Instant date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    //CONSTRUTORES
    public Post() {}
    public Post(String id, Instant date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }


    //GETTERS & SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Instant getDate() { return date; }
    public void setDate(Instant date) { this.date = date; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public AuthorDTO getAuthor() { return author; }
    public void setAuthor(AuthorDTO author) { this.author = author; }

    public List<CommentDTO> getComments() { return comments; }
    public void setComments(List<CommentDTO> comments) { this.comments = comments; }

    //HASHCODE & EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //


}