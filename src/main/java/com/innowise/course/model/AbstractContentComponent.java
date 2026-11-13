package com.innowise.course.model;


public abstract class AbstractContentComponent {

    public void add(AbstractContentComponent component) {
        throw new UnsupportedOperationException();
    }

    public String getText(){
        throw new UnsupportedOperationException();
    }


}
