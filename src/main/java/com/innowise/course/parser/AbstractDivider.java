package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.Component;


public abstract class AbstractDivider {

    protected AbstractDivider nextDivider;

    public void setNextDivider(AbstractDivider nextDivider) {
        this.nextDivider = nextDivider;
    }

    public abstract boolean checkType(Component component);

    public abstract void divideComponent(Component component) throws TextException;
}
