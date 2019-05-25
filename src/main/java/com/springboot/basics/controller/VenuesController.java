package com.springboot.basics.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.basics.Services.VenuesServices;
import com.springboot.basics.model.ResponseObject;
import com.springboot.basics.model.Venue;
@RestController
public class VenuesController {

	@Autowired
	VenuesServices service;
	
	@GetMapping(path="/venues")
	public List<Venue> getPlaces(
			@RequestParam("near") String near) throws JsonParseException, JsonMappingException, IOException {
		return service.getAllVenues(near);
	}
	
//	@GetMapping(path="/places")
//	public GenericResponse getPlacesWithGoogle(@RequestParam("near") String near) throws JsonParseException, JsonMappingException, IOException {
//		return service.getAllVenuesWithGoogle(near);
//	}
}
