package com.restassured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class TestOnLocalApi {
	
	@Test
	public void getMethod() {
		
		baseURI = "http://localhost:3000/";
		given().get("employees").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void postMethod() {
		
		JSONObject req = new JSONObject();
		
		req.put("employeeName", "Divyaa");
		req.put("designation", "Test Automation Engineer");
		req.put("subjectId",1);
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		
		
		when().
		post("employees").
		
		then().
		statusCode(201);
		
	}
	
	@Test
	public void putMethod() {
		
		JSONObject req = new JSONObject();
		
		req.put("employeeName", "divyaaa");
		req.put("designation", "Quality Engineer");
		req.put("subjectId",2);
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		
		when().
		put("employees/faf1").
		
		then().
		statusCode(200);
		
	}
	
	@Test
	public void patchMethod() {
		
		JSONObject req = new JSONObject();
		
		
		req.put("designation","Test Lead");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		
		when().
		patch("employees/faf1").
		
		then().
		statusCode(200);
		
	}

}
