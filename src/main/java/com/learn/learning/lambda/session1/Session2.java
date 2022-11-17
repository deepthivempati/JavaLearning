package com.learn.learning.lambda.session1;

public class Session2 {

    public static void main(String[] args) {

        MyTestInterface myTestInterface1 = (String str) -> str+ "Rocks Big Time!!";
        System.out.println(myTestInterface1.testString("Test "));



    }
}



