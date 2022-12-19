package com.nitin.learning.lambda.methodReference;

import com.nitin.utilities.SampleData;
import com.nitin.utilities.entity.EmployeeSimple;

import java.io.PrintStream;
import java.util.List;
import java.util.function.BiFunction;

public class Example2 {

    public static void main(String[] args) {
        MethodReferences myApp = new MethodReferences();

        // Calling the method with a lambda expression
        System.out.println(myApp.playBiFunction("Hello ", "World!", (a, b) -> a.concat(b)));
        // Reference to an instance method of an **arbitrary object** of a particular type
        System.out.println(myApp.playBiFunction("Hello ","World!", String::concat));
        // Reference to an **instance method** of a particular object
        System.out.println(myApp.playBiFunction("Hello ","World!", myApp::appendStrings));
        // Reference to a static method
        System.out.println(myApp.playBiFunction("Hello ", "World!", MethodReferences::staticAppendStrings));

        // Calling Static method From Math Library
        BiFunction<Double, Double, Double> doubleDoubleDoubleBiFunction = (x, y) -> Math.hypot(x, y);
        System.out.println(myApp.playBiFunction(3.0,4.0, doubleDoubleDoubleBiFunction));
        // Reference to a static method
        System.out.println(myApp.playBiFunction(3.0,4.0, Math::hypot));

        List<EmployeeSimple> list = SampleData.getSimpleEmployees();
        PrintStream printStream = System.out;
        // Reference to an **instance method** of a particular object
        list.forEach(printStream::println);

        String str = "Nitin";
        System.out.println(str.toUpperCase());
        //System.out.println(str::length);


        BiFunction<Integer, Double, String> biFunction = (x, y) -> String.valueOf(Math.hypot(x, y));
        System.out.println(biFunction.apply(3,4.0));


    }
}
