package com.learn.nitin.rishi.java.lambda;

@FunctionalInterface
public interface Nitin {
    String callMe(String str);

    default void testCall(){
        System.out.println("Call from Default");
    }
}
