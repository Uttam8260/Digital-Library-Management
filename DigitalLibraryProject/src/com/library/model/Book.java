package com.library.model;

/**
 * Represents a Book in the Digital Library.
 */
public class Book {
	
	// Constructor to initialize book details
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters for book properties
    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    // Setters to update book details
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }

    //Returns book details as a formatted string
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author +
                ", Genre: " + genre + ", Status: " + availabilityStatus;
    }
}
