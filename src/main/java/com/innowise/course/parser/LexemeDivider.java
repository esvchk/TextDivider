package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.LexemeComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeDivider extends AbstractDivider {

    private static final String DIVIDE_ON_LEXEME = "\\S+";

    @Override
    public boolean checkInstance(AbstractContentComponent component) {
        return component instanceof SentenceComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent sourceComponent) throws TextException {
        if (checkInstance(sourceComponent)) {
            String line = String.join(" ", sourceComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_LEXEME).matcher(line);
            while(matcher.find()){
                sourceComponent.add(new LexemeComponent(matcher.group()));
            }
            for (AbstractContentComponent component : sourceComponent.getInnerComponentList()){
                nextDivider.divideComponent(component);
            }
        } else if (nextDivider != null){
            nextDivider.divideComponent(sourceComponent);
        }
    }
}
