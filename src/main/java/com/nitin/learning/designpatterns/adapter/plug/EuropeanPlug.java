package com.nitin.learning.designpatterns.adapter.plug;

public class EuropeanPlug implements Plug {

    @Override
    public void pin3() {
        System.out.println("European 3 Pin Flat");
    }
}