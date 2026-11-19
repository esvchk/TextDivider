package com.innowise.course;

import com.innowise.course.exception.TextException;
import com.innowise.course.model.*;
import com.innowise.course.parser.*;
import com.innowise.course.reader.TextReader;
import com.innowise.course.reader.impl.TextReaderImpl;

import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) throws TextException {
        TextReader textReader = new TextReaderImpl();
        String line = String.join("\n", textReader.read(
                Path.of("D:\\courses\\project\\TextDivider\\.idea\\source.txt")));
        AbstractContentComponent textComponent = new TextComponent(line);
        ParagraphDivider paragraphDivider = new ParagraphDivider();
        SentenceDivider sentenceDivider = new SentenceDivider();
        LexemeDivider lexemeDivider = new LexemeDivider();
        WordDivider wordDivider = new WordDivider();
        CharacterDivider characterDivider = new CharacterDivider();

        paragraphDivider.setNextDivider(sentenceDivider);
        sentenceDivider.setNextDivider(lexemeDivider);
        lexemeDivider.setNextDivider(wordDivider);
        wordDivider.setNextDivider(characterDivider);
        characterDivider.setNextDivider(paragraphDivider);

        paragraphDivider.divideComponent(textComponent);

        System.out.println(textComponent);

        printTree(textComponent,0);


    }

    private static void printTree(AbstractContentComponent component, int level) {
        if (component == null) return;

        // отступ: 2 пробела на каждый уровень
        String indent = "  ".repeat(level);

        // одна строка на узел: тип, текст (обрезанный), число детей
        List<AbstractContentComponent> children = component.getInnerComponentList(component);
        System.out.println(indent
                + "├─ " + component.getClass().getSimpleName()
                + " [" + truncate(component.getText(), 60) + "]"
                + " (children=" + children.size() + ")");

        // рекурсия по детям
        for (AbstractContentComponent child : children) {
            printTree(child, level + 1);
        }
    }

    /** Обрезает строку до max символов, заменяет переводы строк на \n для читаемости. */
    private static String truncate(String s, int max) {
        if (s == null) return "null";
        String oneLine = s.replace("\n", "\\n").replace("\r", "");
        return oneLine.length() <= max ? oneLine : oneLine.substring(0, max) + "…";
    }
}
