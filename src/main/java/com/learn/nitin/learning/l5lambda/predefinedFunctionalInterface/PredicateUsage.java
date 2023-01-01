package com.learn.nitin.learning.l5lambda.predefinedFunctionalInterface;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateUsage {
    public static void main(String[] args) {
        List<EmployeeSimple> simpleEmployeesList = SampleData.getSimpleEmployees();


        Predicate<EmployeeSimple> salGt70KPredicate = (simpleEmp) -> {
                return simpleEmp.getSalary() > 70000;
        };

        Predicate<EmployeeSimple> objectNotNull = Objects::nonNull;

        Predicate<EmployeeSimple> salGt70KPredicate1 = simpleEmp -> simpleEmp.getSalary() > 70000;

        System.out.println(salGt70KPredicate.test(simpleEmployeesList.get(0)));

        List<EmployeeSimple> collect = simpleEmployeesList
                .stream()
                .filter(Objects::nonNull)//Whole Object null
                .filter(obj -> null!= obj.getSalary())//fields/properties/variables inside object
                .filter(salGt70KPredicate1)
                //.filter(objectNotNull.and(salGt70KPredicate1).and(obj -> null!= obj.getSalary()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
