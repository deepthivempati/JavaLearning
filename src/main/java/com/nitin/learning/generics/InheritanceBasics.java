package com.nitin.learning.generics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InheritanceBasics {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("Nitin");
        list.add(LocalDateTime.now());
        list.add(3.14);

        System.out.println(list);

        List<String> listString = new ArrayList<>();
        listString.add("Shital");
        listString.add("Deepthi");

        //List<Object> objectList = listString;//Invalid, Inheritance does nto happen

        // An Object can contain String
        Object o = new Object();
        o = LocalDateTime.now();
        o= 9.9;
        Object obj = new String();

        if(o instanceof Integer){//Do an instance Of test prior to type casting
        Integer s = (Integer) o;
            System.out.println(s.intValue());

        }

    }
}
