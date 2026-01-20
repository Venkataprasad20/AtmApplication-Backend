package com.example.AtmApplication.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="Transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id",nullable=false)
	private Account account;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private BigDecimal amount;
	
	@Column(nullable=false)
	private LocalDateTime timestamp;
	
	public Transaction() {}
	
	public Transaction(Account account,String type,BigDecimal amount,LocalDateTime timestamp){
		this.account=account;
		this.type=type;
		this.amount=amount;
		this.timestamp=timestamp;
	}
	
	//getters AND setters
	
	//Id
	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	//Account
	public void setAccount(Account account) {
		this.account=account;
	}
	public Account getAccount() {
		return account;
	}
	
	//Account type
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}
	
	//Amount
	public void setAmount(BigDecimal amount) {
		this.amount=amount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	
	//DateTime
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp=timestamp;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
