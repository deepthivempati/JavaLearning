package com.nitin.practiceDV.Collectors;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
public class Student {
    private String name;
    private String city;
    private double avgGrade;
    private int age;
}
