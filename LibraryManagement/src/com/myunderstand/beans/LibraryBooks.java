package com.myunderstand.beans;

import com.myunderstand.util.ValidationUtil;

public class LibraryBooks implements Comparable<LibraryBooks> {
	private String id;
	private String title;
	private String author;
	private double price;
	private float rating;
	
	

public LibraryBooks(String id, String title, String author, double price, float rating) throws Exception {
//	ValidationUtil.validateName(author);
//	ValidationUtil.validateName(title);
//	ValidationUtil.validateId(id);
//	ValidationUtil.validateRating(rating);
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }


public void setId(String id) {
	this.id = id;
}
public void setTitle(String title) {
	this.title = title;
}
public void setAuthor(String author) {
	this.author = author;
}
public void setPrice(double price) {
	this.price = price;
}
public void setRating(float rating) {
	this.rating = rating;
}
public String getId() {
	return id;
}
public String getTitle() {
	return title;
}
public String getAuthor() {
	return author;
}
public double getPrice() {
	return price;
}
public float getRating() {
	return rating;
}


@Override
public int compareTo(LibraryBooks o) {
	
	return this.id.compareTo(o.getId());
}


}
