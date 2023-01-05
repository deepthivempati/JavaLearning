package com.learn.nitin.learning.l10collectors.c9reducing;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Objects;

public class R1reduceIntro {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find total sum of salaries of each employee
        sumWithReduce(employees);
        sumWithOutReduce(employees);


    }


    private static void sumWithOutReduce(List<EmployeeSimple> employees) {
        Double totalSalary =
                employees.stream()
                        .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                        .mapToDouble(EmployeeSimple::getSalary)
                        .average().orElseThrow();

        System.out.println(totalSalary);
    }

    private static void sumWithReduce(List<EmployeeSimple> employees) {
        Double totalSalary =
                employees.stream()
                        .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                        .map(EmployeeSimple::getSalary)
                        .reduce(0.0, Double::sum);
        //.orElse(-1D);

        //Reduce with identity returns a <T>, reduce without identity returns a Optional<T>

        System.out.println(totalSalary);
    }
}
