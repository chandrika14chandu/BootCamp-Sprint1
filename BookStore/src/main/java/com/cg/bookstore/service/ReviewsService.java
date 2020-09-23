package com.cg.bookstore.service;

import java.util.List;
import com.cg.bookstore.entity.Reviews;
import com.cg.bookstore.exception.ReviewIdAlreadyExistsException;
import com.cg.bookstore.exception.ReviewIdDoesNotExistException;
import com.cg.bookstore.exception.ReviewIsUnAvailableException;

/*******************************************************************************************************************************
 * -Author : Chandrika -Created/Modified Date : 00/09/2020 -Description :
 * ReviewsService Interface with services for Reviews
 *******************************************************************************************************************************/

public interface ReviewsService {

	public Reviews addReview(Reviews review) ;

	public boolean deleteReviewById(String reviewId) throws ReviewIdDoesNotExistException;

	public boolean deleteAllReviews() throws ReviewIsUnAvailableException;

	public Reviews findReviewById(String reviewId) throws ReviewIdDoesNotExistException;

	public List<Reviews> findAllReviews() throws ReviewIsUnAvailableException;

}