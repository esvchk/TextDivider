package com.innowise.course.model;

import com.innowise.course.exception.TextException;

public abstract class AbstractContentComponent {

    public void add(AbstractContentComponent component) {
        throw new UnsupportedOperationException();
    }

    public String getText(){
        throw new UnsupportedOperationException();
    }


}
