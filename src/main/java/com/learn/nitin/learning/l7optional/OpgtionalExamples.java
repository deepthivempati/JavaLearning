package com.learn.nitin.learning.l7optional;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class OpgtionalExamples {
    public static void main(String[] args) {
        String getName = "Deepthi";//"Nitin";

        String result = Optional.ofNullable(getName)
                .map(StringUtils::upperCase)
                .orElse("Or-Else Block");
        System.out.println(result);

        /* ++++++++++Declaring Optionals +++++++++++++++++ */

        String str = "String";
        //Declaration by Of
        Optional<String> strOptional = Optional.of(str);

        //By Empty Optional, to be used later
        Optional<String> emptyOptional = Optional.empty();

        //By Nullable : if not sure whether the argument (str) is actually having a value or it's not.
        Optional<String> nullableOptional1 = Optional.ofNullable(str);
        Optional<String> nullableOptional2 = Optional.ofNullable(null);


        /* ++++++++++Declaring Optionals +++++++++++++++++ */
        String str1 = "Test String";
        String emptyString = null;

        //Optional way
        Optional<String> strOptional1 = Optional.of(str1);
        Optional<String> emptyStringOptional = Optional.empty();
        // get() method
        System.out.println("1: " + strOptional1.get());
        //System.out.println("1.1: " + Optional.of(emptyString).get());//NPE in get method.

        // isPresent Check
        String ret = strOptional.isPresent() ? strOptional1.get() : "val not present";
        String retEmpty = emptyStringOptional.isPresent() ? emptyStringOptional.get() : "Alternative Value";
        System.out.println("2: " + ret);
        System.out.println("3: " + retEmpty);

        // orElse, orElseGet -> Provides an alternative in case of a null return.
        String ret2 = emptyStringOptional.orElse("tasty treat");
        System.out.println(ret2);

        //OrElseGet needs a supplier
        String ret3 = emptyStringOptional.orElseGet(() -> "OrElseGet Testing");

        //OrElseThrow
        String ret4 = emptyStringOptional.orElseThrow();//No such element exception


    }
}


