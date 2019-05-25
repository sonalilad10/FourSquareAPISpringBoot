package com.springboot.basics.controller;

import org.junit.Before;
import org.mockito.Mock;

import com.springboot.basics.Services.VenuesServices;

public class VenuesControllerTest {

	
	VenuesController venuesController;
	
	@Mock
    private VenuesServices venuesService;
	
	@Before
	public void setup() {
		venuesController = new VenuesController();
	}
	
//	@Test
//	public void test_getPlaces() throws JsonParseException, JsonMappingException, IOException {
//		String ll = "";
//		String near = "pune";
//		when(venuesService.getAllVenues(ll, near)).thenReturn("Places Result Object");
//		String result = venuesController.getPlaces(ll, near);
//		assertNotNull(result);
//	}
}
