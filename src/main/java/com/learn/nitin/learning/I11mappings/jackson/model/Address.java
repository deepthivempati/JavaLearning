package com.learn.nitin.learning.I11mappings.jackson.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)//Do not include field of the class Address, if any field in NULL
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}