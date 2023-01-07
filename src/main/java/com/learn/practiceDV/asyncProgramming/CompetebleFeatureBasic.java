package com.learn.practiceDV.asyncProgramming;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompetebleFeatureBasic {
    public static void main(String[] args) {
        CompletableFuture<List<Integer>> competebleFuture = getData();
        competebleFuture
                .thenApply(List::size)
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return 0;//Default value to return if the exception occurs
                })
                .thenAccept(x -> System.out.println(16/x))// Here x is 8 which accepts the value of thenApply method.thenAccept accepts consumer which returns void.
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return null; //Default value of void to return if the exception occurs
                })
                .thenAccept(x-> System.out.println(x)) // The size of array is 8 which is consumed by above statement. so here it returns null since x holds nothing.
                .thenRun(() -> System.out.println("thenRun method accepts Runnable action & returns new CompletableFuture"));
    }
    private static CompletableFuture<List<Integer>> getData(){
        return CompletableFuture.supplyAsync(()-> List.of(1,2,3,4,5,6,7,8));
    }
}
