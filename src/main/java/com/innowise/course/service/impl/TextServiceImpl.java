package com.innowise.course.service.impl;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.SentenceComponent;
import com.innowise.course.model.TextComponent;
import com.innowise.course.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {


    @Override
    public List<AbstractContentComponent> findMaxQuantitySentencesWithRepeatingWords(TextComponent textComponent) {
        Map<String, Integer> wordMap = new HashMap<>();
        List<AbstractContentComponent> components = new ArrayList<>();
        for (AbstractContentComponent paragraph : textComponent.getInnerComponentList()) {
            for (AbstractContentComponent sentence : paragraph.getInnerComponentList()) {
                String[] words = sentence.getText().split("\\W+");
                for (String word : words) {
                    if (wordMap.get(word) != null) {
                        wordMap.put(word, wordMap.get(word) + 1);
                    } else {
                        wordMap.put(word, 1);
                    }

                }
                Set<String> set = wordMap.keySet();
                for (String word : set) {
                    if (wordMap.get(Collections.max(wordMap.keySet())) > 1 && sentence.getText().contains(word)){
                        components.add(sentence);
                    }

                }

            }
        }
        return components;
    }


    @Override
    public List<AbstractContentComponent> getSentencesInASCOrder() {
        return List.of();
    }

    @Override
    public void swapEachLexemeInText(TextComponent textComponent) {

    }
}
