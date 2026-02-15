package com.samna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.samna.beans.Order;
import com.samna.beans.Product;
import com.samna.util.InventoryValidation;

public class OrderOperations {

    public static void placeOrder(Order order) throws Exception {
        for (Product p : order.getItems()) {
            System.out.print("Enter quantity to order for product " + p.getName() + ": ");
            int userQuantity = InventoryValidation.sc.nextInt();

            int id = p.getId();

            if (!InventoryManager.stockMap.containsKey(id)) {
                throw new Exception("Product ID " + id + " not found in stock.");
            }

            int currentStock = InventoryManager.stockMap.get(id);
            if (userQuantity > currentStock) {
                throw new Exception("Insufficient stock for product: " + p.getName());
            }

            InventoryManager.stockMap.put(id, currentStock - userQuantity);
            updateProductList(p, currentStock - userQuantity);

            System.out.println("Order placed for product: " + p.getName() + ", Quantity: " + userQuantity);
        }

        InventoryManager.orderQueue.add(order);

        System.out.println("Order placed successfully!");
        System.out.println("Updated Product List: " + InventoryManager.productList);
        System.out.println("Updated Stock Map: " + InventoryManager.stockMap);
        System.out.println("Order Queue: " + InventoryManager.orderQueue);
    }

    public static void updateProductList(Product p, int updatedQuantity) {
        for (Product s : InventoryManager.productList) {
            if (s.getId() == p.getId()) {
                s.setStockQuantity(updatedQuantity);
                return;
            }
        }
    }

    public static Order inputOrder() throws Exception {
        List<Product> items = new ArrayList<>();
        items.add(new Product(103, "Black Pen", "Stationery", 5.0, 20));

        Order order = new Order(102, "Santhosh", items, 100);
        placeOrder(order);

        return order;
    }

    public static void processOrder() throws Exception {
        if (InventoryManager.orderQueue.isEmpty()) {
            throw new Exception("No orders in queue.");
        }

        Order order = InventoryManager.orderQueue.poll();
        System.out.println("Generating bill...");
        generateBill(order);
    }

    public static void viewPendingOrders() throws Exception {
        if (InventoryManager.orderQueue.isEmpty()) {
            throw new Exception("No orders are pending.");
        }

        for (Order o : InventoryManager.orderQueue) {
            generateBill(o);
        }
    }

    public static void generateBill(Order order) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s%20s%20s%20s%20s%20s%20s\n", "Order ID", "Customer Name", "Product ID", "Product Name", "Product Category", "Price", "Stock Quantity");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Product p : order.getItems()) {
            System.out.printf("%20d%20s%20d%20s%20s%20.2f%20d\n",
                    order.getOrderId(),
                    order.getCustomerName(),
                    p.getId(),
                    p.getName(),
                    p.getCategory(),
                    p.getPrice(),
                    p.getStockQuantity());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("Total Amount: %10.2f\n", order.getTotalAmount());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}