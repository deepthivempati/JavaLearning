package com.learn.nitin.learning.l8designpatterns.strategy.thehardway;

import java.util.List;
import java.util.function.Supplier;

public class Runner {

    public static void main(String[] args) {
        List<Number> list = List.of(1,3,5,7,9,8,6,4,2);
       Context context = new Context();

        context.setStrategy(new BubbleSort());//Strategy is bubbleSort at runtime
        context.sortAlgo(list);//Calling the first way

        context.sortAlgo(list, new QuickSort());

        Supplier<QuickSort> quickSortSupplier = QuickSort::new;
        context.sortAlgo(list, quickSortSupplier.get());

        context.sortAlgo(list, new IndianSort());

    }
}
