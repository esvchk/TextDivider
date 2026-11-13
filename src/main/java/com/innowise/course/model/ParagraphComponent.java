package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class ParagraphComponent extends AbstractContentComponent {

    private List<AbstractContentComponent> lexemes = new ArrayList<>();

    private String paragraph;

    public ParagraphComponent(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void add(AbstractContentComponent component) {
        lexemes.add(component);
    }

    @Override
    public String getText() {
        return paragraph;
    }
}
