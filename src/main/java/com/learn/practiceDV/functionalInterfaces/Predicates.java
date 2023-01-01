package com.learn.practiceDV.functionalInterfaces;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.Employee;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        Predicate<String> length = String::isEmpty; //s-> s.isEmpty();
        String s = "";
        System.out.println(length.test(s));

        List<Employee> sampleData = SampleData.getEmployees();
        Predicate<Employee> emp = employee -> employee.getExperience() == 6;
        Boolean eqlToSix = sampleData
                .stream()
                .filter(emp)
                .findFirst()
                .isPresent();
        System.out.println(eqlToSix);

        List<Employee> sampleData1 = SampleData.getEmployees();
        Predicate<Employee> emp1 = employee -> employee.getExperience() == 6;
        Optional<Employee> eqlToSix1 = sampleData1
                .stream()
                .filter(emp1)
                .findFirst();
        System.out.println(eqlToSix1.get());

    }
}
