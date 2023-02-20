package com.learn.nitin.learning.I11mappings.jackson.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.nitin.learning.I11mappings.jackson.filter.DateOfBirthFilter;
import com.learn.nitin.learning.I11mappings.jackson.filter.EmptyListFilter;
import com.learn.nitin.learning.I11mappings.jackson.filter.PhoneFilter;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Employee {
    @JsonProperty("name")
    private String name;
    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = DateOfBirthFilter.class)
    private Date dob;
    @JsonProperty("phones")
    @JsonInclude(content = JsonInclude.Include.CUSTOM, contentFilter = PhoneFilter.class)
    private Map<String, String> phones;
    @JsonProperty("addresses")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = EmptyListFilter.class)
    private List<Address> addresses;
}