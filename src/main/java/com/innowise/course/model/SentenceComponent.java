package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class SentenceComponent extends AbstractContentComponent{

    private List<AbstractContentComponent> lexemes = new ArrayList<>();

    private String sentence;


    public SentenceComponent(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public void add(AbstractContentComponent component) {
        lexemes.add(component);
    }

    @Override
    public List<AbstractContentComponent> getInnerComponentList(AbstractContentComponent abstractContentComponent) {
        return lexemes;
    }

    @Override
    public String getText() {
        return sentence;
    }

    @Override
    public String toString() {
        return "SentenceComponent{" +
                "words=" + lexemes +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
