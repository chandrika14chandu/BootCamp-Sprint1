package com.cg.bookstore.exception;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler 
{
  @ExceptionHandler(ReviewIdAlreadyExistsException.class)
  public ResponseEntity<ErrorInfo>  handleException(ReviewIdAlreadyExistsException exception,HttpServletRequest request)
  {		
    String message=exception.getMessage();
    String uri= request.getRequestURI();	 
	ErrorInfo  errorinfo = new ErrorInfo(LocalDateTime.now(),message,uri);
	ResponseEntity<ErrorInfo>  responseentity = new ResponseEntity<ErrorInfo>(errorinfo,HttpStatus.NOT_FOUND);
	return responseentity;
  }
	
  @ExceptionHandler(ReviewIsUnAvailableException.class)
  public ResponseEntity<ErrorInfo>  handleException(ReviewIsUnAvailableException exception,HttpServletRequest request)
  {
    String message=exception.getMessage();
	String uri= request.getRequestURI();	 
	ErrorInfo  errorinfo = new ErrorInfo(LocalDateTime.now(),message,uri);
	ResponseEntity<ErrorInfo>  responseentity = new ResponseEntity<ErrorInfo>(errorinfo,HttpStatus.NOT_FOUND);
	return responseentity;
  }
	
  @ExceptionHandler(ReviewIdDoesNotExistException.class)
  public ResponseEntity<ErrorInfo>  handleException(ReviewIdDoesNotExistException exception,HttpServletRequest request)
  {
    String message=exception.getMessage();
	String uri= request.getRequestURI();	 
	ErrorInfo  errorinfo = new ErrorInfo(LocalDateTime.now(),message,uri);
	ResponseEntity<ErrorInfo>  responseentity = new ResponseEntity<ErrorInfo>(errorinfo,HttpStatus.NOT_FOUND);
	return responseentity;
  }
}

