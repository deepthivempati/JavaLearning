package com.nitin.learning.l11generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class WC2UpperBounds {
    public static void main(String[] args) {
        List<? extends Number> numbers = Arrays.asList(3.14,(22/7),1.0,2);
        System.out.println(sumList(numbers));

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        numbers = integerList;//Working due ot wild card

        System.out.println(sumList(numbers));
    }

    private static Number sumList(List<? extends Number> numberList) {

        return numberList.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
