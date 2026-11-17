package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.CharacterComponent;
import com.innowise.course.model.WordComponent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterDivider extends AbstractDivider {

    private static final String DIVIDE_ON_CHARACTERS = "\\S";
    private WordComponent wordComponent;

    public CharacterDivider(WordComponent wordComponent) {
        this.wordComponent = wordComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) {
        String line = String.join("",abstractContentComponent.getText());
        Matcher matcher = Pattern.compile(DIVIDE_ON_CHARACTERS).matcher(line);
        while(matcher.find()){
            wordComponent.add(new CharacterComponent(matcher.group()));
        }
    }
}
