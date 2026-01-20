package com.example.AtmApplication.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	
	@Column(nullable=false, unique=true)
	private String accountNumber;
	
	@Column(nullable=false)
	private String ownerName;
	
	@Column(nullable=false)
	private String pin;
	
	@Column(nullable=false)
	private BigDecimal balance=BigDecimal.ZERO;
	
	public Account() {}
	
	public Account(String accountNumber, String ownerName, String pin, BigDecimal balance) {
		this.accountNumber=accountNumber;
		this.ownerName=ownerName;
		this.pin=pin;
		this.balance=balance;
	}
	
	//ID
	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	//Account Number
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	// Owner Name
	public void setOwnerName(String ownerName) {
		this.ownerName=ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	
	// pin
	public void setPin(String pin) {
		this.pin=pin;
	}
	public String getPin() {
		return pin;
	}
	
	// balance
	public void setBalance(BigDecimal balance) {
		this.balance=balance;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	
	//deposit
	public void deposit(BigDecimal amount){
		this.balance=this.balance.add(amount);
	}
	
	//withDrawal
	public void withDrawl(BigDecimal amount) {
		this.balance=this.balance.subtract(amount);
	}
}
