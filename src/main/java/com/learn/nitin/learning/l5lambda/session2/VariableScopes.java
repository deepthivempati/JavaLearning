package com.learn.nitin.learning.l5lambda.session2;

import com.learn.nitin.learning.l5lambda.functionalInterface.MyFunctionalInterface;

public class VariableScopes {
    public static void main(String[] args) {


        MyFunctionalInterface y = (str1 -> str1.split(","));//Providing the definition to the abstract method
        String str1 = "The Green Mile";

        String str2 = "The Reader,The Pursuit of Happyness,Before Midnight";
        System.out.println(y.doSomeJob(str2)[1]);


    }
}