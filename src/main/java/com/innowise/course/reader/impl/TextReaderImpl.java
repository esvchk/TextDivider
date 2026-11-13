package com.innowise.course.reader.impl;

import com.innowise.course.exception.TextException;
import com.innowise.course.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextReaderImpl implements TextReader {

    private final Logger logger = LogManager.getLogger(TextReaderImpl.class);

    @Override
    public List<String> read(Path path) throws TextException {
            try {
                return Files.readAllLines(path,StandardCharsets.UTF_8);
            } catch (IOException e) {
                logger.error("Cannot read a file with path{}",path);
                throw new TextException("Wrong file path",e);
            }
    }
}
