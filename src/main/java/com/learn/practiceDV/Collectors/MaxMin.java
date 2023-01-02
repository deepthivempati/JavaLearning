package com.learn.practiceDV.Collectors;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MaxMin {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();
        //TODO: Find the map of names with max Salary
        Collector<EmployeeSimple, ?, Optional<EmployeeSimple>> employeeSimpleOptionalCollector = maxBy(Comparator.comparing(EmployeeSimple::getAge));
        Map<String, Optional<EmployeeSimple>> collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(groupingBy(
                                EmployeeSimple::getName,
                        employeeSimpleOptionalCollector
                        )
                );
        System.out.println(collect);

    }
}
