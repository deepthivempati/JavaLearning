package com.nitin.learning.l11generics.wildcards;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WC3LowerBounds {
    public static void main(String[] args) {
       List<String> list=  Arrays.asList("one", "two", "three", "four", "five", "to",null);

        List<String> stringList = Stream.of("one", "two", "three", "four", "five", "to",null)
        //list.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("FilteredValue = " + e))
                .map(String::toUpperCase)
                //.peek(str -> System.out.println("Mapped Value = " + str))
                .collect(Collectors.toList());


        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

    }
}
