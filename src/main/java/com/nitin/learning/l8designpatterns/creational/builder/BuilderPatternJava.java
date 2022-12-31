package com.nitin.learning.l8designpatterns.creational.builder;

import com.nitin.learning.l8designpatterns.strategy.Model;

public class BuilderPatternJava {
    public static void main(String[] args) {
        Model model = Model.builder()
                .name("nitin")
                .build();
        System.out.println(model);

        Model m2 = Model.builder()
                .name("deepthi")
                .lName("vempati")
                .build();
        System.out.println(m2);

        Model m3 = Model.builder()
                .name("Shital")
                .mName("jaykumar")
                .lName("deshpande")
                .build();
        System.out.println(m3);
    }
}
