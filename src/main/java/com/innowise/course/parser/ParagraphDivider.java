package com.innowise.course.parser;


import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParagraphDivider extends AbstractDivider {

    private static final String DIVIDE_ON_PARAGRAPH = "(?m)^[ \\t]+(\\S.*(?:\\n(?![ \\t]*$).*)*)";
    private AbstractDivider nextDivider;
    private AbstractContentComponent textComponent;


    public ParagraphDivider(AbstractContentComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void setNextDivider(AbstractDivider nextDivider) {
        this.nextDivider = nextDivider;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) throws TextException {
        if (abstractContentComponent instanceof TextComponent) {
            String line = String.join("\n", abstractContentComponent.getText());
            Matcher m = Pattern.compile(DIVIDE_ON_PARAGRAPH).matcher(line);
            while (m.find()) {
                textComponent.add(new ParagraphComponent(m.group()));
            }
            System.out.println("paragraph");
        } else if (nextDivider != null) {
            System.out.println("set next divider in paragraphdivider");
            nextDivider.divideComponent(abstractContentComponent);
        }


    }
}
