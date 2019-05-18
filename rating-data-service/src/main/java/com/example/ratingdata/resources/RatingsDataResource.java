package com.example.ratingdata.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingdata.model.Rating;

@RestController
@RequestMapping("/rating")
public class RatingsDataResource {
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Rating getRating(@PathVariable("id") String id) {
		return new Rating("1", 4);
	}

}
