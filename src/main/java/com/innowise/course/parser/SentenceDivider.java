package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.Component;
import com.innowise.course.model.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceDivider extends AbstractDivider {

    private static final String DIVIDE_ON_SENTENCE = "(?s)[^.!?]+[.!?]+(?:\\s|$)|[^.!?]+$";


    @Override
    public boolean checkType(Component component) {
        return component.getType() == ComponentType.PARAGRAPH;
    }

    @Override
    public void divideComponent(Component sourceComponent) {
        try {
            if (checkType(sourceComponent)) {
                String line = String.join("\n", sourceComponent.getText());
                Matcher m = Pattern.compile(DIVIDE_ON_SENTENCE).matcher(line);
                while (m.find()) {
                    sourceComponent.add(new Component(ComponentType.SENTENCE, m.group()));
                }
                for (Component component : sourceComponent.getInnerComponentList()) {
                    nextDivider.divideComponent(component);
                }
            } else if (nextDivider != null) {
                nextDivider.divideComponent(sourceComponent);
            }
        } catch (TextException e) {

        }


    }
}
