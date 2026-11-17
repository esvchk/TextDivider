package com.innowise.course;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.*;
import com.innowise.course.parser.*;
import com.innowise.course.reader.TextReader;
import com.innowise.course.reader.impl.TextReaderImpl;

import java.nio.file.Path;

public class App
{
    public static void main( String[] args ) throws TextException {
        TextReader textReader = new TextReaderImpl();
        String line = String.join("\n",textReader.read(Path.of("D:\\courses\\project\\TextDivider\\.idea\\source.txt")));

        TextComponent textComponent = new TextComponent(line);
        ParagraphDivider paragraphDivider = new ParagraphDivider(textComponent);
        paragraphDivider.divideComponent(textComponent);
        for (AbstractContentComponent component : textComponent.getParagraphs()){
            ParagraphComponent paragraphComponent = new ParagraphComponent(component.getText());
            SentenceDivider sentenceDivider = new SentenceDivider(paragraphComponent);
            sentenceDivider.divideComponent(paragraphComponent);
            for (AbstractContentComponent component1 : paragraphComponent.getSentences()){
                SentenceComponent sentenceComponent = new SentenceComponent(component1.getText());
                LexemeDivider lexemeDivider = new LexemeDivider(sentenceComponent);
                lexemeDivider.divideComponent(sentenceComponent);
                for (AbstractContentComponent component2 : sentenceComponent.getLexemes()){
                    LexemeComponent lexemeComponent = new LexemeComponent(component2.getText());
                    WordDivider wordDivider = new WordDivider(lexemeComponent);
                    wordDivider.divideComponent(lexemeComponent);
                    for (AbstractContentComponent component3 : lexemeComponent.getWords()){
                        WordComponent wordComponent = new WordComponent(component3.getText());
                        CharacterDivider characterDivider = new CharacterDivider(wordComponent);
                        characterDivider.divideComponent(wordComponent);
                        System.out.println(wordComponent.getCharacters());
                    }
                }
            }
        }












    }
}
