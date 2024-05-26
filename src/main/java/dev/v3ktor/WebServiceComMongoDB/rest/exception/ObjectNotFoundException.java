package dev.v3ktor.WebServiceComMongoDB.rest.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message) { super(message); }
}
