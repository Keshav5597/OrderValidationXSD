package com.order.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.model.Order;

@RestController
public class OrderController {

	@PostMapping(value = "/submitOrder", consumes = "application/xml")
    public String submitOrder(@RequestBody Order order) {
        // Handle order submission and validation
        return "Order submitted successfully!";
    }
}
