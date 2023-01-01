package com.nitin.learning.l10collectors.c4filtering;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.*;


public class F3FlatMapping {
    public static void main(String[] args) {

           // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
           // <R> Stream<R> map    (Function<? super T, ? extends R> mapper);

        //groupingBy, mapping, filtering -> taking first argument (function or predicate) and second argument as Collector
        // It means, first apply the function or Predicate and then Collect

        //collectingAndThen -> Collector as first argument adn then Function as second argument

        //map first and flattening later -> mapFlattening -> flatMap
        List<Integer> numbers = List.of(1,2,3,4);

        one2oneMapping(numbers);
        one2ManyMapping(numbers);
        one2ManyFlatMapping(numbers);

        //Find the age and unique characters in employees name
        findAgeAndUniqueChars();
    }

    private static void findAgeAndUniqueChars() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        System.out.println(
            employees
                    .stream()
                    .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                    .collect(groupingBy(EmployeeSimple::getAge,
                                    mapping(EmployeeSimple::getName,
                                            filtering(name -> name.length() < 4,toList())
                                                    //mapping(name -> List.of(name.split("")).stream(), toList())
                                            )
                                    )
                            )
                    );

    }

    private static void one2ManyFlatMapping(List<Integer> numbers) {

        List<Integer> collect = numbers.stream()
                .flatMap(element -> List.of(element + 1, element - 1).stream())
                .collect(toList());//[2, 0, 3, 1, 4, 2, 5, 3]

        System.out.println(collect);
    }

    private static void one2ManyMapping(List<Integer> numbers) {

        List<List<Integer>> collect = numbers.stream()
                .map(element -> List.of(element + 1, element - 1))
                .collect(toList());//[[2, 0], [3, 1], [4, 2], [5, 3]]

        System.out.println(collect);
    }

    private static void one2oneMapping(List<Integer> numbers) {

        List<Integer> collect = numbers.stream()
                .map(element -> element * 2)
                .collect(toList());//[2, 4, 6, 8]
        System.out.println(collect);
    }
}
