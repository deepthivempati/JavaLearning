package com.nitin.learning.l8designpatterns.strategy.thehardway;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class QuickSort implements Strategy {

    @Override
    public <T> void sort(List<T> list) {
        System.out.println("Quick Sort :: " + list.getClass());
    }

}
