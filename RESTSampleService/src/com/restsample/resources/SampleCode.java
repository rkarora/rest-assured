package com.restsample.resources;

/*
 * This is a Sample REST service used in REST-assured testing 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;


@Path("/books")
public class SampleCode {

	static List<BookInfo> booksList = getBooksList(); 
	//http://localhost:8080/RESTSampleService/restSample/books/singleBook/json
	//http://localhost:8080/RESTSampleService/restSample/books/singleBook/xml
	//http://localhost:8080/RESTSampleService/restSample/books/allbooks/json
	//http://localhost:8080/RESTSampleService/restSample/books/allbooks/xml
	
	//http://localhost:8080/RESTSampleService/restSample/books/add/book?lastName=ll&firstName=fff&pubName=pub&isbnNo=123456
	
	//Curl command to get HTML content
	//curl -i -H "Accept: text/html" -X GET http://localhost:8080/RESTSampleService/restSample/sample
	//Curl command to get XML content
	//curl -i -H "Accept: text/xml" -X GET http://localhost:8080/RESTSampleService/restSample/sample
	//Curl command to get plain text content
	//curl -i -H "Accept: text/plain" -X GET http://localhost:8080/RESTSampleService/restSample/sample

	
	/*   
	 * Return status as a response
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status")
	public Response getStatus() {
		
		return Response.ok("Service is Running").build();
	}

	/*   
	 * Return status as a response
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public Response getHello() {
		
		return Response.ok("Hello world!").build();
	}

	/*   
	 * Return a single book from the list in JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/singleBook/json")
	public BookInfo getSingleBookInfoInJSONFormat() {
		
		//return getBooksList().get(0);
		return booksList.get(0);
		
	}
	
	/*   
	 * Return a single book from the list in XML
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/singleBook/xml")
	public BookInfo getSingleBookInfoInXMLFormat() {
		
		return booksList.get(0);
	}
	/*   
	 * Return all books from the list in JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allbooks/json")
 	public List<BookInfo> getAllBooksInJSONFormat() {

		return booksList;
	}
	/*   
	 * Return all books from the list in XML
	 */

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/allbooks/xml")
 	public List<BookInfo> getAllBooksInXMLFormat() {

		return booksList;
	}	
	/*   
	 * Add a new book in the list via GET
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/add/book")
 	public BookInfo addNewBookInTheList_XML(@QueryParam("lastName") String lastName,
 			@QueryParam("firstName") String firstName,
 			@QueryParam("bookName") String bookName,
 			@QueryParam("pubName") String pubName,
 			@QueryParam("isbnNo") String isbnNo
 			) {

		BookInfo bookInfo = new BookInfo();
		bookInfo.setAuthorLastName(lastName);
		bookInfo.setAuthorFirstName(firstName);
		bookInfo.setBookName(bookName);
		bookInfo.setPublisherName(pubName);
		bookInfo.setIsbnNo(isbnNo);
		booksList.add(bookInfo);

		return bookInfo;
		
	}	
/*
 * 
 * 
 * 
 * 
 */
	
	public static List<BookInfo> getBooksList() {
		
		// add first book 
		List<BookInfo> books = new ArrayList<BookInfo>();	
		BookInfo bookInfo1 = new BookInfo();
		bookInfo1.setAuthorLastName("Alte");
		bookInfo1.setAuthorFirstName("Alan");
		bookInfo1.setBookName("Advanced Java Book");
		bookInfo1.setPublisherName("Addison & Addison");
		bookInfo1.setIsbnNo("12345789");
		books.add(bookInfo1);
		
		// add 2nd book 		
		BookInfo bookInfo2 = new BookInfo();
		bookInfo2.setAuthorLastName("Bert");
		bookInfo2.setAuthorFirstName("Bob");
		bookInfo2.setBookName("Beginners - Java Book");
		bookInfo2.setPublisherName("BoB - Bert Publishing");
		bookInfo2.setIsbnNo("22245789");
		books.add(bookInfo2);
		// add 3rd book 
		BookInfo bookInfo3 = new BookInfo();
		bookInfo3.setAuthorLastName("Code");
		bookInfo3.setAuthorFirstName("Carman");
		bookInfo3.setBookName("C-Programming Book");
		bookInfo3.setPublisherName("Computer Technology Publishing");
		bookInfo3.setIsbnNo("33345789");
		books.add(bookInfo3);
		return books;
	}
	
}
