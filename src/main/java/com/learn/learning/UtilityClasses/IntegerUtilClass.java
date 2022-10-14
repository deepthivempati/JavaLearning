package com.learn.learning.UtilityClasses;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerUtilClass {
    public static void main(String[] args) {
//        intJava();/****** INTEGER ********/
//        boolJava();/****** BOOLEAN ********/
//        boolApache();/****** APACHE COMMONS ********/
//        charJava();/****** CHARACTER ********/
//        doubleJava();/****** DOUBLE ********/
        stringJava();
    }

    private static void stringJava() {
      String s = new String("Test String");

      //Static Factory
        String b = String.valueOf(true);//Pas any thing from primitive
        System.out.println(b);

      char[] arr = s.toCharArray();
      List<Character> charList = new ArrayList<>();
        for (char c : arr) {
            charList.add(c);
        }
        System.out.println(charList);

        charList = s.chars()
              .mapToObj(c -> (char) c)
              .collect(Collectors.toList());
        System.out.println(charList);
        System.out.println(charList);

    }

    private static void doubleJava() {
        String resultValue = "12.25";
        resultValue = null;
        double result = NumberUtils.isCreatable(resultValue) ? Double.parseDouble(resultValue) : Double.NaN;
        System.out.println(result);

        Double primDouble = null;
        
        if(null != resultValue){
            primDouble = Double.parseDouble(resultValue);
        }
        
        System.out.println(primDouble);
        //Double.valueOf(resultValue);
    }

    private static void charJava() {
        System.out.println(!Character.isLetterOrDigit('!'));//punctuation mark

        System.out.println(Character.isLetter('r'));
        System.out.println(Character.isDigit('4'));
        System.out.println(Character.compare('1','1'));//Compare character

        Character c = Character.valueOf('c');
        System.out.println(c);//From primitive to Wrapper
    }

    private static void boolApache() {
        boolean primitiveBool = BooleanUtils.toBoolean(1);
        Boolean wrapperBool = BooleanUtils.toBooleanObject("Yes");

        Boolean wrapperBool2 = Boolean.TRUE;
        boolean primitiveBool2 = BooleanUtils.isNotFalse(wrapperBool2);
        boolean primitiveBool3 = BooleanUtils.isTrue(wrapperBool2);
    }

    private static void boolJava() {
        String strBool = "true";
        Boolean bool = Boolean.valueOf(strBool);//return Wrapper Object. Works only with "True" or "true"
        System.out.println(bool);
        Boolean bool2 = Boolean.getBoolean("true7");//the system property name. BE CAREFUL, returns null
        System.out.println(bool2);

        boolean bool3 = Boolean.parseBoolean(strBool);//String to primitive
    }

    private static void intJava() {
        int i = 89;
        Integer intVal = Integer.valueOf(i);//From String or primitive to Wrapper
        System.out.println(intVal);

        String strIntVal= "-90";
        int j = Integer.parseInt(strIntVal);//From String to primitive
        Integer k = Integer.valueOf(strIntVal);//From String or primitive to Wrapper
        System.out.println("j = " + j);
        System.out.println("k = " + k);

        Integer integer = Integer.getInteger("90");
        System.out.println();//Uses system property. BE CAREFUL, returns null
    }
}
