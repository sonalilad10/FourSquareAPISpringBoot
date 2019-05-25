package com.springboot.basics.helper;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.basics.Constants.Constants;

@Component
public class URIBuilderHelper {
	@Value("${CLIENT_ID}") 
	String CLIENT_ID;
	
	public String getURI(String near) {
		if (near == null) {
			return "Must provide parameter near";
		}
		return Constants.BASE_URL + "near=" + near + "&client_id=" + CLIENT_ID + "&client_secret="
				+ Constants.CLIENT_SECRET + "&v=" + Constants.v;
	}
	
//	@Value("${google.key}")
//	String key;
//	
//	@Value("${google.GOOGLE_API}")
//	String key;
//	
//	
//	public String getGooglePlacesURI(String near) {
//		if (near == null) {
//			return "Must provide parameter near";
//		}
//		return Constants.BASE_URL + "near=" + near + "&client_id=" + CLIENT_ID + "&client_secret="
//				+ Constants.CLIENT_SECRET + "&v=" + Constants.v;
//	}
}
