package com.restassured;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class First_Test_RestAssured {

	@Test
	public void myMethod() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void exampleMethod() {
		
		baseURI = "https://reqres.in";
		given().
			get("api/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8)).
			log().all();
		
	}
	
}
