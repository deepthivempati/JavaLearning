package com.nitin.learning.lambda.methodReference.ex3;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEmployee {
    private String name;
    private String jobLevel;//level + exp + age
    private String salary;

    public void printMe(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ");
        sb.append(this.getJobLevel()).append(" ");
        sb.append(this.getSalary()).append(" ");

        System.out.println(sb.toString());
    }
}
