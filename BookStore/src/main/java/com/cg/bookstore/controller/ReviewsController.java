package com.cg.bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookstore.entity.Reviews;
import com.cg.bookstore.exception.NoReviewIsAvailableException;
import com.cg.bookstore.exception.ReviewIdAlreadyExistsException;
import com.cg.bookstore.exception.ReviewIdDoesNotExistException;
import com.cg.bookstore.service.ReviewsService;

/*******************************************************************************************************************************
-Author                   :     Chandrika
-Created/Modified Date    :     00-09-2020
-Description              :     ReviewsController Class for accessing Reviews services
*******************************************************************************************************************************/

@RestController
@RequestMapping("/reviews")
public class ReviewsController
{

  @Autowired
  ReviewsService  reviewService;
	

  @GetMapping("/getAllReviews")
  public List<Reviews>  findAllReviews()throws NoReviewIsAvailableException 
  {
    return reviewService.findAllReviews();
  }	
	
	
  @DeleteMapping("/deleteReview")
  public boolean deleteAllReviews() throws ReviewIdDoesNotExistException, NoReviewIsAvailableException
  {
    return reviewService.deleteAllReviews();
  }
	

  @GetMapping("/getReview/reviewId/{reviewId}") 
  public Reviews findReviewById(@PathVariable("reviewId") String reviewId) throws ReviewIdDoesNotExistException
  {
    return reviewService.findReviewById(reviewId);
  }
	
	
  @DeleteMapping("/deleteReview/reviewId/{reviewId}")
  public boolean deleteReviewById(@PathVariable("reviewId") String reviewId) throws ReviewIdDoesNotExistException
  {
    return reviewService.deleteReviewById(reviewId);
  }
	

  @PostMapping("/addReview")
  public Reviews  addReview(@RequestBody Reviews review) throws ReviewIdAlreadyExistsException
  {
    return reviewService.addReview(review);
  }
}