package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class SentenceComponent extends AbstractContentComponent{

    private List<AbstractContentComponent> words = new ArrayList<>();

    private String sentence;


    public SentenceComponent(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public void add(AbstractContentComponent component) {
        words.add(component);
    }

    @Override
    public String getText() {
        return sentence;
    }

    @Override
    public String toString() {
        return "SentenceComponent{" +
                "words=" + words +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
