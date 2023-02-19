package com.learn.nitin.rishi.creational.builder;

public class Runner {
    public static void main(String[] args) {
        BuilderDemoPerson person = new BuilderDemoPerson.Builder("name","email")
                .setAge(25)
                .build();

        System.out.println(person);
    }
}
