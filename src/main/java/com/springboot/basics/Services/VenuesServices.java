package com.springboot.basics.Services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.basics.helper.URIBuilderHelper;
import com.springboot.basics.model.Category;
import com.springboot.basics.model.ResponseObject;
import com.springboot.basics.model.Venue;
@Component
public class VenuesServices {
	
	RestTemplate restTemplate = new RestTemplate();
	
    
	@Autowired
	URIBuilderHelper uriBuilderHelper;
	
	public List<Venue> getAllVenues(String near) throws JsonParseException, JsonMappingException, IOException {
		String uri = uriBuilderHelper.getURI(near);
		ResponseEntity<ResponseObject> result = restTemplate.getForEntity(uri, ResponseObject.class);
		
		ResponseObject object  = result.getBody();
		List<Venue> venues = object.getResponse().getVenues();
		System.out.println(venues);
		List<Category> categories = (List<Category>) venues.stream().map(venue -> venue.getCategories());
		List<String> categoryNames = (List<String>) categories.stream().map(category -> category.getName());
		List<Venue> filteredVenuesByCategory = venues.stream().filter(venue -> venue.getCategories().stream().filter(category -> category.getName().equalsIgnoreCase("Salon / Barbershop")).collect(Collectors.toList());;
		return filteredVenuesByCategory;
		//return result.getBody();
	}
	
     
}
