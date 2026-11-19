package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.CharacterComponent;
import com.innowise.course.model.WordComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CharacterDivider extends AbstractDivider {

    private static final String DIVIDE_ON_CHARACTERS = "\\S";



    @Override
    public boolean checkInstance(AbstractContentComponent component) {
        return component instanceof WordComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent sourceComponent) throws TextException {
        if (checkInstance(sourceComponent)) {
            String line = String.join("", sourceComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_CHARACTERS).matcher(line);
            while(matcher.find()){
                sourceComponent.add(new CharacterComponent(matcher.group()));
            }
        } else if (nextDivider != null){
            nextDivider.divideComponent(sourceComponent);
        }
    }
}
