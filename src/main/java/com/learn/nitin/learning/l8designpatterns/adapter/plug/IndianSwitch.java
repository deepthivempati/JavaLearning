package com.learn.nitin.learning.l8designpatterns.adapter.plug;

public class IndianSwitch implements Switch {

    @Override
    public void pin2() {
        System.out.println("Indian 2 Pin round");
    }
}
