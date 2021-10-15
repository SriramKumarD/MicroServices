package com.srird.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.srird.moviecatalogservice.models.CatalogItem;
import com.srird.moviecatalogservice.models.Movie;
import com.srird.moviecatalogservice.models.Rating;
import com.srird.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBulider;
	
	@RequestMapping("{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		//get all the rated movieIDs 
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" +userId, UserRating.class);
		
		return userRating.getUserRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" +rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
		
		//For each movid Id,Call movie info service and get the details
		
		//Put them all together 
		/*return Collections.singletonList(
				
	    );
		*/
		
		/*
		 * Movie movie = webClientBulider.build() 
		 * .get()
		 * .uri("http://localhost:8081/movies/" +rating.getMovieId()) 
		 * .retrieve()
		 * .bodyToMono(Movie.class) 
		 * .block();
		 */
		
		
		
	}
}
