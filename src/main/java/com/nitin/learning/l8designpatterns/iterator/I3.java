package com.nitin.learning.l8designpatterns.iterator;

import java.util.Iterator;
import java.util.List;

public class I3 {
    public static void main(String[] args) {
        List<String> list = List.of("Mimi", "Alvin", "Yolonda", "Donnie", "Delphine");//Find why null is not allowed

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
