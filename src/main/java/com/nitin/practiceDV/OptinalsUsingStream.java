package com.nitin.practiceDV;

import com.nitin.practiceDV.practiceEntity.Mobiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptinalsUsingStream {
    public static void main(String[] args) {
        List<Mobiles> mobiles = new ArrayList<>();
        mobiles.add(new Mobiles("iphone 13 pro max", 120000, 789654.90));
        mobiles.add(new Mobiles("iphone 14", 150000, 456789.90));
        mobiles.add(null);

        Optional<Mobiles> phone = mobiles
                .stream()
                .filter(Objects::nonNull)
                .filter(mobiles1 -> mobiles1.getModel().equals("iphone 13 pro max"))
                .findFirst();

        System.out.println(mobiles);
        System.out.println(phone.orElse(new Mobiles()));
    }
}

