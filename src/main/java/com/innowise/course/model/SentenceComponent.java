package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;

public class SentenceComponent extends AbstractContentComponent{

    private List<AbstractContentComponent> lexemes = new ArrayList<>();

    private String sentence;


    public SentenceComponent(String sentence) {
        this.sentence = sentence;
    }

    public List<AbstractContentComponent> getLexemes() {
        return lexemes;
    }

    public void setLexemes(List<AbstractContentComponent> lexemes) {
        this.lexemes = lexemes;
    }

    @Override
    public void add(AbstractContentComponent component) {
        lexemes.add(component);
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
