package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class WordComponent extends AbstractContentComponent{

    private List<AbstractContentComponent> characters = new ArrayList<>();

    private String word;

    public WordComponent(String word) {
        this.word = word;
    }

    public List<AbstractContentComponent> getCharacters() {
        return characters;
    }

    @Override
    public void add(AbstractContentComponent component) {
        characters.add(component);
    }

    @Override
    public List<AbstractContentComponent> getInnerComponentList(AbstractContentComponent abstractContentComponent) {
        return characters;
    }

    @Override
    public String getText() {
        return word;
    }

    @Override
    public String toString() {
        return "WordComponent{" +
                "characters=" + characters +
                ", word='" + word + '\'' +
                '}';
    }
}
