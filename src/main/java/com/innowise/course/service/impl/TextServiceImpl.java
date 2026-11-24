package com.innowise.course.service.impl;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.TextComponent;
import com.innowise.course.service.TextService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextServiceImpl implements TextService {


    @Override
    public List<AbstractContentComponent> findMaxQuantitySentencesWithRepeatingWords(TextComponent textComponent) {
        Map<String, Integer> wordMap = new HashMap<>();
        List<AbstractContentComponent> repeatingSentences = new ArrayList<>();
        for (AbstractContentComponent paragraph : textComponent.getInnerComponentList()) {
            for (AbstractContentComponent sentence : paragraph.getInnerComponentList()) {
                String[] words = sentence.getText().strip().split("\\W+");
                for (String word : words) {
                    if (wordMap.get(word) != null) {
                        wordMap.put(word, wordMap.get(word) + 1);
                    } else {
                        wordMap.put(word, 1);
                    }

                }
                Set<String> set = wordMap.keySet();
                for (String word : set) {
                    if (wordMap.get(word) > 1 && sentence.getText().contains(word)) {
                        if (!repeatingSentences.contains(sentence)) {
                            repeatingSentences.add(sentence);
                        }

                    }
                }
            }
        }
        return repeatingSentences;
    }


    @Override
    public void getSentencesInASCOrder(TextComponent textComponent, Character sourceLetter) {
        Map<String, Integer> letterMap = new HashMap<>();
        Map<AbstractContentComponent, Integer> coincidences = new HashMap<>();
        for (AbstractContentComponent paragraph : textComponent.getInnerComponentList()) {
            for (AbstractContentComponent sentence : paragraph.getInnerComponentList()) {
                Matcher matcher = Pattern.compile("\\w").matcher(sentence.getText());
                while (matcher.find()) {
                    String[] letters = matcher.group().split("");
                    for (String letter : letters) {
                        if (letter.equals(String.valueOf(sourceLetter)) && letterMap.get(letter) != null) {
                            letterMap.put(letter, letterMap.get(letter) + 1);
                        } else {
                            letterMap.put(letter, 1);
                        }
                    }
                }
                Integer max = Collections.max(letterMap.values());
                if (max > 1) {
                    coincidences.put(sentence, max);
                }
                letterMap.clear();
            }
        }
            coincidences.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(System.out::println);

    }

    @Override
    public void swapEachLexemeInText(TextComponent textComponent) {


    }
}
