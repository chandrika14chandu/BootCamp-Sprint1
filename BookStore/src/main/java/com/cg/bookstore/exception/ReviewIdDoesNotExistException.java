package com.cg.bookstore.exception;

public class ReviewIdDoesNotExistException extends Exception 
{
  public ReviewIdDoesNotExistException(String message) 
  {
    super(message);
  }
  public ReviewIdDoesNotExistException()
  {
    super();
  }
}

