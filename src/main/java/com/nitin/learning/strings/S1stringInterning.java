package com.nitin.learning.strings;

public class S1stringInterning {
    /**
     *         // Two ways of Creating a String (new and "someStr")
     *
     *         When we use double quotes to create a string, it first looks
     *         for the string with the same value in the String Pool. If found it
     *         just returns the reference
     *
     *         "" conserves memory  ->  FLYWAY DESIGN PATTERN -> HomeWork
     */
    public static void main(String[] args) {

        /* Both the String variables are created on the Stack but reference to the same String on heap */
        String str1 = "Books";
        String str2 = "Books";

        testAddress(str1, str2);

        String str3 = new String("Books");// Forcing to create a new String
        testAddress(str1,str3);
        String str4 = "Books".intern();//Explicit interning
        testAddress(str1,str4);//Explore the oputput

    }

    private static void testAddress(String str1, String str2) {
        if(str1 == str2){//this == tests object address not the object value
            System.out.println("Same Address");
        } else {
            System.out.println("Different Address");
        }

        /*if(str1.equals(str2)){//This tests the values
            System.out.println("Same Values");
        }*/
    }
}
