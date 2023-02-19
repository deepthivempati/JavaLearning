package com.learn.nitin.rishi.creational.singleton;

//This ENUM acts as a singleton bean
public enum SingletonDemoEnum {
    INSTANCE();

    public String doSomething(){
        return "Nitin";
    }

}
