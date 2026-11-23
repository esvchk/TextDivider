package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceDivider extends AbstractDivider {

    private static final String DIVIDE_ON_SENTENCE = "(?s)[^.!?]+[.!?]+(?:\\s|$)|[^.!?]+$";


    @Override
    public boolean checkInstance(AbstractContentComponent component) {
        return component instanceof ParagraphComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent sourceComponent) throws TextException {
        if (checkInstance(sourceComponent)) {
            String line = String.join("\n", sourceComponent.getText());
            Matcher m = Pattern.compile(DIVIDE_ON_SENTENCE).matcher(line);
            while (m.find()){
                sourceComponent.add(new SentenceComponent(m.group()));
            }
            for (AbstractContentComponent component : sourceComponent.getInnerComponentList()){
                nextDivider.divideComponent(component);
            }
        } else if (nextDivider != null) {
            nextDivider.divideComponent(sourceComponent);
        }


    }
}
