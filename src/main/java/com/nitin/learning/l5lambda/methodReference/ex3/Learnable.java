package com.nitin.learning.l5lambda.methodReference.ex3;

@FunctionalInterface
interface Learnable<T> {
    public T learn(T a, T b);
}