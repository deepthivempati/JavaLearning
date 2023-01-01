package com.learn.nitin.learning.l2strings.stringMethods;

public class StrBlank {
    public static void main(String[] args) {
        System.out.println("".isBlank());//True
        System.out.println(" ".isBlank());//True -> Returns true if the string is empty or contains only white space
        System.out.println("Malgudi Days".isBlank());//False
    }
}
