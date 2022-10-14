package com.learn.learning.exception;

//User defined exceptions should always be CHECKED
public class CannotEatException extends Exception{
    public CannotEatException(){
        super();
        System.err.println("You cannot eat :: ");
    }

    public CannotEatException(String message){
        super(message);
        //System.out.println("You cannot eat :: " + message); //out is used to display results on the console.
        System.err.println("You cannot eat :: " + message); //err is used to display output error texts on the console.
    }

    public CannotEatException(Exception e){
        super(e);
    }
}
