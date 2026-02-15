package com.samna.services;

import java.util.*;

import com.samna.beans.Order;
import com.samna.beans.Product;
import com.samna.util.InventoryValidation;

public class ProducutOperations {

	public static Map<String, List<String>> namelist = new HashMap<>();

  
   // addProduct(Product p)
   // → Add to productList, categoryMap, stockMap, and productNames.
    
    public static void addProduct(Product p) {
    											

InventoryManager.productList.add(p);
         if (!InventoryManager.categoryMap.containsKey(p.getCategory())) {
        	 InventoryManager.categoryMap.put(p.getCategory(), new ArrayList<Product>());
 		}
         InventoryManager.categoryMap.get(p.getCategory()).add(p);
//         if (!InventoryManager.namelist.containsKey(p.getCategory())) {
//        	 
//        	 InventoryManager.namelist.put(p.getCategory(),  addlist(p.getCategory()));
//  		}
//         
//         else { InventoryManager.namelist.get(p.getCategory()).add(p.getName());}
 		
 		
         InventoryManager.stockMap.put(p.getId(), p.getStockQuantity());
         InventoryManager.productNames.add(p.getName());

    	
    }
    
  public static List<String> addlist(String cat){
	  
	  List<String> r= new ArrayList<>();
	  for(Product p: InventoryManager.productList) {
		  if(p.getCategory().equals(cat)) {
			  r.add(p.getName());
		  }
	  }
	return r;
	  
	  
  }
    
  // To remove the product from the list map.
  
public static void removeProduct(int productId) {
    	Product p = null;
        boolean found = false;

        for (int i = 0; i < InventoryManager.productList.size(); i++) {
            if (InventoryManager.productList.get(i).getId() == productId) {
                p = InventoryManager.productList.get(i);
                InventoryManager.productList.remove(i);
                System.out.println("The product is removed");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("The product is not found");
            return;
        }

        if (p != null) {
            List<Product> categoryProducts = InventoryManager.categoryMap.get(p.getCategory());
            for (int i = 0; i < categoryProducts.size(); i++) {
                if (categoryProducts.get(i).getId() == productId) {
                    categoryProducts.remove(i);
                    break;
                }
            }
        }

        InventoryManager.stockMap.remove(productId);
        InventoryManager.productNames.remove(p.getName());
    	
    }
    
    public static Product searchProductbyName(String name) throws Exception {
    	    for (Product p : InventoryManager.productList) {
    	        if (p.getName().equalsIgnoreCase(name)) {
    	        //    System.out.println("The product is found: " + p.getId());
    	            return p;
    	        }
    	    }
    	    throw new Exception("The product is not found"); 
    	}
    	
    
    public static Product searchProductById(int id)throws Exception {
    	    for (Product p : InventoryManager.productList) {
    	        if (id == p.getId()) {
    	           // System.out.println("Product found: " + p.toString());
    	            return p; 
    	        }
    	    }
    	  
    	     throw new Exception("The Product id is not found"); 
    	}
    
    
    
    
public static void listProductsByCategory(String category) {
    	List<Product> products = InventoryManager.categoryMap.get(category);
    	if (products == null || products.isEmpty()) {
    		System.out.println("No products found in category: " + category);
    		return;
    		}

    System.out.println("Products in category '" + category + "':");
    System.out.println(products.toString());
}
    
    
    // display the ProductList Method

public static void display() {
	if (InventoryManager.productList.isEmpty()) {
        System.out.println("No products available in inventory.");
        return;
    }

    System.out.println("All Products in Inventory:");
    for (Product p : InventoryManager.productList) {
        System.out.println(p.toString()); 
    }
}


public static void updateStock(int productId, int newQuantity) throws Exception {
	
	Product updatestocks=  searchProductById( productId);
	String cate=updatestocks.getCategory();
	
	if(updatestocks!=null) {
	int idx=InventoryManager.productList.indexOf(updatestocks);
	int updatequantity= newQuantity+updatestocks.getStockQuantity();
	
	InventoryManager.productList.get(idx).setStockQuantity(updatequantity);
	
	InventoryManager.stockMap.put(productId, updatequantity);
    
    for(Product p: InventoryManager.categoryMap.get(cate)) {
    	if(productId == p.getId()) {
    		p.setStockQuantity(updatequantity);
    	}
    }
    
System.out.println(InventoryManager.productList.toString());
    System.out.println("CM:"+InventoryManager.categoryMap);
   System.out.println("sm:"+InventoryManager.stockMap);
} 
	//	System.out.println("There is no product id");
		}
}
    
