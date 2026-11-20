package com.innowise.course.service.impl;

import com.innowise.course.model.SentenceComponent;
import com.innowise.course.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {


    @Override
    public int findMaxQuantitySentencesWithRepeatingWords() {

        List<SentenceComponent> sentenceComponents = new ArrayList<>();

        return 0;
    }

    @Override
    public List<SentenceComponent> getSentencesInASCOrder() {
        return List.of();
    }

    @Override
    public void swapEachLexemeInText() {

    }
}
