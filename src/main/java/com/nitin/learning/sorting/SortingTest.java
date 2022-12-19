package com.nitin.learning.sorting;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingTest {
    public static void main(String[] args) {
        Integer integerArray[] = {1, 3, 5, 7, 9, 2, 4, 6, 8};

        //Sorting simple list/Arrays
        Arrays.sort(integerArray);//Default natural sorting order, increasing
        Arrays.sort(integerArray, Comparator.reverseOrder());
        System.out.println(integerArray);

        List<Student> studentList = SampleData.getStudents();
        //sorting the list Directly
        studentList.sort(Comparator
                .comparing(Student::getFirstName)
                .thenComparing(Student::getLastName));//sorts the original List

        //Sorting via Streams
        List<Student> sortedStudentList = studentList.stream()
                .sorted(Comparator
                        .comparing(Student::getFirstName)
                        .thenComparing(Student::getLastName))
                .collect(Collectors.toList());//To Collect is IMPORTANT

        Student studentArray[] = studentList.toArray(new Student[studentList.size()]);

        //sorting via Arrays
        Arrays.sort(studentArray, Comparator
                .comparing(Student::getFirstName)
                .thenComparing(Student::getLastName));


        System.out.println(studentArray);

        //sorting via Collections
        Collections.sort(studentList, Comparator
                .comparing(Student::getFirstName).reversed()
                .thenComparing(Student::getLastName).reversed());
    }
}
