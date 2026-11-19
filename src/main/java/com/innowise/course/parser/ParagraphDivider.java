package com.innowise.course.parser;


import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.TextComponent;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParagraphDivider extends AbstractDivider {

    private static final String DIVIDE_ON_PARAGRAPH = "(?m)^[ \\t]+(\\S.*(?:\\n(?![ \\t]*$).*)*)";

    @Override
    public boolean checkInstance(AbstractContentComponent abstractContentComponent) {
        return abstractContentComponent instanceof TextComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent sourceComponent) throws TextException {
        if (checkInstance(sourceComponent)) {
            String line = String.join("\n", sourceComponent.getText());
            Matcher m = Pattern.compile(DIVIDE_ON_PARAGRAPH).matcher(line);
            while (m.find()) {
                sourceComponent.add(new ParagraphComponent(m.group()));
            }
            for (AbstractContentComponent component : sourceComponent.getInnerComponentList(sourceComponent)){
                nextDivider.divideComponent(component);
            }
        } else if (nextDivider != null) {
            nextDivider.divideComponent(sourceComponent);
        }
    }
}
