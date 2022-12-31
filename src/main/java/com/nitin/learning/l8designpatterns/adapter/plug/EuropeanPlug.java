package com.nitin.learning.l8designpatterns.adapter.plug;

public class EuropeanPlug implements Plug {

    @Override
    public void pin3() {
        System.out.println("European 3 Pin Flat");
    }
}