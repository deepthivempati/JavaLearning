package com.nitin.practiceDV;

import com.nitin.practiceDV.practiceEntity.Mobiles;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        Mobiles mobiles = new Mobiles("iphone", 99999, 1122334455.00);
        Mobiles mobile = new Mobiles(null, null, 99887766.00);

                          /***************Optional.empty()*****************/
        Optional<String> emptyStock = Optional.empty();
        System.out.println(emptyStock);

                          /****************Optional.of()*******************/
        Optional<Integer> mobilePrice = Optional.of(mobiles.getPrice());
//        System.out.println(mobilePrice);
        System.out.println(mobilePrice.get()); // get methods prints the value in optional

                           /************Optional.ofNullable()*********/
        Optional<String> noMobiles = Optional.ofNullable(mobile.getModel());
//        System.out.println(noMobiles); // gives Optional.empty since there is null values instead of throwing an exception like Optional.of case
//        System.out.println(noMobiles.orElse("There are no mobiles left in stock")); // prints default message if null is present
//        System.out.println(noMobiles.orElseThrow(() -> new IllegalArgumentException("iphones are out of stock"))); // gives our custom exception
        System.out.println(noMobiles.map(String::toUpperCase).orElseGet(() -> "no String to convert to uppercase"));

        /*if(noMobiles.isPresent()){
            System.out.println(noMobiles.get()); // doesn't print anything
        }*/
    }
}

// if the value we are passing is never null use Optional.of
//if we know it may or maynotbe null then use Optional.ofNullable