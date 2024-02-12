package com.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUT_PATCH_DELETE_Examples {
	
	@Test
	public void putMethod() {
		
		baseURI = "https://reqres.in/";
		given().
			get("api/users?page=2").
		then().
			statusCode(200).
			body("data[0].first_name",equalTo("Michael")).
			body("data.first_name",hasItems("Michael","George"));
		
	}
	
	@Test
	public void putMethod1() {
		
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
			put("api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void patchMethod() {
		
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
			patch("api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	@Test
	public void deleteMethod() {
		baseURI = "https://reqres.in/";
		when().
			delete("api/users/2").
		then().
			statusCode(204).
			log().all();
		
	}
	

}
