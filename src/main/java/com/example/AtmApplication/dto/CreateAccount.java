package com.example.AtmApplication.dto;

import java.math.BigDecimal;

public class CreateAccount {

    private String accountNumber;
    private String ownerName;
    private String pin;
    private BigDecimal initialBalance;

    // ✅ REQUIRED: public no-args constructor
    public CreateAccount() {}

    // ✅ Optional: all-args constructor
    public CreateAccount(String accountNumber, String ownerName, String pin, BigDecimal initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.pin = pin;
        this.initialBalance = initialBalance;
    }

    // getters & setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
