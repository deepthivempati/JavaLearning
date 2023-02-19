package com.learn.nitin.rishi.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StrategyDesignPattern {

    public static void main(String[] args) {

        // List -> transformed list with double even numbers
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> integerTransformedList = transformation(integerList);
        List<Integer> integerTransformedList2 = transformationOdd(integerList);
        List<Integer> integerTransformedList3 = transformationOdd(integerList);

    }

    private static List<Integer> transformation(List<Integer> integerList) {
        List<Integer> integers = integerList.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .collect(Collectors.toList());
        return integers;
    }

    private static List<Integer> transformationOdd(List<Integer> integerList) {
        List<Integer> integers = integerList.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * 2)
                .collect(Collectors.toList());
        return integers;
    }

    private static List<Integer> transformation3(List<Integer> integerList) {
        List<Integer> integers = integerList.stream()
                .filter(num -> num % 2 == 0)
                //.map(num -> num * 2)
                .collect(Collectors.toList());
        return integers;
    }
}
