package com.nitin.practiceDV;

import com.nitin.practiceDV.practiceEntity.Mobiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//ways to declare & initialize lists
public class Lists {
    public static void main(String[] args) {
        List<String> idiom1 = Arrays.asList("Hang in there", "its not rocket science");
        System.out.println(idiom1);

        List<String> idiom2 = new ArrayList<>();
        idiom2.add(0,"Its a piece of cake");
        idiom2.add("Better late than never");
        System.out.println(idiom2);

        IdiomsDto idioms = IdiomsDto
                .builder()
                .IdiomsList(Arrays.asList("No Pain No Gain", "Put yourself together"))
                .IdiomsCountList(Arrays.asList(6,9))
                .build();
        System.out.println(idioms);

        List<Mobiles> mobiles = new ArrayList<>();
        mobiles.add(new Mobiles("iphone 13 pro max", 120000, 789654.90));
        System.out.println(mobiles);

        List<String> numbers = new ArrayList<>();
        int i;
        for(i=0; i<=5; i++){
            numbers.add(String.valueOf(i));
        }
        System.out.println(numbers);
    }

}
