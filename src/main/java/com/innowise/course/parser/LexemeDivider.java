package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.LexemeComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeDivider extends AbstractDivider {

    private static String DIVIDE_ON_LEXEME = "\\S+";
    private SentenceComponent sentenceComponent;

    public LexemeDivider(SentenceComponent sentenceComponent) {
        this.sentenceComponent = sentenceComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) {
        String line = String.join(" ", abstractContentComponent.getText());
        Matcher matcher = Pattern.compile(DIVIDE_ON_LEXEME).matcher(line);
        while(matcher.find()){
            sentenceComponent.add(new LexemeComponent(matcher.group()));
        }
    }
}
