package com.learn.learning.strings.stringMethods;

import java.util.Arrays;

public class StringTrimAndSplit {

    public static void main(String[] args) {
        String whiteSpace = "  sentence with white space  ";
        System.out.println(whiteSpace.trim());
        System.out.println(whiteSpace.split(" "));
        System.out.println(Arrays.toString(whiteSpace.trim().split(" ")));
        System.out.println(String.join(" ", whiteSpace.trim()));
    }
}
