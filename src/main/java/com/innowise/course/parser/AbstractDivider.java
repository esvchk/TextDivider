package com.innowise.course.parser;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;

import java.util.List;

public abstract class AbstractDivider {

    protected AbstractDivider nextDivider;

    public void setNextDivider(AbstractDivider nextHandler) {
        this.nextDivider = nextHandler;
    }



    public abstract boolean checkInstance(AbstractContentComponent component);

    public abstract void divideComponent(AbstractContentComponent sourceComponent) throws TextException;
}
