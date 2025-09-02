package com.resumematcher.exceptions;

public class UserEmailExistsException extends RuntimeException{
    public UserEmailExistsException(String message){
        super(message);
    }
    public UserEmailExistsException() {
        super("Email já cadastrado");
    }
}
