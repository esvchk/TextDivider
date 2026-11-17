package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SentenceDivider extends AbstractDivider {

    private static final String DIVIDE_ON_SENTENCE = "(?s)[^.!?]+[.!?]+(?:\\s|$)|[^.!?]+$";
    private AbstractContentComponent paragraphComponent;
    private AbstractDivider nextDivider;

    @Override
    public void setNextDivider(AbstractDivider nextDivider) {
        this.nextDivider = nextDivider;
    }

    public SentenceDivider(AbstractContentComponent paragraphComponent) {
        this.paragraphComponent = paragraphComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) throws TextException {
        if (abstractContentComponent instanceof ParagraphComponent) {
            String line = String.join("\n", abstractContentComponent.getText());
            Matcher m = Pattern.compile(DIVIDE_ON_SENTENCE).matcher(line);
            while (m.find()){
                paragraphComponent.add(new SentenceComponent(m.group()));
            }
            System.out.println("sentence");
        } else if (nextDivider != null) {
            System.out.println("set next divider in sentencedivider");;
            nextDivider.divideComponent(abstractContentComponent);
        }


    }
}
