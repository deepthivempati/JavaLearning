package com.nitin.learning.l7optional;

import java.util.Optional;
import java.util.UUID;

public class OptionalTest {
    public static void main(String[] args) {
        String string = "38400000-8cf0-11bd-b23e-10b96e4ef00d";
        string = null;

        getUUID(string);
    }

    private static void getUUID(String string) {
        UUID temp = null != string ? UUID.fromString(string) :UUID.randomUUID();

        UUID x = Optional.ofNullable(temp).orElse(UUID.randomUUID());
        System.out.println(x);
    }
}