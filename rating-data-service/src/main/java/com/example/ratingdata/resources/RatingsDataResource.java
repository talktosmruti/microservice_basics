package com.example.ratingdata.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingdata.model.Rating;
import com.example.ratingdata.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingsDataResource {
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Rating getRating(@PathVariable("id") String id) {
		return new Rating("1", 4);
	}
	
	@RequestMapping(value ="/users/{userid}")
	public UserRating getUserRating(@PathVariable("userid") String userId) {
		UserRating ur = new UserRating();
		List<Rating> ratings  = Arrays.asList(
				new Rating("22", 3),
				new Rating("21", 4)
				);
		ur.setRatings(ratings);
		return ur;
	}

}
