package com.learn.nitin.rishi.creational.singleton;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        //SingletonDemo singletonDemo = new SingletonDemo();//should result in Error
        //Whats needs to be done toget the object

        //@Autowired
        //SingletonDemo singletonDemo;
        //singletonDemo.methiod();

        SingletonDemo singletonDemo = SingletonDemo.of();//Static factory method
        System.out.println(singletonDemo.doSomething());
        SingletonDemo singletonDemo1 = SingletonDemo.of();//Static method
        SingletonDemo singletonDemo2 = SingletonDemo.of();//Static method

        //reflectionDemo();

        SingletonDemoEnum object = SingletonDemoEnum.INSTANCE;
        System.out.println(object.doSomething());
    }

    private static void reflectionDemo() {
        Class<?> c = null;
        try {
            c =  Class.forName("com.learn.nitin.rishi.creational.singleton.SingletonDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c.getConstructors());
    }
}
