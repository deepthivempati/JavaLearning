package com.learn.learning.strings.stringMethods;

public class StrStrip {
    public static void main(String[] args) {
        String s = " Malgudi Days   ";

        System.out.println(s.trim());

        System.out.println(s.strip());//Strip is Unicode Aware
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }
}
