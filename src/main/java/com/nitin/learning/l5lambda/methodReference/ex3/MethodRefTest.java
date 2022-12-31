package com.nitin.learning.l5lambda.methodReference.ex3;

public class MethodRefTest {

    public <T> T testMethodRef(T a, T b, Learnable<T> learnable){
        return learnable.learn(a,b);
    }
}
