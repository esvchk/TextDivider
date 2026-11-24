package com.innowise.course.service.impl;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.TextComponent;
import com.innowise.course.service.TextService;

import java.util.*;

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
                    if (wordMap.get(word) > 1 && sentence.getText().contains(word)){
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
    public List<AbstractContentComponent> getSentencesInASCOrder() {
        return List.of();
    }

    @Override
    public void swapEachLexemeInText(TextComponent textComponent) {

    }
}
