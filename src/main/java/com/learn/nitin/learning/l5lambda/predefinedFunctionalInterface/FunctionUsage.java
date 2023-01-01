package com.learn.nitin.learning.l5lambda.predefinedFunctionalInterface;

import com.learn.nitin.utilities.SampleData;
import com.learn.nitin.utilities.entity.EmployeeSimple;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionUsage {
    public static void main(String[] args) {
        List<EmployeeSimple> simpleEmployeesList = SampleData.getSimpleEmployees();

        //Variable of type Function
        Function<EmployeeSimple, EmpDto> mapper = (singleEmp) -> {//Mapper = transformer = enricher = converters
            EmpDto empDto = new EmpDto();
            empDto.setName(singleEmp.getName());
            empDto.setAge(singleEmp.getAge());
            empDto.setSalary(singleEmp.getSalary());

            empDto.setExpLevel(String.valueOf(singleEmp.getExperience()) + String.valueOf(singleEmp.getLevel()));

            //System.out.println(empDto);
            return empDto;
        };

        mapper.apply(simpleEmployeesList.get(0));//accepts individual elements

        //to accept the list of elements/objects
        List<EmpDto> collect = simpleEmployeesList.stream().map(mapper).collect(Collectors.toList());

        System.out.println(collect);

        //to accept the list of elements/objects
        List<EmpDto> collect2 = simpleEmployeesList
                .stream()
                .map(getEmployeeSimpleEmpDtoFunction())
                .collect(Collectors.toList());


    }

    //Method
    private static Function<EmployeeSimple, EmpDto> getEmployeeSimpleEmpDtoFunction() {
        return (singleEmp) -> {
            EmpDto empDto = new EmpDto();
            empDto.setName(singleEmp.getName());
            empDto.setAge(singleEmp.getAge());
            empDto.setSalary(singleEmp.getSalary());
            empDto.setExpLevel(String.valueOf(singleEmp.getExperience()) + String.valueOf(singleEmp.getLevel()));
            //System.out.println(empDto);
            return empDto;
        };
    }
}

@Data
class EmpDto{
    private String name;
    private Integer age;
    private Double salary;
    private String ExpLevel;//exp + level
}
