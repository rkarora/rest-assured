package com.restsample.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookInfo {

	private String bookName;
	private String authorLastName;
	private String authorFirstName;
	private String publisherName;
	private String isbnNo;
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String lastName) {
		this.authorLastName = lastName;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String firstName) {
		this.authorFirstName = firstName;
	}

	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	
	
}
