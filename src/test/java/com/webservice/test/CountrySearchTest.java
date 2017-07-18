package com.webservice.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.webservice.responsepojo.specificcountry.CountrySearchResponsePojo;
import com.webservice.responsepojo.specificcountry.RestResponse;
import com.webservice.responsepojo.specificcountry.Result;
import com.webservice.services.Service;

public class CountrySearchTest {

	Service service;
	Response responseData;

	@Test
	public void countrySearchTest() {
		service = new Service();

		ArrayList<String> msgs = new ArrayList<String>();
		msgs.add("More webservices are available at http://www.groupkt.com/post/f2129b88/services.htm");
		msgs.add("Country found matching code [USA].");
		responseData = service.searchCountry("US", "USA", "United States of America", msgs);

		// logic to parse the response
		Gson gson = new Gson();
		CountrySearchResponsePojo data = gson.fromJson(responseData.asString(), CountrySearchResponsePojo.class);
		RestResponse restResponse = data.getRestResponse();
		System.out.println(restResponse.getMessages());

		Result getResult = restResponse.getResult();
		System.out.println(getResult.getName());
		System.out.println(getResult.getAlpha2Code());
		System.out.println(getResult.getAlpha3Code());

		// Validating the response
		Assert.assertEquals(getResult.getName(), "United States of America");
		Assert.assertEquals(getResult.getAlpha2Code(), "US");
		Assert.assertEquals(getResult.getAlpha3Code(), "USA");
		Assert.assertEquals(restResponse.getMessages(), msgs);
	}

}
