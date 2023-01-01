package com.learn.nitin.learning.l5lambda.session3;

import com.learn.nitin.learning.l5lambda.functionalInterface.FindWords;
import com.learn.nitin.utilities.entity.WordResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tests {
    public static void main(String[] args) {
        String[] words = new String[]{"elated", "5"};

        List<String> listWords = getSynonyms(words, getWords());

        listWords.forEach(word -> System.out.println(word));
    }

    private static FindWords getWords() {
        FindWords f = (String[] arrayOfWords) -> {
            String word = arrayOfWords[0];
            String max = arrayOfWords[1];
            Map<String, String> uriVariables = new HashMap<>();
            uriVariables.put("word", word);
            uriVariables.put("max", max);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<WordResponse[]> response = restTemplate.getForEntity(
                    "https://api.datamuse.com/words?ml={word}&max={max}", WordResponse[].class, uriVariables);

            List<String> wordList = new ArrayList<>();
            for (WordResponse x : response.getBody()) {
                wordList.add(x.getWord());
            }
            return wordList;
        };
        return f;
    }

    public static List<String> getSynonyms(String[] arrayOfWords, FindWords findWords) {
        return findWords.getWords(arrayOfWords);
    }
}