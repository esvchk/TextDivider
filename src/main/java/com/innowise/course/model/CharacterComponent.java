package com.innowise.course.model;

public class CharacterComponent extends AbstractContentComponent {

    private String character;

    public CharacterComponent(String character) {
        this.character = character;
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
