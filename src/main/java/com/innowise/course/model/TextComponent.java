package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractContentComponent {

    private List<AbstractContentComponent> paragraphs = new ArrayList<>();

    private String text;


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
    public List<AbstractContentComponent> getInnerComponentList(AbstractContentComponent abstractContentComponent) {
        return paragraphs;
    }

    public int charCounter(){
        return text.length();
    }

    public int letterCounter() {
        int counter = 0;
        char[] chars = this.text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "TextComponent{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
