package com.learn.nitin.learning.l10collectors.c7collectingAndThen;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThenComposing {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find the names of the employees and the count
        Map<String, Integer> nameCount =
                employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(
                        Collectors.groupingBy(
                                EmployeeSimple::getName,// first argument of grouping By -> a function to extract name as key of the map
                                Collectors.collectingAndThen(// second argument of grouping by -> Collector
                                        Collectors.counting(),// first argument of collectingAndThen is a Collector. counting returns a long
                                        Long::intValue)//second argument is a function called a finisher function
                                //Function.identity() can be used if there is no mapper/transformer/convertor/enricher needed
                                )
                        );

        System.out.println(nameCount);
    }
}
