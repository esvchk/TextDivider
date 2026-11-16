package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceDivider extends AbstractDivider {

    private static final String DIVIDE_ON_SENTENCE = "(?s)[^.!?]+[.!?]+(?:\\s|$)|[^.!?]+$";
    private final ParagraphComponent paragraphComponent;

    public SentenceDivider(ParagraphComponent paragraphComponent) {
        this.paragraphComponent = paragraphComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) {
        String line = String.join("\n", abstractContentComponent.getText());
        Matcher m = Pattern.compile(DIVIDE_ON_SENTENCE).matcher(line);
        while (m.find()){
            paragraphComponent.add(new SentenceComponent(m.group()));
        }

    }
}
