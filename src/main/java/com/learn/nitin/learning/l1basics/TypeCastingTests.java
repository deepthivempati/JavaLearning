package com.learn.nitin.learning.l1basics;

public class TypeCastingTests {
    public static void main(String[] args) {
        int a = 60;
        double b = a;  // Widening Casting(automatic) -- converting lowerDataType a to HigherDataType b
        System.out.println(a);
        System.out.println(b);

        double d = 100.00;
        int c = (int) d;  // Narrowing Casting(manual) -- converting HigherDataType d to lowerDataType c
        System.out.println(d);
        System.out.println(c);

        Number n = 10;
        Integer i = (Integer) n;
        int j = (int) n;
        System.out.println(i);
        System.out.println(j);
    }
}

/*
Number
Integer;
int
 */