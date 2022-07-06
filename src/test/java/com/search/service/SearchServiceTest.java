package com.search.service;

import com.search.exception.ReadFileException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

  SearchService searchService = SearchService.getInstance();

  @Test
  public void shouldReadFileAndReturnMatchingSnippet() {
    List<String> search = searchService.findSnippet("src/test/resources/testInput.txt", "course");
    assertEquals(5, search.size());

  }

  @Test
  public void shouldThrowReadFileException() {
    assertThrows(ReadFileException.class, () -> searchService.findSnippet(null, "search"));
  }

  @Test
  public void shouldReadFileAndReturnMatchingSnippetForMultipleWords() {
    List<String> search = searchService.findSnippet("src/main/resources/sampleInput.txt", "Information Service");
    assertEquals(1, search.size());
  }
}