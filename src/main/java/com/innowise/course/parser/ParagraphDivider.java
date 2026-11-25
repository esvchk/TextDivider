package com.innowise.course.parser;


import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.Component;
import com.innowise.course.model.ComponentType;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphDivider extends AbstractDivider {

    private static final String DIVIDE_ON_PARAGRAPH = "(?m)^[ \\t]+(\\S.*(?:\\n(?![ \\t]*$).*)*)";


    @Override
    public boolean checkType(Component component) {
        return component.getType() == ComponentType.TEXT;
    }

    @Override
    public void divideComponent(Component sourceComponent){
        try {
            if (checkType(sourceComponent)) {
                String line = String.join("\n", sourceComponent.getText());
                Matcher m = Pattern.compile(DIVIDE_ON_PARAGRAPH).matcher(line);
                while (m.find()) {
                    sourceComponent.add(new Component(ComponentType.PARAGRAPH,m.group()));
                }
                for (Component component : sourceComponent.getInnerComponentList()){
                    nextDivider.divideComponent(component);
                }
            } else if (nextDivider != null) {
                nextDivider.divideComponent(sourceComponent);
            }
        } catch (TextException e) {

        }

    }


}
