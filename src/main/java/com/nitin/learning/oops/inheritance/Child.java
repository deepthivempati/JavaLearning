package com.nitin.learning.oops.inheritance;

public class Child extends Parent{

    int property = 200;

    @Override
    public String m1(){
        return "Overriding Parent";
    }

    public String m2(){
        return "From Child";
    }
}
