package com.innowise.course.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String rebuildTextBack(){
        StringBuilder sb = new StringBuilder();
        for (AbstractContentComponent component : getInnerComponentList(this)){
            Matcher m = Pattern.compile("^[ \\t]").matcher(component.getText());
            if (m.find()) {
                sb.append("\n");
            }
            sb.append(component.getText());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "TextComponent{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
