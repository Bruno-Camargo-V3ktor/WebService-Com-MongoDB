package dev.v3ktor.WebServiceComMongoDB.rest.dto;

import dev.v3ktor.WebServiceComMongoDB.model.entity.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    //ATRIBUTOS
    private String id;
    private String name;
    private String email;

    //CONSTRUTORES
    public UserDTO() {}
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    //GETTERS & SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


}
