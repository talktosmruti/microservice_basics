package com.example.moviecatalog.resrources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalog.model.CatalogItem;
import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping(value ="/{userId}", method=RequestMethod.GET )
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		RestTemplate rest = new RestTemplate();
		List<CatalogItem> catalogs = new ArrayList<>();
		// Get all rated movie ids
		List<Rating> ratings =  Arrays.asList(
				new Rating("21", 4),
				new Rating("22", 2)
				);
		for (Rating r:ratings) {
			Movie m = rest.getForObject("http://localhost:8082/movies/"+r.getId(), Movie.class);
			catalogs.add(new CatalogItem(m.getName(), "sample", r.getRating()));
		}
		//For each movie id, call movie info service and get details
		
		
		return catalogs;

	}

}
