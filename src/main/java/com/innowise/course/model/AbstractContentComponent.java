package com.innowise.course.model;


import java.util.List;

public abstract class AbstractContentComponent {

    public abstract void add(AbstractContentComponent component);

    public abstract List<AbstractContentComponent> getInnerComponentList(AbstractContentComponent abstractContentComponent);

    public abstract String getText();


}
