package com.learn.learning.lambda.session2;

import com.learn.utilities.entity.EmployeeSimple;
import com.learn.utilities.SampleData;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
                .filter( emp -> null != emp.getName()
                )
                .filter(salaryNotNull)
                .filter(ageNotNull)
                //.map(stud -> transformer.apply(stud))
                .map(transformer)
                //.map(transformer)
                .collect(Collectors.toList());

       // System.out.println(finalList);

        Consumer<EmployeeSimple> consumer = getEmployeeSimpleConsumer();
        list.stream().forEach(oneemp -> consumer.accept(oneemp));

        list.stream().forEach(consumer);

        list.stream().forEach(getEmployeeSimpleConsumer());
    }

    private static Consumer<EmployeeSimple> getEmployeeSimpleConsumer() {
        return (employeeSimple) -> System.out.println(employeeSimple.getName());
    }
}


