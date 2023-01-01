package com.nitin.practiceDV.Collectors;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static com.nitin.practiceDV.Collectors.StudentPartitioningBy.students;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

// finding the student with the best and worst grade in respective city
public class StudentGroupingByReduce {
    public static void main(String[] args) {
        System.out.println(students
                        .stream()
                        .collect(groupingBy(Student::getCity),
                reducing(BinaryOperator.maxBy(Comparator.comparing(Student::getAvgGrade))))
        );
    }
}
