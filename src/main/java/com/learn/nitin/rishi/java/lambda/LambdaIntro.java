package com.learn.nitin.rishi.java.lambda;

import java.util.function.Consumer;

public class LambdaIntro {
    public static void main(String[] args) {

        //Old Style : Not preferred anymore, unless forced by Framework
        NitinImpl nitin = new NitinImpl();
        System.out.println(nitin.callMe("Rishi"));

        //In line implementation, using anomymous Class
        anonymousStyle();

        //USE THIS
        //LHS : Functional Interf --> RHS : Lambda Expression
        Nitin nitin4 =  str -> str + "is Java 8";//Lambda -> can be replaced with a Functional interface

        //Lambda in multiple Line : EXTRACT THE METHOD OUT FOR TESTABILITY
        Nitin nitin5 =  (str) -> {
            StringBuilder sb = getStringBuilder();
            return sb.toString();//Lambda -> can be replaced with a Functional interface
        };

        System.out.println(nitin5.callMe("Awesome!!"));
    }

    private static void anonymousStyle() {
        Nitin nitin2 = new Nitin() {
            @Override
            public String callMe(String str) {
                return str + "!!";
            }
        };
        System.out.println(nitin2.callMe("Nitin"));
    }

    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(Runtime.getRuntime().totalMemory());
        sb.append((String) null);
        //sb.append(1/0);
        sb.append("\n");
        sb.append(Runtime.getRuntime().freeMemory());
        sb.append("Test");
        return sb;
    }


    //Consumer
    //Supplier
    //Predicate
    //Function
}


