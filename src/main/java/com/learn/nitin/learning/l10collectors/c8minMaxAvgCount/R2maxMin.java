package com.learn.nitin.learning.l10collectors.c8minMaxAvgCount;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class R2maxMin {
    public static void main(String[] args) {

        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find employee with Max Age using Streams
        minMaxIntro(employees);

        //Find maxBy minBy via Collectors
        minByMaxByIntro(employees);
    }
    private static void minByMaxByIntro(List<EmployeeSimple> employees) {
        EmployeeSimple collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.maxBy(
                        Comparator.comparing(EmployeeSimple::getAge)))
                .orElse(new EmployeeSimple());

        System.out.println(collect.getAge());

        int minAge;//TODO: find way to utilize optional
        Integer minSalary = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(EmployeeSimple::getAge)),
                                emp -> emp.map(EmployeeSimple::getAge).orElseThrow()
                        )
                );
    }

    private static void minMaxIntro(List<EmployeeSimple> employees) {
        int maxAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .mapToInt(EmployeeSimple::getAge)
                .max().orElse(-1);
        System.out.println(maxAge);

        int minAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .map(EmployeeSimple::getAge)
                .min(Comparator.comparing(Integer::intValue))//Obvious comparing
                .orElse(-1);
        System.out.println(minAge);
    }
}
