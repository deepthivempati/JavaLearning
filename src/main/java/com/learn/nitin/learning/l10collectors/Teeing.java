package com.learn.nitin.learning.l10collectors;


import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class Teeing {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

      /*  Pair<Integer, Integer> collect = list.stream()
                .collect(Collectors.teeing(
                                Collectors.maxBy(Integer::compare),//Max of the list
                                Collectors.minBy(Integer::compare),//Second parameter
                                (min, max) -> new Pair<>(min.orElse(-1), max.orElse(-1)) //Bifunction third param
                        )
                );*/

       // System.out.println(collect.getFirst());

    }
}
