package com.nitin.learning.designpatterns.adapter.plug;

public class Runner {
    public static void main(String[] args) {

        System.out.println("\nThe European says...");
        Plug europeanPlug = new EuropeanPlug();
        europeanPlug.pin3();

        System.out.println("The Plug Adapter says...");

        Switch indianSwitch = new IndianSwitch();
        Plug plugAdapter = new PlugAdapter(indianSwitch);
        plugAdapter.pin3();

    }
}
