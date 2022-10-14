package com.learn.learning.collectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetLearn {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);

        Set<Integer> set = new HashSet<>();
        for (Integer x : list){
            set.add(x);
        }

        System.out.println(set.size());
        System.out.println(set);

    }
}
