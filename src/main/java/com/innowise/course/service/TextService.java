package com.innowise.course.service;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.List;

public interface TextService {
    int findMaxQuantitySentencesWithRepeatingWords();
    List<SentenceComponent> getSentencesInASCOrder();
    void swapEachLexemeInText();
}
