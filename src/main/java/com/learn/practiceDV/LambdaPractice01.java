package com.learn.practiceDV;

import lombok.*;

import java.util.*;

public class LambdaPractice01 {
    public static void main(String[] args) {
        Doublecolon addition = LambdaPractice01::add;  // SomeClass::someStaticMethod
        System.out.println(addition.add(1, 2));

        LambdaPractice01 lambdaPractice01 = new LambdaPractice01();
        Doublecolon1 multiplication = lambdaPractice01::multiply; // SomeObject::instanceMethod
        System.out.println(multiplication.multiply(6, 6));

        List<Chocolates> chocolatesList = Arrays.asList(new Chocolates(2,4));
            chocolatesList.forEach(Chocolates::multiplyChocolates); //Someclass::instancMethod

    }
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @RequiredArgsConstructor
    static class Chocolates {
        int kitKat;
        int dairyMilk;
        public void multiplyChocolates() {
            System.out.println(kitKat * dairyMilk);
        }
    }

    private static int add(int i, int j) {
        return i + j;
    }

    private int multiply(int i, int j) {
        return i * j;
    }

    @FunctionalInterface
    interface Doublecolon {
        Integer add(int a, int b);
    }
    @FunctionalInterface
    interface Doublecolon1 {
        Integer multiply(int a, int b);
    }
}



