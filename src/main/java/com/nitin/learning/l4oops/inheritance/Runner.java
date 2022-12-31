package com.nitin.learning.l4oops.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();//List is an interface
        Parent pc = new Child();//Polymorphic Call, with a Class
        System.out.println(pc.m1());// valid as pc is of type Parent
        //System.out.println(pc.m2());// invalid, CE : Cannot find symbol
        System.out.println(((Child) pc).m2());// invalid, CE : Cannot find symbol

        //7TODO: find what is (Child) pc).m2()

        Parent p = new Parent();
        p.m1();// Valid
        //p.m2();// Complie time error: Cannot find symbol

    }
}
