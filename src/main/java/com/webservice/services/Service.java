package com.webservice.services;

import java.util.List;
import org.json.JSONObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.webservice.requestpojo.specificcountry.RestResponse;
import com.webservice.requestpojo.specificcountry.Result;
import com.webservice.requestpojo.specificcountry.ResultPojo;

/**
 * This API will perform country search
 * 
 * @author suyashnande
 *
 */
public class Service {

	public Response searchCountry(String alpha2Code, String alpha3Code, String name, List<String> messages) {

		try {
			Result result = new Result();
			result.setAlpha2Code(alpha2Code);
			result.setAlpha3Code(alpha3Code);
			result.setName(name);

			RestResponse restResponse = new RestResponse();
			restResponse.setMessages(messages);
			restResponse.setResult(result);

			// setting the login object
			ResultPojo resultPojo = new ResultPojo();
			resultPojo.setRestResponse(restResponse);

			JSONObject jsonObject = new JSONObject(resultPojo);

			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.headers("content-type", "application/json");
			requestSpecification.body(jsonObject.toString());
			Response response = requestSpecification.get(URLBuilder.countrySearchUrl);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Response getAllCountry(){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.headers("content-type", "application/json");
		Response response = requestSpecification.get(URLBuilder.allCountryUrl);
		System.out.println(response.asString());
		return response;
	}

}
