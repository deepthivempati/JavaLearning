package com.learn.nitin.learning.l10collectors.c9reducing;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AggregateOperationsDouble {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //summingDoubleRigid(employees);
        //summingDoubleFlexible(employees);

        summarizingdouble(employees);

    }

    private static void summarizingdouble(List<EmployeeSimple> employees) {
        DoubleSummaryStatistics collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.summarizingDouble(EmployeeSimple::getSalary));

        System.out.println(collect.getSum());
    }

    private static void summingDoubleRigid(List<EmployeeSimple> employees) {
        double sum = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .mapToDouble(EmployeeSimple::getSalary)
                .sum();
        System.out.println(sum);
    }

    private static void summingDoubleFlexible(List<EmployeeSimple> employees) {
        Double collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(
                //        Collectors.groupingBy(EmployeeSimple::getName,
                        Collectors.summingDouble(EmployeeSimple::getSalary)
                //        )
                );
        System.out.println(collect);
    }
}
