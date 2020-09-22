package com.cg.bookstore.exception;

public class NoReviewIsAvailableException extends Exception 
{
  public NoReviewIsAvailableException(String message) 
  {
    super(message);
  }
  public NoReviewIsAvailableException()
  {
    super();
  }
}
