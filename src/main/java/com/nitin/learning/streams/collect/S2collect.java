package com.nitin.learning.streams.collect;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.stream.Collectors;

public class S2collect {
    public static void main(String[] args) {
        List<EmployeeSimple> simpleEmployees = SampleData.getSimpleEmployees();
        List<EmployeeSimple> collect = simpleEmployees
                .stream()
                .collect(Collectors.toUnmodifiableList());
        collect.add(new EmployeeSimple()); //throws UnsupportedOperationException because we are collecting simpleEmployeeList as a unmodifiable list
    }
}
