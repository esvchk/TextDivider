package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class ParagraphComponent extends AbstractContentComponent {

    private List<AbstractContentComponent> sentences = new ArrayList<>();

    private String paragraph;

    public ParagraphComponent(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void add(AbstractContentComponent component) {
        sentences.add(component);
    }

    @Override
    public List<AbstractContentComponent> getInnerComponentList() {
        return sentences;
    }

    @Override
    public String getText() {
        return paragraph;
    }

    @Override
    public String toString() {
        return "ParagraphComponent{" +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
