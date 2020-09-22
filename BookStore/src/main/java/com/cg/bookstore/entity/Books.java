package com.cg.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*******************************************************************************************************************************
-Author                   :     Chandrika
-Created/Modified Date    :     00-09-2020
-Description              :     Books Bean class
*******************************************************************************************************************************/

@Entity
public class Books {

	@Id
	private String bookId;
	
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
}	