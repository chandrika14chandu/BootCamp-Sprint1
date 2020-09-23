package com.cg.bookstore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookstore.entity.Reviews;
import com.cg.bookstore.exception.ReviewIdDoesNotExistException;
import com.cg.bookstore.exception.ReviewIsUnAvailableException;
import com.cg.bookstore.service.ReviewsService;

/*******************************************************************************************************************************
 * -Author : Chandrika 
 * -Created/Modified Date : 00-09-2020 
 * -Description :ReviewsController Class for accessing Reviews services
*******************************************************************************************************************************/

@RestController
@RequestMapping("/reviews")
public class ReviewsController 
{

	@Autowired
	ReviewsService reviewService;

	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Reviews>> findAllReviews() throws ReviewIsUnAvailableException 
	{
	  List<Reviews> list = reviewService.findAllReviews();
	  ResponseEntity<List<Reviews>> listOfTests = new ResponseEntity<List<Reviews>>(list, HttpStatus.OK);
	  return listOfTests;
	}

	@DeleteMapping("/deleteReview")
	public boolean deleteAllReviews() throws ReviewIdDoesNotExistException, ReviewIsUnAvailableException 
	{
	  return reviewService.deleteAllReviews();
	}

	@GetMapping("/getReview/reviewId/{reviewId}")
	public ResponseEntity<Reviews> findReviewById(@PathVariable("reviewId") String reviewId) throws ReviewIdDoesNotExistException 
	{
	  Reviews review = reviewService.findReviewById(reviewId);
	  ResponseEntity<Reviews> reviewById = new ResponseEntity<Reviews>(review, HttpStatus.OK);
	  return reviewById;
	}

	@DeleteMapping("/deleteReview/reviewId/{reviewId}")
	public boolean deleteReviewById(@PathVariable("reviewId") String reviewId) throws ReviewIdDoesNotExistException 
	{
	  return reviewService.deleteReviewById(reviewId);
	}

	@PostMapping("/addReview")
	public ResponseEntity<Reviews> addReview(@Valid @RequestBody Reviews review) 
	{
	  Reviews addReview = reviewService.addReview(review);
	  ResponseEntity<Reviews> ResponseEntityadd = new ResponseEntity<Reviews>(addReview, HttpStatus.OK);
	  return ResponseEntityadd;
	}
	
	@ExceptionHandler(Exception.class)
	public String invalid(Exception e)
	{
	  return e.getMessage();
	}
}
