package com.learn.nitin.learning.I11parallelStreams;

import com.learn.nitin.utilities.MultiThreadUtility;
import com.learn.nitin.utilities.PerformanceUtility;

import java.util.List;
import java.util.stream.Stream;

public class PS1Intro {
    public static void main(String[] args) {
        List<Integer> list = List.of(0,1,2,3);

        //sequentialStream(list);
        //parallelStreamwithoutOrder(list);

        //parallelStreamwithOrder(list);
        //parallelFromStream(list.stream());
        sequentialPitfall(list);

        System.out.println("Number of Cores in my machine :: " + PerformanceUtility.noOfCores() + " Total Memory :: "
                + Runtime.getRuntime().totalMemory());

    }

    private static void parallelStreamwithoutOrder(List<Integer> list) {
        list.parallelStream()//use with collections
                .map(num -> incrementAndDelay(num))
                .forEach(num -> getPrint(num));
    }

    private static void sequentialStream(List<Integer> list) {
        list.stream()//use with collections
                .sequential()
                .map(num -> incrementAndDelay(num))
                .forEach(num -> getPrint(num));
    }

    private static void sequentialPitfall(List<Integer> list) {
        list.parallelStream()//use with collections
                .sequential() // this becomes redundant since parallel style is near to reduction.
                .map(num -> incrementAndDelay(num))
                .parallel()//The method closest to the reduction determnins the style sequential or parallel
                .forEachOrdered(num -> getPrint(num));
    }


    private static void parallelStreamwithOrder(List<Integer> list) {
        list.parallelStream()//use with collections
                .map(num -> incrementAndDelay(num))//run in parallel
                .forEachOrdered(num -> getPrint(num));
    }

    private static void getPrint(Integer num) {
        System.out.println(Thread.currentThread() + " :: " + num );
    }

    private static Integer incrementAndDelay(int number) {
        MultiThreadUtility.delay(1000);//Artificial delay
        number = number + 1;

        System.out.println("t: " + Thread.currentThread() + " :: " +number);
        return number;
    }

    private static void parallelFromStream(Stream<Integer> listStream){

        listStream
                .parallel()//use with Streams
                .map(num -> incrementAndDelay(num))
                .forEach(num -> getPrint(num));
    }
}
