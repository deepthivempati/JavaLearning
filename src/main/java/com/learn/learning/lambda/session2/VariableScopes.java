package com.learn.learning.lambda.session2;

public class VariableScopes {
    public static void main(String[] args) {


        MyFunctionalInterface1 y = (str1 -> str1.split(","));//Providing the definition to the abstract method
        String str1 = "The Green Mile";

        String str2 = "The Reader,The Pursuit of Happyness,Before Midnight";
        System.out.println(y.doSomeJob(str2)[1]);


    }
}

@FunctionalInterface
interface MyFunctionalInterface1{
    String[] doSomeJob(String str);
}


