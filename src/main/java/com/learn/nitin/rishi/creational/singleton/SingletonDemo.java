package com.learn.nitin.rishi.creational.singleton;

class SingletonDemo {

    public SingletonDemo(){}

    private static SingletonDemo singletonDemo; //Eager Mode -->  static final SingletonDemo  = new SingletonDemo();

    //Lazy Mode
    public static SingletonDemo of(){//Static Factory

       if(null == singletonDemo){
            System.out.println("First time call");
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }

    public String doSomething(){
        return "Nitin";
    }
}

/*
* There are four different ways to create objects in java:
1.     Using new keyword
2.     Using Class.forName()://reflection
3.     Using clone():
4.     Using Object Deserialization:
    Using new Intance() method
* */
