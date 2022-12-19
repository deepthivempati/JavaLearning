package com.nitin.learning.lambda.session3;

import com.nitin.learning.lambda.functionalInterface.MyFunctionalInterface3;
import com.nitin.learning.lambda.functionalInterface.TestInterfaceReturnMethod;
import com.nitin.learning.lambda.functionalInterface.TestInterfaceVoidMethod;

import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        MyFunctionalInterface3 x;
        x = () -> "Nitin";

        TestInterfaceReturnMethod y;
        y = (a, b) -> a.toString().concat(b.toString());
        y = (a,b) -> String.valueOf((a.intValue() + b.intValue()));

        /* RETURN Always need curly braces and ends with a colon */
        y = (Integer a,Float b) -> {
            String str;
            str = String.valueOf((a.intValue() + b.intValue()));
            return str;
        };

        Comparator<String> comparator = (String o1, String o2) -> 0;//VALID

        // () can be omitted only if there is EXACTLY ONE Parameter and NO DATA TYPE
        TestInterfaceVoidMethod z;
        z = (String str) -> System.out.println(str);
        z = str -> System.out.println(str);

        //multiple parameters need to be enclosed in the brackets.
        //a,b -> a.startsWith("Ni")//DOES NOT COMPILE : need small brackets
        //CORRECT: (a,b) -> a.startsWith("Ni")


        /*
        c -> return 10;// DOES NOT COMPILE : return keyword without {}
        CORRECT: c -> { return 10; }
        OR c -> 10;
        a -> {return a.startsWith("test")}//DOES NOT COMPILE : need ; after return
        CORRECT:
        a -> { return a.startsWith("test"); }

        // DATA TYPES FOR THE INPUT PARAMETERS OF A LAMBDA EXPRESSION IS OPTIONAL
        (int y, z) -> { int x = 1; return x+y; }// DOES NOT COMPILE : Either both have data types or none
        CORRECT: ( y, z) -> { int x = 1; return x+y; }
        OR CORRECT: (int y, int z) -> { int x = 1; return x+y; }

        (a,b) -> { int a = 9;
            return a+b
            }//DOES NOT COMPILE: Redeclaration of a

        (a,b) -> { int c = 9; return a+b }// CORRECT AS C is an independent local variable
         */
    }
}