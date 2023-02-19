package com.learn.nitin.rishi.java.lambda;

public class NitinImpl implements Nitin{
    @Override
    public String callMe(String str) {
        return "Hello " + str + "!!";
    }
}
