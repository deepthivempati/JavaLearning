package com.nitin.learning.exception;

public class IncorrectEmailIdException extends Exception{
    public IncorrectEmailIdException(String message){
        super(message);
        System.err.println("incorrect emailId");
    }
}
