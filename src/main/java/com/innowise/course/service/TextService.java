package com.innowise.course.service;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.SentenceComponent;
import com.innowise.course.model.TextComponent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TextService {
    List<AbstractContentComponent> findMaxQuantitySentencesWithRepeatingWords(TextComponent textComponent);
    List<AbstractContentComponent> getSentencesInASCOrder();
    void swapEachLexemeInText(TextComponent textComponent);
}
