package com.search;

import com.search.exception.InsufficientArgsException;
import com.search.exception.TooManyArgumentsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SearchApplicationTest {

  SearchApplication searchApp;


  @Test
  public void throwsExceptionWhenInsufficientArgumentsSupplied() {
    String args[] = new String[0];
    assertThrows(InsufficientArgsException.class, () -> searchApp.main(args));
  }


  @Test
  public void throwsExceptionWhenTooManyArgumentsSupplied() {
    List<String> args = new ArrayList<String>();
    args.add("path");
    args.add("keywords");
    args.add("extraArg");
    assertThrows(TooManyArgumentsException.class, () -> searchApp.main(args.toArray(new String[0])));
  }


}