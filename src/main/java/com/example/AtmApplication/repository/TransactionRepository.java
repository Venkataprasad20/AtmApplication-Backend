package com.example.AtmApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AtmApplication.model.Account;
import com.example.AtmApplication.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	List<Transaction>findByAccountOrderByTimestampDesc(Account account);
}
