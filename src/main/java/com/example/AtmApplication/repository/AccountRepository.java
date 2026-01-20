package com.example.AtmApplication.repository;

import com.example.AtmApplication.model.Account;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>{
	Optional<Account> findByAccountNumber(String accountNumber);
}
