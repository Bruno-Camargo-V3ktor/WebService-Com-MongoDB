package dev.v3ktor.WebServiceComMongoDB.rest.dto;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    //ATRIBUTOS
    private String id;
    private String name;

    //CONSTRUTORES
    public AuthorDTO() {}
    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    //GETTERS & SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


}
