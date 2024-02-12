package com.restassured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XmlSchemaValidation {

	@Test
	public void schemaValidation() throws Throwable {
		
	File file = new File("./Add.xml");
		
		if(file.exists())
			System.out.println("This file available on this location");
		
		FileInputStream file1 = new FileInputStream(file);
		String reqbody = IOUtils.toString(file1,"UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(reqbody).
		when().
		post("calculator.asmx").
		then().
		statusCode(200).log().all().
		and().
		body("//*:AddResult.text()",equalTo("14"));
		
	}
}
