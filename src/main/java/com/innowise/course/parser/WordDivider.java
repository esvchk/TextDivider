package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.LexemeComponent;
import com.innowise.course.model.WordComponent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordDivider extends AbstractDivider {

    private static final String DIVIDE_ON_WORDS = "[\\p{L}\\p{N}]+";
    private LexemeComponent lexemeComponent;

    public WordDivider(LexemeComponent lexemeComponent) {
        this.lexemeComponent = lexemeComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) {
        String line = String.join("", abstractContentComponent.getText());
        Matcher matcher = Pattern.compile(DIVIDE_ON_WORDS).matcher(line);
        while (matcher.find()){
            lexemeComponent.add(new WordComponent(matcher.group()));
        }
    }
}
