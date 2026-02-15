package com.samna.beans;

import java.util.List;

public class Order {
private int orderId;
private String customerName;
private List<Product> items;
private double totalAmount;


public Order(int orderId, String customerName, List<Product> items,double totalAmount) {
	super();
	this.orderId = orderId;
	this.customerName = customerName;
	this.items = items;
	this.totalAmount = totalAmount;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public List<Product> getItems() {
	return items;
}
public void setItems(List<Product> items) {
	this.items = items;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
@Override
public String toString() {
	
	return orderId+" "+ "Customer Name: "+customerName+" "+totalAmount+" "+items.toString();
			}


	
}





