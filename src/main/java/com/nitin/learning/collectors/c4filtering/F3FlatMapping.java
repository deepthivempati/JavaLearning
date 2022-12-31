package com.nitin.learning.collectors.c4filtering;

import java.util.List;
import java.util.stream.Collectors;

public class F3FlatMapping {
    public static void main(String[] args) {

           // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
           // <R> Stream<R> map    (Function<? super T, ? extends R> mapper);

        //groupingBy, mapping, filtering -> taking first argument (function or predicate) and second argument as Collector
        // It means, first apply the function or Predicate and then Collect

        //collectingAndThen -> Collector as first argument adn then Function as second argument

        //map first and flattening later -> mapFlattening -> flatMap
        List<Integer> numbers = List.of(1,2,3,4);

        one2oneMapping(numbers);
        one2ManyMapping(numbers);
        one2ManyFlatMapping(numbers);

    }

    private static void one2ManyFlatMapping(List<Integer> numbers) {

        List<Integer> collect = numbers.stream()
                .flatMap(element -> List.of(element + 1, element - 1).stream())
                .collect(Collectors.toList());//[2, 0, 3, 1, 4, 2, 5, 3]

        System.out.println(collect);
    }

    private static void one2ManyMapping(List<Integer> numbers) {

        List<List<Integer>> collect = numbers.stream()
                .map(element -> List.of(element + 1, element - 1))
                .collect(Collectors.toList());//[[2, 0], [3, 1], [4, 2], [5, 3]]

        System.out.println(collect);
    }

    private static void one2oneMapping(List<Integer> numbers) {

        List<Integer> collect = numbers.stream()
                .map(element -> element * 2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
