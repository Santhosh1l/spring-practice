package com.samna.services;

import com.samna.beans.Product;
import com.samna.util.InventoryValidation;

public class Client {
public static void main(String[] args) {
	
	        Product P1 = new Product(101, "Blue Pen", "Stationery", 10.0, 200);
	        Product P2 = new Product(102, "Pencil", "Stationery", 5.0, 200);
	        Product P3 = new Product(103, "Black Pen", "Stationery", 5.0, 200);
	        Product P4 = new Product(104, "Bike", "vehicle", 40.0, 200);

	        ProducutOperations.addProduct(P1);
	        ProducutOperations.addProduct(P2);
	        ProducutOperations.addProduct(P3); 
	        ProducutOperations.addProduct(P4);
	        
	        System.out.println(ProducutOperations.namelist);
	        String c="";
	        do  {
	        	try {
	            display();
	            System.out.println("Do you want to continue: ");
	            c=InventoryValidation.sc.nextLine();}
	        	catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
	        }while(c.equalsIgnoreCase("y"));
	    }



public static Product getinput() {
	// for getting input from the user
	int id = InventoryValidation.ProductvalidateId();
    String name = InventoryValidation.ValidateString("Name");
    String category=InventoryValidation.ValidateString("Category");
    double price=InventoryValidation.ValidatePrice();
    return new Product(id, name, category, price, 200);    
}



public static void display() throws Exception
{
	System.out.println("\n--- Inventory Menu ---");
    System.out.println("1. Add Product");
    System.out.println("2. Remove Product");
    System.out.println("3. Search Product by Name");
    System.out.println("4. Search Product by ID");
    System.out.println("5. List Products by Category");
    System.out.println("6. Print All Products ");
    System.out.println("7. Update the stock quanitity");
  
    System.out.print("Enter your choice: ");

    int ch = Integer.parseInt(InventoryValidation.sc.nextLine());
    
    switch (ch) {
        case 1:
        	
            ProducutOperations.addProduct(getinput());
            System.out.println("The product is Added to THe list");
            break;

        case 2:
//            System.out.print("Enter Product ID to remove: ");
//            int removeId = InventoryValidation.sc.nextInt();
//            InventoryValidation.sc.nextLine();
            ProducutOperations.removeProduct(InventoryValidation.productSearchId());
            break;

        case 3:
//            System.out.print("Enter Product Name to search: ");
//            String searchName = InventoryValidation.sc.nextLine();
//            InventoryManager.searchProductbyName(searchName);
//           
          System.out.println(ProducutOperations.searchProductbyName(InventoryValidation.ValidateString("product name")).toString());  ;
            break;

        case 4:
            
            System.out.println(ProducutOperations.searchProductById(InventoryValidation.productSearchId())); 

            break;

        case 5:
            
            ProducutOperations.listProductsByCategory(InventoryValidation.ValidateString("Category"));
            
            break;
        case 6:
        	ProducutOperations.display();
        	break;
        	
        case 7:
        	ProducutOperations.updateStock(101, 20);
        	break;
        case 8:
        	OrderOperations.inputOrder();
        	break;
        	
        default:
            System.out.println("Invalid choice. Please try again.");
    }
	}
}