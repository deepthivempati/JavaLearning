package com.nitin.learning.UtilityClasses;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsUtilClass {
    public static void main(String[] args) {

        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        List<List<EmployeeSimple>> singleEmployee = new ArrayList<>();
        employees.stream()
                .filter(data -> null != data.getAge())
                .sorted(Comparator.comparing(EmployeeSimple::getAge).reversed())//Most aged employee
                .findFirst()
                .ifPresentOrElse(
                        value -> singleEmployee.add(Collections.singletonList(value)),
                        () -> singleEmployee.add(Collections.emptyList()));
    }
}

