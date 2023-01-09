package com.learn.nitin.learning.I12AsyncProgramming;

import java.util.concurrent.CompletableFuture;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;
import static com.learn.nitin.utilities.PerformanceUtility.*;

public class A8Compose {
    public static void main(String[] args) {

        //likeSequential();

        CompletableFuture<Double> radiusFuture = CompletableFuture.supplyAsync(() -> getRadius());
        //CompletableFuture<Double> areaFuture = CompletableFuture.supplyAsync(() -> getArea(radius));

        startTimer();
        CompletableFuture<Void> voidCompletableFuture = radiusFuture
                .thenCompose(radius -> CompletableFuture.supplyAsync(() -> getArea(radius)))
                .thenAccept(area -> System.out.println(area));
        stopTimer();


        resetTimer();
        startTimer();
        System.out.println(voidCompletableFuture.join());
        stopTimer();
        //delay(3000);

    }

    private static void likeSequential() {
        startTimer();
        CompletableFuture<Double> radiusFuture = CompletableFuture.supplyAsync(() -> getRadius());

        Double radius = radiusFuture.join();
        CompletableFuture<Double> areaFuture = CompletableFuture.supplyAsync(() -> getArea(radius));

        Double area = areaFuture.join();
        stopTimer();

        resetTimer();
        System.out.println(area);
    }

    public static Double getArea(Double radius){
        delay(1000);
        return Math.PI * radius * radius;
    }
    public static Double getRadius(){
        delay(1000);
        return null;
        //return 2.0;
    }
}
