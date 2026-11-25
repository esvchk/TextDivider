package com.innowise.course.service;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.Component;

import java.util.List;

public interface TextService {
    List<Component> findMaxQuantitySentencesWithRepeatingWords(Component component);
    void getSentencesInASCOrder(Component component, Character letter);
    void swapEachLexemeInText(Component component);
}
