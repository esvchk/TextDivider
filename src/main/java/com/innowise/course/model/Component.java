package com.innowise.course.model;

import com.innowise.course.exception.TextException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Component extends AbstractContentComponent {

    private List<Component> components = new ArrayList<>();
    private ComponentType type;
    private String text;


    public Component(ComponentType type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }


    @Override
    public void add(Component component) {
        components.add(component);
    }


    public ComponentType getType() {
        return type;
    }

    @Override
    public List<Component> getInnerComponentList() {
        return components;
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
        for (Component component : getInnerComponentList()){
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
        return "Component{" +
                ", type=" + type +
                ", text='" + text + '\'' +
                '}';
    }
}
