package com.example.movieinfo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable("id") String id) {
		return new Movie("1", "Sehenhsah");
		
	}
}
