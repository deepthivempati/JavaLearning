package com.learn.practiceDV.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
    public class StudentPartitioningBy {
        public static void main(String[] args) {
            Predicate<Student> ageGtr22 = emp -> emp.getAge() >= 24;

            System.out.println(students
                        .stream()
                        .collect(partitioningBy(ageGtr22))
                                //reducing(BinaryOperator.maxBy(Comparator.comparing(Student::getAvgGrade))))
        );
        }
public static List<Student> students = Arrays.asList(
        new Student("Deepthi", "Khammam", 4.75, 24),
        new Student("Divya", "Warangal", 4.80, 23),
        new Student("Spandana", "Khammam", 4.50, 24),
        new Student("Haripriya", "Warangal", 4.60, 23));



//case-1: using collectors that accepts another downstream Collectors, such as partitioningBy() or groupingBy() Collectors and using reducing() method to perform the required reduction.
}
