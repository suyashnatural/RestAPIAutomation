package com.webservice.test;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.webservice.responsepojo.allcountry.AllCountryPojo;
import com.webservice.responsepojo.allcountry.RestResponse;
import com.webservice.responsepojo.allcountry.Result;
import com.webservice.services.Service;

public class AllCountryTest {
	
	Service service;
	Response responseData;
	
	@Test
	public void testGetAllCountry(){
		service = new Service();
		responseData = service.getAllCountry();
		
		Gson gson = new Gson();
		AllCountryPojo data = gson.fromJson(responseData.asString(), AllCountryPojo.class);
		
		RestResponse getRestResponse = data.getRestResponse();
		
		List<String> getMessages = getRestResponse.getMessages();
		List<Result> getResult = getRestResponse.getResult();
		
		for (int i = 0; i < getResult.size(); i++) {
			System.out.println(getResult.get(i).getName());
			System.out.println(getResult.get(i).getAlpha2Code());
			System.out.println(getResult.get(i).getAlpha3Code());
		}
		System.out.println("---------------------------");
		for (int i = 0; i < getMessages.size(); i++) {
			System.out.println("msg-"+getMessages.get(i));
		}
		
	}

}
