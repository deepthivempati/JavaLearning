package com.learn.learning.lambda.predefinedFunctionalInterface;

import com.learn.utilities.entity.EmployeeSimple;
import com.learn.utilities.SampleData;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerUsage {
    public static void main(String[] args) {
        List<EmployeeSimple> simpleEmployeesList = SampleData.getSimpleEmployees();

        //name age salary
        Consumer<EmployeeSimple> consumer = (simpleEmp) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(simpleEmp.getName()).append(" ");
            sb.append(simpleEmp.getAge()).append(" ");
            sb.append(simpleEmp.getSalary());
            System.out.println(sb.toString());
        };


        simpleEmployeesList.stream().forEach(simpleEmp -> consumer.accept(simpleEmp));
        //simpleEmployeesList.stream().forEach(consumer);


        System.out.println("Traditional Way");
        //Traditional way
        simpleEmployeesList.stream().forEach(simpleEmp -> {
            StringBuilder sb = new StringBuilder();
            sb.append(simpleEmp.getName()).append(" ");
            sb.append(simpleEmp.getAge()).append(" ");
            sb.append(simpleEmp.getSalary());
            System.out.println(sb.toString());
        });


    }
}
