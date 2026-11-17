package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;

public abstract class AbstractDivider {

    protected AbstractDivider nextDivider;

    public void setNextDivider(AbstractDivider nextHandler) {
        this.nextDivider = nextHandler;
    }

    public abstract void divideComponent(AbstractContentComponent abstractContentComponent);
}
