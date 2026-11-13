package com.innowise.course.parser;

public abstract class AbstractHandler {

    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String text);
}
