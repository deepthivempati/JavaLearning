package com.learn.nitin.rishi.creational.builder;

import lombok.ToString;

@ToString
public class BuilderDemoPerson {
    private final String name;
    private final String email;
    private final String address;
    private final Integer age;
    private final String nameOfMother;//Optional, if the person is orphan

    public BuilderDemoPerson(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.age = builder.age;
        this.nameOfMother = builder.nameOfMother;
    }


    //TODO : May need refactoring
    public static class Builder{
        private final String name;//Compulsory Params
        private final String email;//Compulsory Params
        private String address;
        private Integer age;
        private String nameOfMother;


        public Builder(String name, String email) {
            this.name = name;
            this.email = email;
        }


        public Builder setAddress(String address) {
             this.address = address;
             return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setNameOfMother(String nameOfMother) {
            this.nameOfMother = nameOfMother;
            return this;
        }

        public BuilderDemoPerson build(){
            return new BuilderDemoPerson(this);
        }

    }
}
