package com.learn.practiceDV.Collectors;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.learn.practiceDV.Collectors.StudentPartitioningBy.students;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class StudentReducingMaxBy {
    public static void main(String[] args) {
        reducingToAvoidOptional(); //Reducing with identity returns a <T>, reducing without identity returns a Optional<T>
        reducingWithoutGroupingBy(); //without groupingBy also we can use reducing() method
        reducingWithGroupingBy();
    }

    private static void reducingToAvoidOptional() {
        Map<String, Student> studentData = students
                .stream()
                .collect(groupingBy
                        (Student::getCity,
                                reducing(new Student("name", "city", 0.0, 0), // reducing(T identity, BinaryOperator<T> op) --> identity the identity value for the reduction (also, the value that is returned when there are no input elements)
                                        maxBy(Comparator.comparing(Student::getAvgGrade))
                                )
                        )

                );
        System.out.println(studentData);
    }

    private static void reducingWithoutGroupingBy() {

        Double studentDataDouble = students
                .stream()
                .collect(reducing(
                                0.0,
                                Student::getAvgGrade,
                                maxBy(Comparator.comparing(Function.identity()))
                                //maxBy(Comparator.comparingDouble(value -> value)) // why not Function.identity()
                        )
                );
        System.out.println(studentDataDouble);
    }

    private static void reducingWithGroupingBy() {
        Map<String, Double> studentHighestSal = students
                .stream()
                .collect(groupingBy
                        (Student::getCity,
                                reducing(0.0,
                                        Student::getAvgGrade,
                                        maxBy(Comparator.comparing(Function.identity()))
                                )
                        )

                );
        System.out.println(studentHighestSal);

    }
}
