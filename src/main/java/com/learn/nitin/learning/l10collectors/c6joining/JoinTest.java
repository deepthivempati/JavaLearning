package com.learn.nitin.learning.l10collectors.c6joining;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "is", "cool");
        String message = String.join(" ", strings);//without using streams
        System.out.println(message);//Java is cool

        String test = strings
                .stream()
                .collect(Collectors.joining(","));
        System.out.println(test);


        String ret = new String();
        for (String str : strings) {
            ret = ret + str + " ";//delimiter
        }

        System.out.println(ret);

        //Remove the last character

    }
}
