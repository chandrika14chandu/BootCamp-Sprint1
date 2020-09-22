package com.cg.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookstore.dao.ReviewsDao;
import com.cg.bookstore.entity.Reviews;
import com.cg.bookstore.exception.NoReviewIsAvailableException;
import com.cg.bookstore.exception.ReviewIdAlreadyExistsException;
import com.cg.bookstore.exception.ReviewIdDoesNotExistException;

/*******************************************************************************************************************************
-Author                   :     Chandrika
-Created/Modified Date    :     00-09-2020
-Description              :     ReviewsServiceImpl Class implements services for Reviews Class
*******************************************************************************************************************************/

@Service
public class ReviewsServiceImpl implements ReviewsService
{
	
  @Autowired
  ReviewsDao reviewsDao;

/*******************************************************************************************************************************
	-Function Name            :     findAllReviews
	-Input Parameters         :     -
	-Return Type              :     List of reviews
	-Throws                   :     NoReviewIsAvailableException
	-Author                   :     Chandrika
	-Created/Modified Date    :     -09-2020
	-Description              :     getting all reviews from the database by calling the method findAllReviews()
*******************************************************************************************************************************/
  @Override
  public List<Reviews> findAllReviews() throws NoReviewIsAvailableException 
  {
    List<Reviews> listOfReviews = reviewsDao.findAll();
	if(listOfReviews.isEmpty())
	{
	  throw new NoReviewIsAvailableException("No Review Is Available in the Reviews List ");
	}
	reviewsDao.findAll();
	return listOfReviews;
  }

/*******************************************************************************************************************************
    -Function Name            :     deleteAllReviews
    -Input Parameters         :     -
    -Return Type              :     boolean
    -Throws                   :     NoReviewIsAvailableException
    -Author                   :     Chandrika
    -Created/Modified Date    :     -09-2020
    -Description              :     delete all reviews in the database by calling the method deleteAllReviews()
*******************************************************************************************************************************/	
	
	@Override
	public boolean deleteAllReviews() throws NoReviewIsAvailableException 
	{
	  List<Reviews> listOfReviews = reviewsDao.findAll();
	  if(listOfReviews.isEmpty())
	{
			
	  throw new NoReviewIsAvailableException("No Review Is Available in the Reviews List for Delete Operation");
	}
	  reviewsDao.deleteAll();;
	  return true;
	}
	
/*******************************************************************************************************************************
	-Function Name            :     findReviewById
	-Input Parameters         :     reviewId
	-Return Type              :     review object
	-Throws                   :     ReviewIdDoesNotExistException
	-Author                   :     Chandrika
	-Created/Modified Date    :     -09-2020
	-Description              :     getting a review from the database by calling the method findReviewById(reviewId)
*******************************************************************************************************************************/
	
	@Override
	public Reviews findReviewById(String reviewId) throws ReviewIdDoesNotExistException
	{
	  if(!reviewsDao.existsById(reviewId)) 
	  {
	    throw new ReviewIdDoesNotExistException("Review with id " + reviewId + " not found");
	  }
	  return reviewsDao.findById(reviewId).get();
	}

/*******************************************************************************************************************************
    -Function Name            :     deleteReviewById
    -Input Parameters         :     -
    -Return Type              :     boolean
    -Throws                   :     ReviewIdDoesNotExistException
    -Author                   :     Chandrika
    -Created/Modified Date    :     -09-2020
    -Description              :     delete reviews by id in the database by calling the method deleteReviewById(reviewId)
*******************************************************************************************************************************/	
	
	@Override
	public boolean deleteReviewById(String reviewId) throws ReviewIdDoesNotExistException 
	{
	  Reviews deleteReview =null;
	  if( reviewsDao.existsById(reviewId))
	  {
	    deleteReview = reviewsDao.findById(reviewId).get();
	    reviewsDao.deleteById(reviewId);
		return true;
	  }
	  else
	  {
	    throw new ReviewIdDoesNotExistException ("Review with reviewId " + reviewId + " Does Not Exists");
	  }
	 }
	
/*******************************************************************************************************************************
	-Function Name            :     addReview
	-Input Parameters         :     Reviews Object
	-Return Type              :     addReview object
	-Throws                   :     ReviewIdAlreadyExistsException
	-Author                   :     Chandrika
	-Created/Modified Date    :     -09-2020
	-Description              :     adding Reviews to the database by calling the method addReview(review)
*******************************************************************************************************************************/
	
	@Override
	public Reviews addReview(Reviews review) throws ReviewIdAlreadyExistsException 
	{
	  if(reviewsDao.existsById(review.getReviewId()))
	  {
	    throw new ReviewIdAlreadyExistsException("Review with reviewId " + review.getReviewId() + " alreadyExists");	
	  }
	  if(reviewsDao.existsById(review.getCustomerId()))
	  {
			throw new ReviewIdAlreadyExistsException("Review with customerId" +review.getCustomerId()+ " alreadyExists");	
	  }
	  Reviews  addReview = reviewsDao.save(review);
	  return addReview;
	 }
}