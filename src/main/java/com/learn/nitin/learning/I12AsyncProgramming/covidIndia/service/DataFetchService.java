package com.learn.nitin.learning.I12AsyncProgramming.covidIndia.service;



import com.learn.nitin.utilities.MultiThreadUtility;
import com.learn.nitin.utilities.RestGETReadUtility;
import com.learn.nitin.utilities.entity.CovidIndia;
import com.learn.nitin.utilities.entity.Vehicle;
import com.learn.nitin.utilities.entity.dto.VehicleTransformed;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;
import static com.learn.nitin.utilities.MultiThreadUtility.logMessage;


public class DataFetchService {

    public List<CovidIndia> fetchCovidIndiaData(){
        return RestGETReadUtility.covidReader();
    }

    public List<Vehicle> fetchVehicles(){
        return RestGETReadUtility.getRandomVehicles();
    }

    public String firstNameService(){
        delay(1000);//simulating task completion latency
        logMessage("From firstNameService");
        return "john";
    }

    public String lastNameService(){
        delay(1000);
        logMessage("From lastNameService");
        return "doe";
    }

    public String greetingsService(){
        delay(1000);
        logMessage("From Hello!!");
        return "Hello!!";
    }

    public CompletableFuture<VehicleTransformed> findVehicleWithGreatMileage(List<VehicleTransformed> vehicleList){
        logMessage("From composeVehicleData");
        //Returning the vehicle with maximum mileage
        return CompletableFuture.supplyAsync(() -> vehicleList.stream()
                .sorted(Comparator.comparing(VehicleTransformed::getMileage).reversed())
                .findFirst().get());
    }

    public CompletableFuture<String> futureName(String name){
        return CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return ("Hello " + name );
        });
    }
}
