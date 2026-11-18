package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SentenceDivider extends AbstractDivider {

    private static final String DIVIDE_ON_SENTENCE = "(?s)[^.!?]+[.!?]+(?:\\s|$)|[^.!?]+$";
    private AbstractContentComponent contentComponent;

    public SentenceDivider(AbstractContentComponent paragraphComponent) {
        this.contentComponent = paragraphComponent;
    }

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
                contentComponent.add(new SentenceComponent(m.group()));
            }
            for (AbstractContentComponent component : contentComponent.getInnerComponentList(sourceComponent)){
                nextDivider.divideComponent(component);
            }
        } else if (nextDivider != null) {
            nextDivider.divideComponent(sourceComponent);
        }


    }
}
