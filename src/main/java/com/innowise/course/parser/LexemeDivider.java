package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.Component;
import com.innowise.course.model.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeDivider extends AbstractDivider {

    private static final String DIVIDE_ON_LEXEME = "\\S+";


    @Override
    public boolean checkType(Component component) {
        return component.getType() == ComponentType.SENTENCE;
    }

    @Override
    public void divideComponent(Component sourceComponent) {
        try {
            if (checkType(sourceComponent)) {
                String line = String.join(" ", sourceComponent.getText());
                Matcher matcher = Pattern.compile(DIVIDE_ON_LEXEME).matcher(line);
                while(matcher.find()){
                    sourceComponent.add(new Component(ComponentType.LEXEME, matcher.group()));
                }
                for (Component component : sourceComponent.getInnerComponentList()){
                    nextDivider.divideComponent(component);
                }
            } else if (nextDivider != null){
                nextDivider.divideComponent(sourceComponent);
            }
        } catch (TextException e) {
            System.out.println("log");
        }
    }


}
