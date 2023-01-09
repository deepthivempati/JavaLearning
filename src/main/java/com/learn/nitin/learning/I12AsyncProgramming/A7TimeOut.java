package com.learn.nitin.learning.I12AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;

public class A7TimeOut {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> data + 3)
                .exceptionally(throwable -> handleExceptionally(throwable))
                .thenApply(data -> data * 2)
                .exceptionally(throwable -> handleExceptionally(throwable))
                .thenAccept(data -> System.out.println("Result from Future " + data));


        System.out.println("Pipeline Constructed ...");

        //successOnTimeOut(future);
        failureOnTimeOut(future);
        delay(3000);
        future.complete(2);//original task

        System.out.println("DONE!!");

    }

    private static void successOnTimeOut(CompletableFuture<Integer> future) {
        future.completeOnTimeout(5, 1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
        //for more than a second. the value doesn't arrive in 1 sec (timeout) then resolve it, via the default value
    }

    private static void failureOnTimeOut(CompletableFuture<Integer> future) {
        future.orTimeout(1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
        //for more than a second. the value doesn't arrive in 1 sec (timeout) then resolve it, via the default value
    }

    private static Integer handleExceptionally(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("Sending recovery value from handleExceptionally");
        return -1;
    }
}
