package com.nitin.learning.lambda.predefinedFunctionalInterface;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;
import org.springframework.validation.ObjectError;

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

        Predicate<EmployeeSimple> salGt70KPredicate1 = simpleEmp -> simpleEmp.getSalary() > 70000;

        System.out.println(salGt70KPredicate.test(simpleEmployeesList.get(0)));

        List<EmployeeSimple> collect = simpleEmployeesList
                .stream()
                .filter(Objects::nonNull)//Whole Object null
                .filter(obj -> null!= obj.getSalary())//fields/properties/variables inside object
                .filter(salGt70KPredicate1)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
