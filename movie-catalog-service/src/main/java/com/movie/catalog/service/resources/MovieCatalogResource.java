package com.movie.catalog.service.resources;

/*import java.lang.reflect.ParameterizedType;
import java.util.Arrays;*/

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.movie.catalog.service.models.CatalogItem;
import com.movie.catalog.service.models.Movie;
//import com.movie.catalog.service.models.Rating;
import com.movie.catalog.service.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired private WebClient.Builder webClientBuilder;
	 */

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated IDs

		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingdata/user/" + userId,
				UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {

			// For each movie ID, call movie info service and get details

			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			// Put them all together

			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		}).collect(Collectors.toList());

	}
}

/*
 * Movie movie = webClientBuilder.build() .get()
 * .uri("http://localhost:8081/movies/"+ rating.getMovieId()) .retrieve()
 * .bodyToMono(Movie.class) .block();
 */
