package com.resumematcher.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException() {
        super("Usuário não encontrado no banco de dados");
    }
}
