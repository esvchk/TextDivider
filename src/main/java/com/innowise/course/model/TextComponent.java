package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractContentComponent {

    private List<AbstractContentComponent> paragraphs = new ArrayList<>();

    private String text;

    public List<AbstractContentComponent> getParagraphs() {
        return paragraphs;
    }

    public TextComponent(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }


    @Override
    public void add(AbstractContentComponent component) {
        paragraphs.add(component);
    }

    @Override
    public String toString() {
        return "TextComponent{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
