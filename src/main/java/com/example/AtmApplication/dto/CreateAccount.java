package com.example.AtmApplication.dto;

import java.math.BigDecimal;

public class CreateAccount {
	private String accountNumber;
	private String ownerName;
	private String pin;
	private BigDecimal initialBalance;
	 
	 CreateAccount(String accountNumber,String ownerName,String pin,BigDecimal initialBalance){
		 this.accountNumber=accountNumber;
		 this.ownerName=ownerName;
		 this.pin=pin;
		 this.initialBalance=initialBalance;
	 }
	 
	 //setters
	 public void setAccountNumber(String accountNumber) {
		 this.accountNumber=accountNumber;
	 }
	 
	 public void setOwnerName(String ownerName) {
		 this.ownerName=ownerName;
	 }
	 
	 public void setPin(String pin) {
		 this.pin=pin;
	 }
	 
	 public void setInitialBalance(BigDecimal initialBalance) {
		 this.initialBalance=initialBalance;
	 }
	 
	 //getters
	 public String getAccountNumber() {
		 return accountNumber;
	 }
	 
	 public String getOwnerName() {
		 return ownerName;
	 }
	 
	 public String getPin() {
		 return pin;
	 }
	 
	 public BigDecimal getInitialBalance() {
		 return initialBalance;
	 }
}
