package com.learn.nitin.learning.zzz_generics;

import java.util.Arrays;
import java.util.List;

public class InheritanceWRTGenerics {
    public static void main(String[] args) {
        List<Number> numberList  = Arrays.asList(1,2,3,4,5.5);
        System.out.println(sumList(numberList));

        List<Integer> integerList  = Arrays.asList(1,2,3,4);
        //System.out.println(sumList(integerList));//Inheritance doesnot work with Collections. it works with Object

        //The above problem is resolved woth the use of WILD CARD
    }

    private static Number sumList(List<Number> numberList) {
        return numberList.stream()
                .mapToInt(Number::intValue)
                .sum();
    }
}
