package com.search.service;

import com.search.exception.ReadFileException;
import com.sun.source.tree.Scope;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchService {

  private static SearchService searchService = null;

  private SearchService() {
  }

  public static SearchService getInstance() {
    if (searchService == null) {
      searchService = new SearchService();
    }
    return searchService;
  }

  public List<String> findSnippet(String path, String keyword) {
    String fileContent = null;
    try {
      fileContent = readFile(path);
    } catch (Exception e) {
      throw new ReadFileException("Sorry, Couldn't read the file.");
    }
    String[] sentences = fileContent.split("\n|\\.(?!\\d)|(?<!\\d)\\.");
    Stream<String> sentenceStream = Arrays.stream(sentences);
    List<String> resultSentence = sentenceStream.filter(sentence -> sentence.contains(keyword)).collect(
        Collectors.toList());
    return resultSentence;

  }

  private String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }

}
