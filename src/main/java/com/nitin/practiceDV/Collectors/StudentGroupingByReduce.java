package com.nitin.practiceDV.Collectors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static com.nitin.practiceDV.Collectors.StudentPartitioningBy.students;
import static java.util.stream.Collectors.*;

// finding the student with the best and worst grade in respective city
public class StudentGroupingByReduce {
    public static void main(String[] args) {
        Map<String, Optional<Student>> collect = students
                .stream()
                .collect(
                        groupingBy(Student::getCity, maxBy(Comparator.comparing(Student::getAvgGrade))
                        )
                );
        //TODO: Optional<Student> to Student
    }
}
