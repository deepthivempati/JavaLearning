package com.learn.git.testing;

import com.learn.git.GitTests;
public class Nc {
    public static void main(String[] args) {
        System.out.println("Testing Begins");

        String str = GitTests.pkUtility();
        System.out.println(str);
        System.out.println(str.length());
    }
}
