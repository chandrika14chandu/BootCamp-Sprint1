package com.cg.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*******************************************************************************************************************************
 * -Author : Chandrika -Created/Modified Date : 00-09-2020 -Description :
 * Reviews Bean class
 *******************************************************************************************************************************/

@Entity
public class Reviews {

	

	@Id
	@Column(name = "ReviewId")
	private String reviewId;

	@NotEmpty(message = "CustomerId is Mandatory field, please provide CustomerId")
	@Column(name = "CustomerId")
	private String customerId;

	@NotEmpty(message = "Rating is Mandatory field, please provide Rating")
	@Min(value = 1, message = "Rating value cannot be lessthan 1")
	@Max(value = 5, message = "Rating value cannot be greater than 5")
	@Column(name = "Rating")
	private int rating;

	@Column(name = "Headline")
	@NotEmpty(message = "Headline is Mandatory field, please provide Headline")
	@Size(min = 20, max = 128, message = "Headline should be between 20 to 120 characters")
	private String headline;

	@Column(name = "Review_Comment", length = 300)
	@NotEmpty(message = "comment is Mandatory field, please provide comment")
	@Size(min = 100, max = 300, message = "Comment should be between 100 to 300 characters")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "BookId")
	private Books book = new Books();

	public String getCustomerId() {
		return customerId;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", customerId=" + customerId + ", rating=" + rating + ", headline="
				+ headline + ", comment=" + comment + ", book=" + book + ", getCustomerId()=" + getCustomerId()
				+ ", getReviewId()=" + getReviewId() + ", getRating()=" + getRating() + ", getHeadline()="
				+ getHeadline() + ", getComment()=" + getComment() + ", getBook()=" + getBook() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}