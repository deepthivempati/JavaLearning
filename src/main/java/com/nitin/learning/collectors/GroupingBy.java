package com.nitin.learning.collectors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);

        //Find frequency of all the numbers
        Map<Integer,Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        Map<Integer,Integer> freqMap = new HashMap<>();
        for (Integer i : list){
            freqMap.put(i,freqMap.getOrDefault(i,0) + 1);
//            if(freqMap.containsKey(i))
//                freqMap.put(i,freqMap.get(i)+1);
//            else
//                freqMap.put(i,1);

        }

        System.out.println(map);
        System.out.println(freqMap);



    }
}
