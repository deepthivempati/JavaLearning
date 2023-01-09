package com.learn.nitin.learning.I12AsyncProgramming;

import com.learn.nitin.learning.I12AsyncProgramming.covidIndia.service.DataFetchService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;
import static com.learn.nitin.utilities.PerformanceUtility.*;

public class A5ThreadOfExecution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DataFetchService dataFetchService = new DataFetchService();
        System.out.println(Thread.currentThread() + " :: main");

        //Takes total time equal to sum total of individual method times
        //total time = method1 + method2 + method3
        //sequentialProgramRunningInOneThread(dataFetchService);

        //Takes time based on the slowest method. total time = Max(method1, method2, method3) + tiny extra processing time
        AsyncRun(dataFetchService);

    }

    private static void AsyncRun(DataFetchService dataFetchService) throws InterruptedException, ExecutionException {
        startTimer();
        // May run in the main thread if all the executions are done,
        // or it may run in a different thread
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(()-> dataFetchService.greetingsService());
        //delay(2000);
        CompletableFuture<String> firstNameFuture = CompletableFuture.supplyAsync(()-> dataFetchService.firstNameService());
        CompletableFuture<String> lastNameFuture = CompletableFuture.supplyAsync(()-> dataFetchService.lastNameService());
        stopTimer();//Shows the time of pipeline Creation - NOT EXECUTION

        resetTimer();

        startTimer();//Actual call to the pipeline
        System.out.println(helloFuture.join()  + " "+  firstNameFuture.join() + " "+ lastNameFuture.join());//Prefer join instead of GET
        stopTimer();
    }

    private static void sequentialProgramRunningInOneThread(DataFetchService dataFetchService) {
        //Example service, could be a DB Call or a REST Call to outside Service or anyService Call (KafkaQueue, other messaging Queue)
        startTimer();
        String hello = dataFetchService.greetingsService();
        String firstName = dataFetchService.firstNameService();
        String lastName = dataFetchService.lastNameService();
        stopTimer();

        System.out.println(hello  + " "+  firstName + " "+ lastName);
        resetTimer();
    }
}
