package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;

import java.util.List;

public abstract class AbstractDivider {

    protected AbstractDivider nextHandler;

    public void setNextHandler(AbstractDivider nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void divideComponent(AbstractContentComponent abstractContentComponent);
}
