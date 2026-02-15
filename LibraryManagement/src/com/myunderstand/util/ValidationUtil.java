package com.myunderstand.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationUtil {
	
	
	 public static Scanner sc = new Scanner(System.in);
	 
	
	public static String validateId() {
        while (true) {
            try {
            	
                System.out.print("Book ID: ");
                String id = sc.nextLine();
                if (!id.matches(".*[a-zA-Z].*") || !id.matches(".*\\d.*") || id.length() < 4) {
                    throw new Exception("❌ The Book ID must contain at least one alphabet, one digit, and be at least 4 characters long.");
                }

                return id; 
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.next();
            }
        }
    }

	
	public static String validateBook() throws Exception{
		
		
		while(true) {
			
			try {
				System.out.println("Enter the Book Name: ");
				String bookName=sc.nextLine();
		if((!bookName.matches("[.A-Za-z ]+"))) {
			throw new Exception("Name must contain only alphabets🔠");}
		else if(bookName.matches(" ")) {
			throw new Exception("❌ The Book name contain only space❌, Please Enter the Book Name Correctly");
		}
		return bookName;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				sc.next();
			}
		
		}
	}
	
	public static String validateAuthor(){
		String authorName = "";
	    while (true) {
	        try {
	            System.out.println("Enter the Author Name:");
	            authorName = sc.nextLine();

	            if (authorName.isEmpty()) {
	                System.out.println("❌ Author name cannot be empty or just spaces ❌");
	                continue;
	            }

	            if (!authorName.matches("[A-Za-z. ]+")) {
	                System.out.println("🔠 Name must contain only alphabets (e.g., J.K. Rowling)");
	                continue;
	            }
	            break;


	        } catch (InputMismatchException e) {
	            System.out.println(e.getMessage());
	            sc.next();
	        }
	        
	    }
		return authorName;
	}
	public static int validateChoice()throws Exception {
		int ch= sc.nextInt();
		sc.nextLine();	
		while(true) {
			try {
				if(ch!=1 && ch!=2){
					throw new Exception("Choice Either 1 or 2: ");
			
				}
				return ch;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				sc.next();
			}
		}
		
		
	}
public static float validateRating() throws Exception{
		
		while(true) {
			System.out.println("Enter the Rating: ");
			float rating= sc.nextFloat();
			sc.nextLine();
			try {
			if (rating < 0 || rating > 5) {
		    throw new Exception("Rating must be between 0 and 5.");
		    }
			return rating;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				sc.next();
			}
			
		}
	}
	
	
	
	
	
	


    public static double validatePrice() throws Exception {
        double price = 0.0;

        while (true) {
            try {
                System.out.println("Enter the Price:");
                price = sc.nextDouble();

                if (price < 100) {
                    throw new Exception("The book price must be higher than 100.");
                }

                return price;

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.next(); 
            }
        }
    }
    }

    


