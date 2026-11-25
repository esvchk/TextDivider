package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.Component;
import com.innowise.course.model.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterDivider extends AbstractDivider {

    private static final String DIVIDE_ON_CHARACTERS = "\\S";

    @Override
    public boolean checkType(Component component) {
        return component.getType() == ComponentType.WORD;
    }

    @Override
    public void divideComponent(Component sourceComponent) {
        if (checkType(sourceComponent)) {
                String line = String.join("", sourceComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_CHARACTERS).matcher(line);
            while(matcher.find()){
                sourceComponent.add(new Component(ComponentType.CHARACTER,matcher.group()));
            }
        } else {
            System.out.println("No more Dividers");
        }
    }
}
