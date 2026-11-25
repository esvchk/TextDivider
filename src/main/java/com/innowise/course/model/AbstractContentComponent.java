package com.innowise.course.model;


import com.innowise.course.exception.TextException;

import java.util.List;

public abstract class AbstractContentComponent {

    public void add(Component component) throws TextException {
        throw new TextException("");
    }


    public List<Component> getInnerComponentList() throws TextException {
        throw new TextException("");
    }

    public String getText() throws TextException {
        throw new TextException("");
    }


}
