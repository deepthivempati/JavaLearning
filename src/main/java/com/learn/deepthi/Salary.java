package com.learn.deepthi;

import com.learn.nitin.utilities.entity.EmployeeSimple;
import com.learn.nitin.utilities.SampleData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Salary {
    public static void main(String[] args) {
        final List<EmployeeSimple> list = SampleData.getSimpleEmployees();
        List<EmployeeSimple> employeeSimple = list
                .stream()
                .map(employeeSalaryMapper())
                .collect(Collectors.toList());
        System.out.println(employeeSimple);
        //System.out.println("Increment Salary by 10% if level C, 15% if level B and 20% if A");
    }

    private static Function<EmployeeSimple, EmployeeSimple> employeeSalaryMapper() {
        return employeeSimple1 -> {
            Double currentSalary = employeeSimple1.getSalary();
            System.out.println(currentSalary);
            if (null != employeeSimple1.getSalary())
                if (employeeSimple1.getLevel() == 'C') {
                    employeeSimple1.setSalary(currentSalary + currentSalary * 0.1);
                } else if (employeeSimple1.getLevel() == 'B') {
                    employeeSimple1.setSalary(currentSalary + currentSalary * 0.2);
                } else {
                    employeeSimple1.setSalary(currentSalary + currentSalary * 0.3);
                }
            return employeeSimple1;
        };
    }
}
