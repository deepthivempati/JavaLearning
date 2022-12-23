package com.nitin.learning.designpatterns.strategy;

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


        Model model = Model.builder()
                .name("nitin")
                .build();
        System.out.println(model);

        Model m2 = Model.builder()
                .name("deepthi")
                .lName("vempati")
                .build();
        System.out.println(m2);

        Model m3 = Model.builder()
                .name("Shital")
                .mName("jaykumar")
                .lName("deshpande")
                .build();
        System.out.println(m3);

    }

    public static Integer operation(List<Integer> list, Predicate<Integer> selector) {

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
