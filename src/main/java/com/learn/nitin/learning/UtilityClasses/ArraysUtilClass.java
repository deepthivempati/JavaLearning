package com.learn.nitin.learning.UtilityClasses;

import java.util.Arrays;
import java.util.List;

public class ArraysUtilClass {
    public static void main(String[] args) {
        int size = 10;

        boolean primitiveBoolArray[] = new boolean[size];//Initialized by default with False
        //Initialize the array with all true
        Arrays.fill(primitiveBoolArray, true);

        Boolean wrapperBoolArray[] = new Boolean[size];
        Arrays.fill(wrapperBoolArray,true);
        System.out.println(wrapperBoolArray);

        List<Integer> integerList = Arrays.asList(1,2);
        int result = integerList.stream().reduce((a,b) -> a+b).orElse(-1);
        System.out.println(result);

        Integer integerArray[] = {1,3,5,7,9,2,4,6,8};
        int result2 = Arrays.stream(integerArray).reduce((a,b) -> a+b).orElse(-1);
        System.out.println(result2);

    }
}
