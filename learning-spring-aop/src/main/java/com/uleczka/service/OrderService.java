package com.uleczka.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String createOrder(String customer, double amount) {
        System.out.println("Creating order...");
        return "Order for " + customer + " ($" + amount + ")";
    }

    public void cancelOrder(String orderId) {
        System.out.println("Cancelling order " + orderId);
    }
}
