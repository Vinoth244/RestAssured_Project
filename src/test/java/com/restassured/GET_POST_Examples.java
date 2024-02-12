package com.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GET_POST_Examples {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/";
		given().
			get("api/users?page=2").
		then().
			statusCode(200).
			body("data[0].first_name",equalTo("Michael")).
			body("data.first_name",hasItems("Michael","George"));
		
	}
	
	@Test
	public void postMethod() {
		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("name","Vinoth");
//		map.put("job","Test Engineer");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name","Vinoth");
		request.put("job","Test Engineer");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("api/users").
		then().
			statusCode(201).
			log().all();
		
		
	}

}
