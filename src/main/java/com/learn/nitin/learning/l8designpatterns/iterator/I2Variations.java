package com.learn.nitin.learning.l8designpatterns.iterator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.nitin.utilities.entity.Card;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class I2Variations {
    public static void main(String[] args) {
        List<String> list = List.of("Mimi", "Alvin", "Yolonda", "Donnie", "Delphine");//Find why null is not allowed

        //System.out.println(forLoop(list, 2));
        //System.out.println(forLoopWithVar(list, 2));
        System.out.println(forLoopStreams(list, 2));

        cardReader();
    }

    private static List<String> forLoopWithVar(List<String> list, int count) {
        var ret = new ArrayList<String>();

        var input = list;
        int x = 0;
        for(var name : list){
            var str = name;
            if(str.length() > 4){
                x++;
                ret.add(str.toUpperCase());
            }

            if(x == count){
                break;
            }
        }
        return ret;
    }

    private static List<String> forLoopStreams(List<String> list, int count) {

        var ret = new ArrayList<String>();
        var nameList = new ArrayList<String>();

        //Functional Style == declarative style

        //Works until now, but stooped all of a sudden
        // Code behaves - erratically with parallel Stream
        ret = (ArrayList<String>) list.stream().parallel()//TODO: Think of removing the type cast
                //.filter(name -> null != name)
                .filter(Objects::nonNull)
                .filter(name -> name.length() > 2)
                .map(nameInLowerCase -> nameInLowerCase.toUpperCase())
                .limit(count)
                //.forEach(name -> nameList.add(name));//BAD IDEA with ParallelStream - due to shared mutability - this is impure
                .collect(Collectors.toList());//Thread safe

        nameList.add(null);
        return ret;
    }

    private static List<String> forLoop(List<String> list, int count) {
        //and then
        //Imperative style === what to do + how to do + Eager Evaluation

        int x = 0;
        List<String> ret = new ArrayList<>();
        //send first 2 string with lenght > 4
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if(str.length() > 4){
                x++;
                ret.add(str.toUpperCase());
            }

            if(x == count){
                break;
            }
        }

        return ret;
    }

    public static void cardReader() {
        var mapper = new ObjectMapper();
        var listCard = new ArrayList<Card>();
        var url = "https://random-data-api.com/api/business_credit_card/random_card?size=100";

        try {
            listCard = (ArrayList<Card>) mapper.readValue(new URL(url), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listCard.size());
    }
}
