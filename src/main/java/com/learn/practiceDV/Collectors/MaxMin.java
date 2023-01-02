package com.learn.practiceDV.Collectors;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class MaxMin {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //TODO: Find the map of names with max Salary
        Map<String, Optional<EmployeeSimple>> collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(groupingBy(
                                EmployeeSimple::getName,
                        maxBy(Comparator.comparing(EmployeeSimple::getAge))
                        )
                );
        System.out.println(collect);


        System.out.println(getMaxSalary(employees));



    }

    public static Map<EmployeeSimple, Double> getMaxSalary(List<EmployeeSimple> empList){
        return empList.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.toMap(
                        Function.identity(),//Key mapper function
                        emp -> emp.getSalary())//Value mapper function
                );
    }
}
