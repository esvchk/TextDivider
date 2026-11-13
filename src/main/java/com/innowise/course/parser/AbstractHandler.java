package com.innowise.course.parser;

import com.innowise.course.model.AbstractContentComponent;

import java.util.List;

public abstract class AbstractHandler {

    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(List<String> text);
}
