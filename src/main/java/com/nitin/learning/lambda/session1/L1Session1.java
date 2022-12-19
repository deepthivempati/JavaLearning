package com.nitin.learning.lambda.session1;

import com.nitin.learning.lambda.functionalInterface.MyFunctionalInterface0;
import com.nitin.learning.lambda.functionalInterface.MyFunctionalInterface1;
import com.nitin.learning.lambda.functionalInterface.MyFunctionalInterface2;

public class L1Session1 {
    public static void main(String[] args) {
        int z = 10;

        MyFunctionalInterface0 xx = () -> System.out.println("Tests");
        xx.doSomework();

        MyFunctionalInterface1 y = (x -> x+x);//Providing the definition to the abstract method
        System.out.println(y.doSomeJob(5));

        //Valid Lambda as 2 arguments are expected
        MyFunctionalInterface2 deepthi = (val1, val2) -> val1 * val2;

        /* Without Curly braces we can't use return keyword */
        MyFunctionalInterface2 deepthi2 = (val1, val2) -> {
             val1 = val2 + 4;
            return (val1 * val2);
        };


       /* List<Integer> list = SampleData.intCargoSequence(10,15);
        Consumer d = x -> System.out.println(x);
        list.forEach(val -> d.accept(val));//OR

        list.forEach(val -> System.out.println(val));//OR

        list.forEach(System.out::println)*/;
    }
}

//Any method that accepts Functional Interface as parameter, needs a Lambda