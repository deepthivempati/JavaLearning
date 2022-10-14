package com.nitin.learning.exception;

public class Driver {
    public static void main(String[] args) {

        try {
            System.out.println(eatMe("NonVeg"));
        } catch (CannotEatException e) {
            e.printStackTrace();
        }
    }

    private static String eatMe(String item) throws CannotEatException{
        if(item.equals("NonVeg")){
            throw new CannotEatException(item);
        }else {
            System.out.println("VegMeal");
        }
        return item;
    }
}
