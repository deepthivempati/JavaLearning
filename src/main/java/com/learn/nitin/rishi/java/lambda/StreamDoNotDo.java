package com.learn.nitin.rishi.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamDoNotDo {
    public static void main(String[] args) {

        // List -> transformed list with double even numbers
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> integerTransformedList = transformation(integerList);

        //integerTransformedList.forEach(x-> System.out.println(x));

        // List -> transformed list with double odd numbers
        List<Integer> integerTransformedList2 = transformationOdd(integerList);

        integerTransformedList2.forEach(x-> System.out.print(x + " "));
    }

    private static List<Integer> transformation(List<Integer> integerList) {
        List<Integer> integers = integerList.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .collect(Collectors.toList());
        return integers;
    }

    private static List<Integer> transformationOdd(List<Integer> integerList) {
       List<Integer> list = new ArrayList<>();

        //Works until now, but stooped all of a sudden
        // Code behaves - erratically with parallel Stream
       integerList.parallelStream()
               .filter(num -> num%2 != 0)
               .map(num -> num*2)
               .forEach(num -> list.add(num));//shared Mutability
                //BAD IDEA with ParallelStream - due to shared mutability - this is impure
        return list;
    }
}
