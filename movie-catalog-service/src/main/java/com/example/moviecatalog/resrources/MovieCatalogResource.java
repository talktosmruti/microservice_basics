package com.example.moviecatalog.resrources;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviecatalog.model.MovieItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping(value ="/{userId}", method=RequestMethod.GET )
	public List<MovieItem> getCatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(
				new MovieItem("DDLJ", "GEM IN ROMANTIC", 4)
		);
	}

}
