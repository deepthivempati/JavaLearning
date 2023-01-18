package com.learn.practiceDV;
import org.apache.commons.lang3.BooleanUtils;
public class BooleanUtilsConcept {
    public static void main(String[] args) {
        String firstName = "Deepthi";
        String string1 = "true";
        String string2 = "on";
        String string3 = "yes";
        Boolean result1 = Boolean.valueOf(firstName);
        Boolean result2 = Boolean.valueOf(string1);
        Boolean result3 = Boolean.valueOf(string2);
        Boolean result4 = Boolean.valueOf(string3);
        System.out.println("result1: "+result1);
        System.out.println("result2: "+result2);
        System.out.println("result3: "+result3);
        System.out.println("result4: "+result4);

        System.out.println("******************************");

        String str1 = "true";
        String str2 = "on";
        String str3 = "yes";
        Boolean result5 = BooleanUtils.toBoolean(str1);
        Boolean result6 = BooleanUtils.toBoolean(str2);
        Boolean result7 = BooleanUtils.toBoolean(str3);
        System.out.println("result4: "+result5);
        System.out.println("result5: "+result6);
        System.out.println("result6: "+result7);

    }
}

// Use Boolean.valueOf() when you only want to return true for input that equals "true" (case insensitive).
// Use BooleanUtils.toBoolean() when you want other input to return true (such as "on" or "yes").
// if there is any restriction or jar is not available on using external 3rd part library (e.g. Apache commons lib) use standard JDK Boolean.valueOf(String)