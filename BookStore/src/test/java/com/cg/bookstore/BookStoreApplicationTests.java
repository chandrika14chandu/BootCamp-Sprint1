package com.cg.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.bookstore.dao.ReviewsDao;
import com.cg.bookstore.entity.Reviews;
import com.cg.bookstore.exception.ReviewIsUnAvailableException;
import com.cg.bookstore.service.ReviewsServiceImpl;

@SpringBootTest
class BookStoreApplicationTests 
{
	@Autowired
	ReviewsServiceImpl reviewService;

	@MockBean
	ReviewsDao reviewsDao;

	@Test
	public void addReview() 
	{
	  Reviews review = new Reviews();
	  when(reviewsDao.save(review)).thenReturn(review);
	  assertEquals(review, reviewService.addReview(review));
	}

	@Test
	public void deleteAll() throws ReviewIsUnAvailableException 
	{
	  when(reviewsDao.findAll()).thenReturn(Stream.of(new Reviews()).collect(Collectors.toList()));
	  assertEquals(true, reviewService.deleteAllReviews());
	}
	
	@Test
	public void findAll() throws ReviewIsUnAvailableException 
	{
	  when(reviewsDao.findAll()).thenReturn(Stream.of(new Reviews()).collect(Collectors.toList()));
	  assertEquals(true, reviewService.deleteAllReviews());
	}
}
