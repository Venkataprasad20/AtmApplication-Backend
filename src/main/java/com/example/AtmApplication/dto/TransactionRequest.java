
package com.example.AtmApplication.dto;

import java.math.BigDecimal;

public class TransactionRequest {
    private String pin;
    private BigDecimal amount;
    
    public TransactionRequest() {
    }

    // Getters & Setters
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
