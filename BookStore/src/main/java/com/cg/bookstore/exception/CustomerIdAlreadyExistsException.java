package com.cg.bookstore.exception;

public class CustomerIdAlreadyExistsException extends Exception 
{

  public CustomerIdAlreadyExistsException(String message) 
  {
     super(message);
  }
  public CustomerIdAlreadyExistsException()
  {
    super();
  }
}
