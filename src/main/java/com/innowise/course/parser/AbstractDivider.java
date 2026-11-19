package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;


public abstract class AbstractDivider {

    protected AbstractDivider nextDivider;

    public void setNextDivider(AbstractDivider nextDivider) {
        this.nextDivider = nextDivider;
    }

    protected abstract boolean checkInstance(AbstractContentComponent component);

    public abstract void divideComponent(AbstractContentComponent sourceComponent) throws TextException;
}
