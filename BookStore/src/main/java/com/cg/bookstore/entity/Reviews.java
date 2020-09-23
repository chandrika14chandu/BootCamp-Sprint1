package com.cg.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


/*******************************************************************************************************************************
-Author                   :     Chandrika
-Created/Modified Date    :     00-09-2020
-Description              :     Reviews Bean class
*******************************************************************************************************************************/

@Entity
public class Reviews 
{
	
	@Id
	@Column(name="ReviewId")
	private String reviewId;

	@Column(name="CustomerId")
	private String customerId;
	
	@Column(name="Rating")
	@Min(1)
	@Max(5)
	private int rating;
	
	@Column(name="Headline")
	@Size(min=20,max=128)
	private String headline;
	
	@Column(name="Review_Comment",length=300)
	@Size(min=100,max=300)
	private String comment;

	@ManyToOne
	@JoinColumn(name="BookId")
	private Books book = new Books();
	
	public String getCustomerId() 
	{
		return customerId;
	}

	public String getReviewId() 
	{
		return reviewId;
	}

	public void setReviewId(String reviewId) 
	{
		this.reviewId = reviewId;
	}

	public void setCustomerId(String customerId) 
	{
		this.customerId = customerId;
	}

	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating) 
	{
		this.rating = rating;
	}

	public String getHeadline() 
	{
		return headline;
	}

	public void setHeadline(String headline) 
	{
		this.headline = headline;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}

	public Books getBook() 
	{
		return book;
	}

	public void setBook(Books book) 
	{
		this.book = book;
	}
}