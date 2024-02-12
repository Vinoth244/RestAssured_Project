package com.restassured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;


public class OwnApi_Test {
	
	@Test
	public void getMethod() {
		
		baseURI = "http://localhost:3000/";
		given().get("users").then().statusCode(200).log().all();
		
	}
	
//	@Test
//	public void postMethod() {
//		
//		JSONObject req = new JSONObject();
//		
//		req.put("firstName", "manish");
//		req.put("lastName", "pandey");
//		req.put("subjectId",1);
//		
//		baseURI = "http://localhost:3000/";
//		
//		given().
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		body(req.toJSONString()).
//		
//		
//		when().
//		post("users").
//		
//		then().
//		statusCode(201);
//		
//	}
	
//	@Test
//	public void putMethod() {
//		
//		JSONObject req = new JSONObject();
//		
//		req.put("firstName","siddhu");
//		req.put("lastName","ranjith");
//		req.put("subjectId",2);
//		
//		baseURI = "http://localhost:3000/";
//		
//		given().
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		body(req.toJSONString()).
//		
//		when().
//		put("users/ccee").
//		
//		then().
//		statusCode(200);
//		
//	}
	
	@Test
	public void patchMethod() {
		
		JSONObject req = new JSONObject();
		
		
		req.put("lastName","abhimanyu");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		
		when().
		patch("users/ccee").
		
		then().
		statusCode(200);
		
	}
	
	@Test
	public void deleteMethod() {
		
		baseURI = "http://localhost:3000/";
		
		when().
		delete("users/ccee").
		then().statusCode(200);
		
	
	
	}
	

}
