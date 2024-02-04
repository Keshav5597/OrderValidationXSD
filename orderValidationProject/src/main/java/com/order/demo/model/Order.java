package com.order.demo.model;

import java.util.List;

public class Order {
    private String cartId;
    private List<LineItem> items;
    private Address billingAddress;
    private Address shippingAddress;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public List<LineItem> getItems() {
		return items;
	}
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

    // getters and setters
    
    
}
