package com.myunderstand.demo;

import java.util.Scanner;
import com.myunderstand.beans.LibraryBooks;
import com.myunderstand.util.ValidationUtil;

public class Client {
   // static Scanner sc = new Scanner(System.in);
    static LibraryBooks[] bookDB = new LibraryBooks[0]; 

    public static void main(String[] args) {
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n----------------- Menu -----------------");
            System.out.println("1. Add book to Database");
            System.out.println("2. Display books in the Database");
            System.out.print("Enter your choice: ");

            try {
                int choice = ValidationUtil.validateChoice();

                switch (choice) {
                    case 1:
                        System.out.print("How many books do you want to add to the DB? ");
                        int size = ValidationUtil.sc.nextInt();
                        // Consume newline
                        bookDB = addBookDB(size);
                        break;

                    case 2:
                        if (bookDB.length == 0) {
                            System.out.println("No books in the database.");
                        } else {
                            System.out.println("\nBooks in the database:");
                            for (LibraryBooks book : bookDB) {
                                display(book);
                            }
                        }
                        break;
                    case 3:
                    	

                    default:
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                }

              
                System.out.print("\nDo you want to continue? (yes/no): ");
                String response = ValidationUtil.sc.nextLine().trim().toLowerCase();
                if (!response.equals("yes") && !response.equals("y")) {
                    continueProgram = false;
                    System.out.println("Exiting the program. Goodbye!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                ValidationUtil.sc.nextLine(); 
            }
        }
    }
    public static LibraryBooks[] addBookDB(int n) throws Exception {
        LibraryBooks[] arr = new LibraryBooks[n];
      

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            String id = ValidationUtil.validateId();
            String title = ValidationUtil.validateBook();
            String author = ValidationUtil.validateAuthor();
            double price = ValidationUtil.validatePrice();
            float rating = ValidationUtil.validateRating();

            try {
                arr[i] = new LibraryBooks(id, title, author, price, rating);
                System.out.println("Book added successfully!");
               // display(arr[i]);
            } catch (Exception e) {
                System.out.println("Error adding book: " + e.getMessage());
            }
        }

        return arr;
    }

    public static void display(LibraryBooks book) {
        System.out.println("\n-----------------------------");
        System.out.println("ID     : " + book.getId());
        System.out.println("Title  : " + book.getTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.printf("Price  : ₹%.2f\n", book.getPrice());
        System.out.printf("Rating : %.2f / 5.0\n", book.getRating());
        System.out.println("-----------------------------");
    }
}
