package com.learn.nitin.git.testing;

import com.learn.nitin.git.GitTests;
public class Nc {
    public static void main(String[] args) {
        System.out.println("Testing Begins");

        String str = GitTests.pkUtility();
        System.out.println(str);
        System.out.println(str.length());
    }
}
