package com.restsample.restassured.test;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class RestAssuredServiceTest {
	/*
	 * Get status of book service 
	 */
	@Test
	public void testStatus() {
		expect().statusCode(200)
		.body(equalTo("Service is Running")).when().get("/RESTSampleService/restSample/books/status");

	}
	/*
	 * Hello world! from book service 
	 */
	@Test
	public void getHelloWorld() {
		expect().statusCode(200)
		.body(equalTo("Hello world!")).when().get("/RESTSampleService/restSample/books/hello");
	}	
	/*
	 * get first book name as a JSON
	 * using expect()......when().get()
	 */
	@Test
	public void testGetFirstBook() {

		expect().statusCode(200)
		.body("bookName",equalTo("Advanced Java Book"),
				"authorFirstName",equalTo("Alan"),
				"authorLastName",equalTo("Alte"),
				"publisherName",equalTo("Addison & Addison")	
						).when().get("/RESTSampleService/restSample/books/singleBook/json");
	}

	/*
	 * get first book name as a xml
	 *  by using get....then.. assertThat
	 */
	
	@Test
	public void testGetFirstBookAsXML() {

		get("/RESTSampleService/restSample/books/singleBook/xml").then().assertThat().
		body("bookInfo.bookName",equalTo("Advanced Java Book"),
			 "bookInfo.authorFirstName",equalTo("Alan"),
			 "bookInfo.authorLastName",equalTo("Alte"),
			 "bookInfo.publisherName",equalTo("Addison & Addison")
				);
	}

	/*
	 * Add book Info test 
	 *  
	 */
	
	@Test
	public void testAddBook() {
		
		String authorFirstName = "Dole";
		String authorLastName = "Dean";
		String bookName = "Dark Nights of Dryden Street";
		String publisherName = "Dwayne Publishing";
		String isbnNumber = "55512345";
		
		given().
			parameters("firstName",authorFirstName,
					    "lastName",authorLastName,
					    "bookName",bookName,
					    "pubName",publisherName,
					    "isbnNo",isbnNumber).
		when().
			get("/RESTSampleService/restSample/books/add/book").
		then().
			body(containsString("ok"));

	}
	
	/*
	 * get first book programmatically 
	 *  
	 */
	
	@Test
	public void testGetFirstBookProgrammatically() {
	
		Response res = get("/RESTSampleService/restSample/books/singleBook/json");
		assertEquals(200, res.getStatusCode());
		String response = res.asString();
		JsonPath jsonPath = new JsonPath(response);
		assertEquals("Alan", jsonPath.get("authorFirstName"));
		assertEquals("Alte", jsonPath.get("authorLastName"));
		assertEquals("Advanced Java Book", jsonPath.get("bookName"));
		assertEquals("Addison & Addison", jsonPath.get("publisherName"));
		

	}


}
