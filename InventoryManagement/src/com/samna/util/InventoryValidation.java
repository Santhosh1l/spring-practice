package com.samna.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.samna.beans.Product;
import com.samna.services.InventoryManager;
import com.samna.services.ProducutOperations;

public class InventoryValidation {

	public static Scanner sc = new Scanner(System.in);

	public static int ProductvalidateId() {
		int id;

		while (true) {
			System.out.print("Enter Product ID (3 digits): ");
			try {

				id = Integer.parseInt(sc.nextLine());

				if (id < 100 || id > 999) {
					System.err.print("Product ID must be a 3-digit number (between 100 and 999).");
					continue;

				}

				if (checkingID(id)) {
					System.out.println("Product ID already exists. Please enter a unique ID.");
					continue;
				}

				return id;
			} catch (NumberFormatException e) {
				System.out.println("Error: The product ID must be a number only.");
				sc.next();
			}
		}
	}

	public static int productSearchId() {
		int id;

		while (true) {
			System.out.print("Enter Product ID (3 digits): ");
			try {

				id = Integer.parseInt(sc.nextLine());

				if (id < 100 || id > 999) {
					System.err.print("Product ID must be a 3-digit number (between 100 and 999).");
					continue;
					// throw new Exception("Product ID must be a 3-digit number (between 100 and
					// 999).");
				}
				return id;
			} catch (NumberFormatException e) {
				System.out.println("Error: The product ID must be a number only.");
				sc.next();
			}
		}
	}

	public static boolean checkingID(int id) {
		boolean found = false;

		for (Product data : InventoryManager.productList) {
			if (id == data.getId()) {
				found = true;
				break;
			}
		}

		return found;
	}

	public static String ValidateString(String title) {
		String category = "";

		while (true) {
			System.out.printf("Enter %s: ", title);

			try {
				category = sc.nextLine();
				if (!category.matches("^[a-zA-Z ]+$")) {
					System.err.print("Name must contain only letters and spaces.");
					continue;
				}
				return category;
			} catch (InputMismatchException e) {
				System.out.println("Error: " + e.getMessage());
				sc.next();
			}
		}
	}

	public static double ValidatePrice() {
		double price;
		while (true) {
			System.out.println("Enter the price of the Product");

			try {
				price = sc.nextDouble();
				sc.nextLine();
				if (price < 0) {
					System.err.println("The price of product must be Greater than zero");
					continue;
				}
				return price;
			} catch (InputMismatchException e) {
				System.out.println("Error OCcured" + e.getMessage());
				sc.next();
			}

		}

	}

	// Order Class Validation

	public static String OrderValidateCustomerName() {
		return "sant";
	}

	public static int OrderIdValidation() {
		// TODO Auto-generated method stub
		return 0;
	}
}
