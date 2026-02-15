package com.samna.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.samna.beans.Order;
import com.samna.beans.Product;

public class InventoryManager {

	public static List<Product> productList = new ArrayList<>();
	   public static Map<String, List<Product>> categoryMap = new HashMap<>();
	   	   
	   // category , product of category
	  public static  Map<Integer, Integer> stockMap = new HashMap<>(); // product id and quantity
	  
	  
	  public static    Queue<Order> orderQueue = new LinkedList<>();
	  public static   Set<String> productNames = new HashSet<>();

}
