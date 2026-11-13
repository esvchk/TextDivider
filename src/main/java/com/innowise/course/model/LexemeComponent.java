package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class LexemeComponent extends AbstractContentComponent {

    private List<AbstractContentComponent> words = new ArrayList<>();

    private String lexeme;

    public LexemeComponent(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void add(AbstractContentComponent component) {
        words.add(component);
    }

    @Override
    public String getText() {
        return lexeme;
    }
}
