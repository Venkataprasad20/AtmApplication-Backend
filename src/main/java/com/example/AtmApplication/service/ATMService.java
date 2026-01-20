package com.example.AtmApplication.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.AtmApplication.dto.CreateAccount;
import com.example.AtmApplication.model.Account;
import com.example.AtmApplication.model.Transaction;

public interface ATMService {
	Account createAccount(CreateAccount account);
	BigDecimal getBalance(String accountNumber,String pin);
	Transaction deposit(String accountNumber,String pin,BigDecimal amount);
	Transaction withDrawl(String accountNumber,String pin,BigDecimal amount);
	Transaction transfer(String fromAccountNum, String pin, String toAccountNum, BigDecimal amount);
	List<Transaction> getTransactions(String accountNumber,String pin);
}
