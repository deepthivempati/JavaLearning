package com.learn.nitin.learning.I12AsyncProgramming;



import com.learn.nitin.learning.I12AsyncProgramming.covidIndia.functions.DataTransformationFunctions;
import com.learn.nitin.learning.I12AsyncProgramming.covidIndia.service.DataFetchService;
import com.learn.nitin.utilities.entity.CovidIndia;
import com.learn.nitin.utilities.entity.dto.CovidIndiaTransformed;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.learn.nitin.utilities.PerformanceUtility.*;

public class A4CompletableCovidService {
    public static void main(String[] args) {

        DataFetchService dataFetchService = new DataFetchService();

        startTimer();
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> dataFetchService.fetchCovidIndiaData())//returns the completable future of type entity
                .thenApply(covidIndiaList -> getCovidIndiaList(covidIndiaList)) //Applying function to each element of list
                .thenApply(covidIndiaList -> getCovidIndiaTransformedList(covidIndiaList))
                .thenAccept((covidIndiaTransformedList) -> {
                    covidIndiaTransformedList.forEach(x->{});
                });// .join()//waiting operation
        stopTimer();//If join is not used, the operation continues and program reaches here, without actually download the data

        resetTimer();
        startTimer();
            future.join();//Running the pipeline
        stopTimer();
        System.out.println("Completed!!");
    }

    private static List<CovidIndiaTransformed> getCovidIndiaTransformedList(List<CovidIndia> covidIndiaList) {
        return covidIndiaList.stream().map(DataTransformationFunctions.covidFunction).collect(Collectors.toList());
    }

    private static List<CovidIndia> getCovidIndiaList(List<CovidIndia> covidIndiaList) {
        return covidIndiaList
                .stream()
                .sorted(Comparator
                        .comparing(CovidIndia::getDeaths)
                        .reversed()
                        .thenComparing(CovidIndia::getActive))
                .collect(Collectors.toList());
    }
}
