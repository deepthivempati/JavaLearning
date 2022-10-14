package com.learn.learning.lambda.session2;

import com.learn.utilities.entity.EmployeeSimple;
import com.learn.utilities.SampleData;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionLearning {
    public static void main(String[] args) {
        List<EmployeeSimple> list = SampleData.getSimpleEmployees();

        //Emp <name> is earning <salary> at age <age>
        Function<EmployeeSimple, String> transformer = emp -> {
          StringBuilder sb = new StringBuilder();
          sb.append("Emp ").append(emp.getName());
          sb.append(" is earning ").append(emp.getSalary().toString());
          sb.append(" at age ").append(emp.getAge());

          return sb.toString();
        };

        Predicate<EmployeeSimple> nameNotNull = emp -> null != emp.getName();
        Predicate<EmployeeSimple> salaryNotNull = emp -> null != emp.getSalary();
        Predicate<EmployeeSimple> ageNotNull = emp -> null != emp.getAge();


        List<String> finalList = list.stream()
                //.filter(nameNotNull.or(salaryNotNull).or(ageNotNull))
                .filter(nameNotNull)
                .filter(salaryNotNull)
                .filter(ageNotNull)
                .map(stud -> transformer.apply(stud))
                //.map(transformer)
                .collect(Collectors.toList());

        System.out.println(finalList);
    }
}


