package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.LexemeComponent;
import com.innowise.course.model.SentenceComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LexemeDivider extends AbstractDivider {

    private static final String DIVIDE_ON_LEXEME = "\\S+";
    private AbstractContentComponent sentenceComponent;
    private AbstractDivider nextDivider;

    public void setNextDivider(AbstractDivider nextDivider) {
        this.nextDivider = nextDivider;
    }

    public LexemeDivider(AbstractContentComponent sentenceComponent) {
        this.sentenceComponent = sentenceComponent;
    }

    @Override
    public void divideComponent(AbstractContentComponent abstractContentComponent) throws TextException {
        if (abstractContentComponent instanceof SentenceComponent) {
            String line = String.join(" ", abstractContentComponent.getText());
            Matcher matcher = Pattern.compile(DIVIDE_ON_LEXEME).matcher(line);
            while(matcher.find()){
                sentenceComponent.add(new LexemeComponent(matcher.group()));
            }
            System.out.println("lexeme");
        } else if (nextDivider != null){
            nextDivider.divideComponent(abstractContentComponent);
        }
    }
}
