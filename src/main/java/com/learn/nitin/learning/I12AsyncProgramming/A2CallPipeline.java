package com.learn.nitin.learning.I12AsyncProgramming;

import com.learn.nitin.utilities.InternetUtilities;
import com.learn.nitin.utilities.MultiThreadUtility;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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

        future.complete(InternetUtilities.bringWordListFromNet());//Evaluates lazily. The pipeline executes from this point on

        System.out.println("Post Future");
    }

    private static String getTransformedString(String word) {
        MultiThreadUtility.delay(10);
        return word.toUpperCase();
    }

    private static void intro() {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> data*2)
                .thenApply(data -> data+1)
                .thenAccept(data -> System.out.println("Result from Future " + data));

        System.out.println("Pipeline is built....");

        future.complete(2);//Evaluates lazily. The pipeline executes from this point on
    }
}
