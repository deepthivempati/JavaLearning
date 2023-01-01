package com.learn.nitin.learning.l4oops.inheritance;

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
