package com.innowise.course.reader;

import com.innowise.course.exception.TextException;

import java.nio.file.Path;
import java.util.List;

public interface TextReader {

    List<String> read(Path path) throws TextException;

}
