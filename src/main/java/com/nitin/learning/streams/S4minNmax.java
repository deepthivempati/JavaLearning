package com.nitin.learning.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:49 AM.
 * Returns an optional
 */
public class S4minNmax {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        //min accepts comparator to sort
        String min = list.stream().min((str1, str2) -> str1.compareTo(str2)).get();
        System.out.println(min);

        String max = list.stream().max((str1, str2) -> str1.compareTo(str2)).get();
        System.out.println(max);

        Stream<String> stringList = Stream.of("Cat", "Dog", "Elephant", "Frog", "Goat");
        //min needs a comparator
        Optional<String> min2 = stringList.min((s1, s2) -> s1.compareToIgnoreCase(s2));
        min2.ifPresent(System.out::println);
        //get also return the same thing
        System.out.println(min2.get());
    }
}
