package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.LexemeComponent;
import com.innowise.course.model.WordComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WordDivider extends AbstractDivider {

    private static final String DIVIDE_ON_WORDS = "[\\p{L}\\p{N}]+";
    private AbstractContentComponent contentComponent;


    public WordDivider(AbstractContentComponent lexemeComponent) {
        this.contentComponent = lexemeComponent;
    }

    @Override
    public boolean checkInstance(AbstractContentComponent component) {
        return component instanceof LexemeComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent sourceComponent) throws TextException {
        if (checkInstance(sourceComponent)) {
            String line = String.join("", sourceComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_WORDS).matcher(line);
            while (matcher.find()){
                contentComponent.add(new WordComponent(matcher.group()));
            }
            for (AbstractContentComponent component : contentComponent.getInnerComponentList(sourceComponent)){
                nextDivider.divideComponent(component);
            }
        } else if (nextDivider != null) {
            nextDivider.divideComponent(sourceComponent);
        }
    }
}
