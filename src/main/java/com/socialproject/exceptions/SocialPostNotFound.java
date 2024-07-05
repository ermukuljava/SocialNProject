package com.socialproject.exceptions;


public class SocialPostNotFound extends RuntimeException{

    public SocialPostNotFound(String message){
        super(message);
    }
}
