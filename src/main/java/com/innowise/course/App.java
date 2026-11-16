package com.innowise.course;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.AbstractContentComponent;
import com.innowise.course.model.ParagraphComponent;
import com.innowise.course.model.TextComponent;
import com.innowise.course.parser.ParagraphDivider;
import com.innowise.course.parser.SentenceDivider;
import com.innowise.course.reader.TextReader;
import com.innowise.course.reader.impl.TextReaderImpl;

import java.nio.file.Path;

public class App
{
    public static void main( String[] args ) throws TextException {
        TextReader textReader = new TextReaderImpl();
        String line = String.join("\n",textReader.read(Path.of("D:\\courses\\project\\TextAssembly\\.idea\\source.txt")));

        TextComponent textComponent = new TextComponent(line);
        ParagraphDivider paragraphDivider = new ParagraphDivider(textComponent);
        paragraphDivider.divideComponent(textComponent);
        for (AbstractContentComponent component : textComponent.getParagraphs()){
            ParagraphComponent paragraphComponent = new ParagraphComponent(component.getText());
            SentenceDivider sentenceDivider = new SentenceDivider(paragraphComponent);
            sentenceDivider.divideComponent(paragraphComponent);
            System.out.println(paragraphComponent.getSentences());
        }










    }
}
