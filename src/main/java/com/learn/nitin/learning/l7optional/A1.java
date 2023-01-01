package com.learn.nitin.learning.l7optional;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class A1 {
    public static void main(String[] args) {

        List<EmployeeSimple> retList = countByName();
        if (retList.size() == 0){
            System.out.println("Zero size");
        }

        Optional<String> stringOptional = Optional.of(null);//Optional Field - NEVER

        methodName(stringOptional);

    }

    private static List<EmployeeSimple> countByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();//Synchronous

        List<EmployeeSimple> empWithAgeGT30 = null;//TODO: check, come smell

        empWithAgeGT30 =  employees.parallelStream()
                .filter(Objects::nonNull)
                .filter(emp -> null != emp.getAge())
                .filter(emp -> emp.getAge() >30)
                .collect(Collectors.toList());
                //.forEach(emp -> finalEmpWithAgeGT3.add(emp));//mutation -> not thread safe operation -> impure function

        //return Collections.emptyList();

        //using Static Factory - takes care of empty List
        return List.of();//Returns empty list
    }

    public static void methodName(Optional<String> name){ //Anti-pattern - DO NOT DO THIS
        return;
    }

    public static void methodName1(String name){
        return;
    }

    public static void methodName(){ //Overloaded
        return;
    }

}
