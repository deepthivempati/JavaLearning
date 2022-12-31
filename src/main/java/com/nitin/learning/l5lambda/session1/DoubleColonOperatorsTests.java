package com.nitin.learning.l5lambda.session1;

import java.util.stream.Stream;

public class DoubleColonOperatorsTests {
    public static void main(String[] args) {
        String someString = new String("Nitin");

        Stream<String> strStream = Stream.of(someString);
        //strStream.map(someString::toUpperCase).(System.out::println();


    }

    public static String doSth(String str){
        return str+str;
    }
}
