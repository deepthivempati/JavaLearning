package com.nitin.learning.l2strings.stringMethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrContainsAndMatchs {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rakeshreddy reddy", "Kavita Reddy", "Malvika malkireddy",
                "yogitha malgireddy", "Deepthi Vempati", "Reddy", "redDy");
        List<String> list1 = list
                .stream()
                //.filter(s -> s.matches("[rR][eE][dD][dD][yY]"))
                .filter((s -> s.contains("Reddy")))
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
