package com.learn.practiceDV;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class IdiomsDto {
    private List<String> IdiomsList;
    private List<Integer> IdiomsCountList;
}
