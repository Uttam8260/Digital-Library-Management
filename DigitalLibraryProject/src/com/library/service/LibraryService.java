package com.library.service;

import com.library.model.Book;
import java.util.*;

/**
 * Manages book operations like adding, searching, updating, and deleting books.
 */
public class LibraryService {
    private final Map<String, Book> bookCatalog = new HashMap<>();

     //Adds a book to the catalog.
     
    public void addBook(Book book) {
        if (bookCatalog.containsKey(book.getBookID())) {
            System.out.println("Book ID already exists!");
            return;
        }
        bookCatalog.put(book.getBookID(), book);
        System.out.println("Book added successfully!");
    }


     //Returning all books in the catalog.
    
    public Collection<Book> viewAllBooks() {
        return bookCatalog.values();
    }

    //Searches for a book by ID or title.
     
    public Book searchBook(String input) {
        return bookCatalog.values().stream()
                .filter(book -> book.getBookID().equals(input) || book.getTitle().equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }

    //Updates book details.
     
    public boolean updateBook(String bookID, String newTitle, String newAuthor, String newStatus) {
        Book book = bookCatalog.get(bookID);
        if (book == null) return false;
        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (newStatus.equals("Available") || newStatus.equals("Checked Out")) book.setAvailabilityStatus(newStatus);
        return true;
    }

    //Deletes a book by ID.
     
    public boolean deleteBook(String bookID) {
        return bookCatalog.remove(bookID) != null;
    }
}
