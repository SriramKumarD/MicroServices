package com.srird.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srird.ratingdataservice.models.Rating;
import com.srird.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movidId}")
	public Rating getRating(@PathVariable ("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable ("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("121", 1),
				new Rating("131", 4)
	    );
	    UserRating userRatings = new UserRating();
	    userRatings.setUserRatings(ratings);
	    return userRatings;
	}
	

}
