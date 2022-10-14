package com.learn.learning.UtilityClasses.external;

import com.learn.utilities.SampleData;
import com.learn.utilities.entity.Student;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class ApacheUtilsLib {
    public static void main(String[] args) {

        String a = "Nitin";
        String b = null;

        if (a.equals(b)){//Not Null safe
            System.out.println("a == b");
        }

        /*if (b.equals(a)){//NPE
            System.out.println("a == b");
        }*/


        //String Utils is Null Safe
        if(StringUtils.equals(a,b)){
            System.out.println("a == b");
        }

        System.out.println(StringUtils.equalsIgnoreCase("abs","Abs"));

        System.out.println(StringUtils.capitalize("john doe"));

        System.out.println(StringUtils.isAlphanumeric("That's abc 123"));

        System.out.println(StringUtils.isAlpha("john3"));//true if only contains letters, and is non-null

        System.out.println(StringUtils.isNumeric("123"));

        List<Student> list = SampleData.getStudents();
        list.get(0).setFirstName(null);
        String firstNameCapital = Optional.ofNullable(list.get(0).getFirstName())
                .map(String::toUpperCase)
                .orElse(StringUtils.EMPTY);
        System.out.println(firstNameCapital);

        if(StringUtils.isEmpty(firstNameCapital)){
            System.out.println("Empty String");
        }

        if(StringUtils.isNotEmpty(firstNameCapital)){
            System.out.println("Empty String");
        }

        String keyVal = StringUtils.joinWith(":",a,b);

        CollectionUtils.isEmpty(list);
        CollectionUtils.isNotEmpty(list);


    }
}
