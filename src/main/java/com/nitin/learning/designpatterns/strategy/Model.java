package com.nitin.learning.designpatterns.strategy;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Model {
    private String name;
    private String mName;
    private String lName;
    private Integer age;
}
