package com.cg.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*******************************************************************************************************************************
 * -Author : Chandrika 
 * -Created/Modified Date : 00-09-2020 
 * -Description : Books Bean class
 *******************************************************************************************************************************/

@Entity
public class Books 
{

	@Id
	private String bookId;

	@NotNull(message = "Title is Mandatory field, please provide Title")
	private String title;

	public String getBookId() 
	{
	  return bookId;
	}

	public void setBookId(String bookId) 
	{
	  this.bookId = bookId;
	}

	public String getTitle() 
	{
	  return title;
	}

	public void setTitle(String title) 
	{
	  this.title = title;
	}

	@Override
	public String toString() 
	{
	  return "Books [bookId=" + bookId + ", title=" + title + ", getBookId()=" + getBookId() + ", getTitle()="
			  + getTitle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			  + super.toString() + "]";
	}
}