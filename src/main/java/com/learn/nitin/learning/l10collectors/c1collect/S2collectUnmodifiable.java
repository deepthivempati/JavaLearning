package com.learn.nitin.learning.l10collectors.c1collect;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.stream.Collectors;

public class S2collectUnmodifiable {
    public static void main(String[] args) {
        List<EmployeeSimple> simpleEmployees = SampleData.getSimpleEmployees();
        List<EmployeeSimple> collect = simpleEmployees
                .stream()
                .collect(Collectors.toUnmodifiableList());
        collect.add(new EmployeeSimple()); //throws UnsupportedOperationException because we are collecting simpleEmployeeList as a unmodifiable list
    }
}
