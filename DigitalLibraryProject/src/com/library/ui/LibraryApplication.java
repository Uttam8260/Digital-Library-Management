package com.library.ui;

import com.library.model.Book;
import com.library.service.LibraryService;
import java.util.Scanner;

//This is the main class that runs the Digital Library Book Management System because here we are writing main method.
 
public class LibraryApplication {
    private static final LibraryService libraryService = new LibraryService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
        	//Display menu options
            System.out.println("\n1. Add Book\n2. View All Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Exit");
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> libraryService.viewAllBooks().forEach(System.out::println);
                case 3 -> searchBook();
                case 4 -> updateBook();
                case 5 -> deleteBook();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String status = scanner.nextLine();
        libraryService.addBook(new Book(id, title, author, genre, status));
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title: ");
        Book book = libraryService.searchBook(scanner.nextLine());
        System.out.println(book != null ? book : "Book not found!");
    }

    private static void updateBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("New Title (leave blank to skip): ");
        String title = scanner.nextLine();
        System.out.print("New Author (leave blank to skip): ");
        String author = scanner.nextLine();
        System.out.print("New Status (Available/Checked Out): ");
        String status = scanner.nextLine();
        System.out.println(libraryService.updateBook(id, title, author, status) ? "Updated!" : "Book not found!");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID: ");
        System.out.println(libraryService.deleteBook(scanner.nextLine()) ? "Deleted!" : "Book not found!");
    }
}
