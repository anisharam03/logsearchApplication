package com.search;


import com.search.exception.InsufficientArgsException;
import com.search.exception.ReadFileException;
import com.search.exception.TooManyArgumentsException;
import com.search.service.SearchService;

import java.util.List;

public class SearchApplication {

  private static SearchService searchService ;

  public SearchApplication(SearchService searchService) {
    this.searchService = searchService;
  }

  public static void main(String[] args) throws InsufficientArgsException, TooManyArgumentsException {
    System.out.println("Get what you want....");
    validateArgs(args);
    final String path = args[0];
    final String keyword = args[1];
    searchService= SearchService.getInstance();
    try {
      List<String> resultSnippet = searchService.findSnippet(path, keyword);
      resultSnippet.forEach(System.out::println);
    } catch (ReadFileException e) {
      throw e;
    }

  }

  private static void validateArgs(String[] args) throws InsufficientArgsException, TooManyArgumentsException {
    if(args.length<2){
      throw new InsufficientArgsException("Please provide file path and search string");
    }
    if(args.length>2){
      throw new TooManyArgumentsException("Please provide file path and search string");
    }
  }

}
