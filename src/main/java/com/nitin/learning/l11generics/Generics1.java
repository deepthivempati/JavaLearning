package com.nitin.learning.l11generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3));
        int sum = 0;

        list.add(Integer.valueOf(4));//Adding Wrapper Class
        list.add(5);//Adding primitive, auto boxing happening

        int a = list.get(list.size()-1);
        int b = list.get(3);//Auto unboxing performed and assigned to a primitive
        Integer c = list.get(3);

        System.out.println(c.getClass());
    }
}
