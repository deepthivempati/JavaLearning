package com.learn.practiceDV.Collectors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static com.learn.practiceDV.Collectors.StudentPartitioningBy.students;
import static java.util.stream.Collectors.*;

// finding the student with the best and worst grade in respective city
public class StudentGroupingBy {
    public static void main(String[] args) {
        Map<String, Optional<Student>> collect = students
                .stream()
                .collect(groupingBy(
                        Student::getCity, //First param
                        maxBy(Comparator.comparing(Student::getAvgGrade))
                        )//End group by
                );//end collect;

        System.out.println(collect);

        //TODO: Optional<Student> to Student
    }
}
