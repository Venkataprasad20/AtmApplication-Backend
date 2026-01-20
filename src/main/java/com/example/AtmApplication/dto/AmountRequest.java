package com.example.AtmApplication.dto;

import java.math.BigDecimal;

public class AmountRequest {
    private String pin;
    private BigDecimal amount;
    
    AmountRequest(String pin,BigDecimal amount){
    	this.pin=pin;
    	this.amount=amount;
    }

    // getters & setters
    public void setPin(String pin) {
    	this.pin=pin;
    }
    
    public String getPin() {
    	return pin;
    }
    
    public void setAmount( BigDecimal amount) {
    	this.amount=amount;
    }
    
    public BigDecimal getAmount() {
    	return amount;
    }
}
