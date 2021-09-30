package com.srird.ratingdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srird.ratingdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movidId}")
	public Rating getRating(@PathVariable ("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

}
