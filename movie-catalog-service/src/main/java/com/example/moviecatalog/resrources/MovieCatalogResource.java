package com.example.moviecatalog.resrources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalog.model.CatalogItem;
import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.model.Rating;
import com.example.moviecatalog.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate rest;
	
	@RequestMapping(value ="/{userId}", method=RequestMethod.GET )
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		List<CatalogItem> catalogs = new ArrayList<>();
		UserRating ratings = null ;
		// Get all rated movie ids
		try {
		 ratings = rest.getForObject("http://localhost:8083/rating/users/"+userId, UserRating.class);
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
		for (Rating r:ratings.getRatings()) {
			Movie m = rest.getForObject("http://localhost:8082/movies/"+r.getId(), Movie.class);
			catalogs.add(new CatalogItem(m.getName(), "sample", r.getRating()));
		}
		//For each movie id, call movie info service and get details
		return catalogs;

	}

}
