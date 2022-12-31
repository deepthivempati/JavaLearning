package com.nitin.utilities.entity.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CovidIndiaTransformed {
    private String country;
    //public String countryCode;
    //public String province;
    //public String city;
    private String cityAndState;
    //public String cityCode;
    //public String lat; Not needed
    //public String lon;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer active;
    private ZonedDateTime date;
}
