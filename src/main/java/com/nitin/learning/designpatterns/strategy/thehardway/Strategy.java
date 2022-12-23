package com.nitin.learning.designpatterns.strategy.thehardway;

//@Setter
public class Strategy {

    private ContextNitin context;//this is composition : HINT

    public void setStrategy(ContextNitin context){
        this.context = context;
    }

}
