package com.innowise.course.parser;


import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParagraphDivider extends AbstractDivider {

    private static final String DIVIDE_ON_PARAGRAPH = "(?m)^[ \\t]+(\\S.*(?:\\n(?![ \\t]*$).*)*)";
    private final TextComponent textComponent;


    public ParagraphDivider(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) {
        String line = String.join("\n", abstractContentComponent.getText());
        Matcher m = Pattern.compile(DIVIDE_ON_PARAGRAPH).matcher(line);
        while (m.find()) {
            textComponent.add(new ParagraphComponent(m.group()));
        }

    }
}
