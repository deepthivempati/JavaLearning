package com.learn.nitin.learning.l8designpatterns.strategy;

import java.util.List;
import java.util.function.Predicate;

public class StrategyDesign {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7,8,9);

        System.out.println(operation(list, num -> num %2 == 0));
        System.out.println(operation(list, num -> num %2 != 0));

        System.out.println("--------------");
        System.out.println(operationWithStreams(list, num -> num %2 == 0));
        System.out.println(operationWithStreams(list, num -> num %2 != 0));

        System.out.println(list);
    }

    public static Integer operation(List<Integer> list, Predicate<Integer> selector) {
        //Imperative style : Can be avoided due shared mutability.
        int total = 0;

        for (var num : list){
            if (selector.test(num)){
                total = total + num;
            }
        }

        return total;
    }

    public static double operationWithStreams(List<Integer> list, Predicate<Integer> selector) {

      return list.stream()
              .filter(selector)
              .mapToDouble(num -> Double.valueOf(String.valueOf(num)))
              .sum();
    }
}
