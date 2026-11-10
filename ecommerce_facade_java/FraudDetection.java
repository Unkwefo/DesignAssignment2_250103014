package com.ecommerce;

public class FraudDetection {

    private static final double MAX_ALLOWED_AMOUNT = 10000.0;

    /**
     @param customerId
     @param amount
     @return
    */

    public boolean validateOrder(String customerId, double amount) {
        System.out.println("[FraudDetectionService] Step 1: Checking fraud score for customer: " + customerId);

        if (customerId == null || customerId.trim().isEmpty() || customerId.startsWith("blocked_")) {
            System.out.println("[FraudDetectionService] Alert: Customer is blacklisted or invalid.");
            return false;
        }

        if (amount <= 0 || amount > MAX_ALLOWED_AMOUNT) {
            System.out.println("[FraudDetectionService] Alert: Suspicious transaction amount: $" + amount);
            return false;
        }

        System.out.println("[FraudDetectionService] Step 2: Fraud verification passed for customer: " + customerId);
        return true;
    }
}