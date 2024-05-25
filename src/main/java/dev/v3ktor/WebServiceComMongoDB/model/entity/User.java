package dev.v3ktor.WebServiceComMongoDB.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    //ATRIBUTOS
    private String id;
    private String name;
    private String email;

    //ASSOCIAÇÕES
        //...

    //CONSTRUTORES
    public User() {}
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //GETTERS & SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //HASHCODE & EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
