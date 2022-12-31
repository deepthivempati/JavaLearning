package com.nitin.learning.l10collectors.c2partitioning;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class Intro {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();//Call from DB

        //Split the list into 2 sub list based on even and odd age
        Predicate<EmployeeSimple> evenAgedEmpPredicate = emp -> emp.getAge() % 2 == 0;

        Map<Boolean, List<EmployeeSimple>> listMap = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge())
                .filter(emp -> null != emp.getAge())
                //.collect(partitioningBy(x -> evenAgedEmpPredicate.test(x)));
                .collect(partitioningBy(evenAgedEmpPredicate));


        System.out.println(listMap);

        doNotDo(employees);
    }

    private static void doNotDo(List<EmployeeSimple> employees) {
        List<EmployeeSimple> evenAgedEmp = employees.stream()
                .filter(Objects::isNull).filter(emp -> null != emp.getAge())
                .filter(employee -> employee.getAge() % 2 == 0)
                .collect(Collectors.toList());

        List<EmployeeSimple> oddAgedEmp = employees.stream()
                .filter(Objects::isNull).filter(emp -> null != emp.getAge())
                .filter(employee -> employee.getAge() % 2 != 0)
                .collect(Collectors.toList());
    }
}
