package com.learn.nitin.learning.I12AsyncProgramming;

import com.learn.nitin.learning.I12AsyncProgramming.covidIndia.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;

public class A9thenCombine {
    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> dataFetchService.greetingsService());
        CompletableFuture<String> firstNameFuture = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService());
        CompletableFuture<String> lastNameFuture = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService());


        CompletableFuture<String> future = helloFuture
                .thenCombine(firstNameFuture, (hello, firstname) -> getString(hello, firstname))
                .thenCombine(lastNameFuture, (helloFirstName, lastname) -> getString(helloFirstName, lastname))
                .thenCombine(CompletableFuture.supplyAsync(() -> "!!"), (prev, exclaim) -> getString(prev, exclaim))
                .thenApply(String::toUpperCase)
                 //.thenAccept(data -> System.out.println(data))
                ;
        //delay(4000);
        System.out.println(future.join());

    }

    private static String getString(String str1, String str2) {
        return str1 + " " + str2;
    }
}
