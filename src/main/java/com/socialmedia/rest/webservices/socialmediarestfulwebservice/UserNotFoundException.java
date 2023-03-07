package com.socialmedia.rest.webservices.socialmediarestfulwebservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(String message){
        super(message);

    }
}
