package com.innowise.course.model;

import java.util.List;

public class CharacterComponent extends AbstractContentComponent {

    private String character;

    public CharacterComponent(String character) {
        this.character = character;
    }

    @Override
    public void add(AbstractContentComponent component) {

    }

    @Override
    public List<AbstractContentComponent> getInnerComponentList() {
        return List.of();
    }

    @Override
    public String getText() {
        return character;
    }

    @Override
    public String toString() {
        return "CharacterComponent{" +
                "character='" + character + '\'' +
                '}';
    }
}
