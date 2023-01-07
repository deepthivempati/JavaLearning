package com.learn.nitin.learning.I12AsyncProgramming;

import com.learn.nitin.utilities.InternetUtilities;
import com.learn.nitin.utilities.MultiThreadUtility;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;

public class A2CallPipeline {
    public static void main(String[] args) {
        //intro();
        intro2();
    }

    private static void intro2() {
        CompletableFuture<List<String>> future = new CompletableFuture<>();

        future
                .thenApply(data -> data.stream().limit(10).collect(Collectors.toList()))
                .thenApply(data -> {
                    return data.stream()
                            .map(word -> getTransformedString(word))
                            .collect(Collectors.toList());

                })
                .thenAccept(data -> data.forEach(str -> System.out.println("Word is :: " + str)));

        System.out.println("Pipeline is built....");

        delay(3000);
        future.complete(InternetUtilities.bringWordListFromNet());//Evaluates lazily. The pipeline executes from this point on

        System.out.println("Post Future");
    }

    private static String getTransformedString(String word) {
        delay(1000);
        return word.toUpperCase();
    }

    private static void intro() {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> 2/data*2)
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return 9;
                })
                .thenApply(data -> data+1)
                .thenAccept(data -> System.out.println("Result from Future " + data))
                .thenRun(()-> System.out.println("Process Completed!!"));

        System.out.println("Pipeline is built....");

        delay(4000);
        future.complete(0);//Evaluates lazily. The pipeline executes from this point on
    }
}
