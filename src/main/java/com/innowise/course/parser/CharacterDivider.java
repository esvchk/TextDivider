package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.CharacterComponent;
import com.innowise.course.model.WordComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CharacterDivider extends AbstractDivider {

    private static final String DIVIDE_ON_CHARACTERS = "\\S";
    private AbstractContentComponent contentComponent;

    public CharacterDivider(AbstractContentComponent contentComponent) {
        this.contentComponent = contentComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) throws TextException {
        if (abstractContentComponent instanceof WordComponent) {
            String line = String.join("",abstractContentComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_CHARACTERS).matcher(line);
            while(matcher.find()){
                contentComponent.add(new CharacterComponent(matcher.group()));
            }
        } else  {
            throw new TextException("No more handling");
        }
    }
}
