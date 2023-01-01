package com.learn.nitin.learning.l11generics.wildcards;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class WC1Unbounded {
    public static void main(String[] args) {
        //? is the unbounded wild card
        List<?> list = Arrays.asList("test", 3.14, (22/7), LocalDateTime.now(), 'c');

        System.out.println(list.size());

        System.out.println(list.contains(22/7));
        System.out.println(list.contains("test"));

    }
}
