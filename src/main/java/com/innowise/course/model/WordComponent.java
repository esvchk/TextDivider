package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class WordComponent extends AbstractContentComponent{

    private List<AbstractContentComponent> characters = new ArrayList<>();

    private String word;

    public WordComponent(String word) {
        this.word = word;
    }

    @Override
    public void add(AbstractContentComponent component) {
        characters.add(component);
    }

    @Override
    public String getText() {
        return word;
    }
}
