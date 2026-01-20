package com.example.AtmApplication.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AtmApplication.dto.CreateAccount;
import com.example.AtmApplication.exception.AccountAlreadyFound;
import com.example.AtmApplication.exception.AccountNotFoundException;
import com.example.AtmApplication.exception.InsufficientBalanceException;
import com.example.AtmApplication.model.Account;
import com.example.AtmApplication.model.Transaction;
import com.example.AtmApplication.repository.AccountRepository;
import com.example.AtmApplication.repository.TransactionRepository;


import jakarta.transaction.Transactional;

@Service
public class ATMServiceImpl implements ATMService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	private Account getAccount(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new 
				AccountNotFoundException("Account not found: "+accountNumber));
	}
	
	public void verifyPin(Account account,String pin) {
		if(!account.getPin().equals(pin)) {
			throw new AccountNotFoundException("Invalid pin");
		}
	}
	
	public void accountExist(String accountNumber) {
		if(accountRepository.findByAccountNumber(accountNumber).isPresent()) {
			throw new AccountAlreadyFound("Account already Exist! "+accountNumber);
		}
	}
	
	@Override
	public Account createAccount(CreateAccount account) {
		Account acc=new Account(
				account.getAccountNumber(),
				account.getOwnerName(),
				account.getPin(),
				account.getInitialBalance());
		return accountRepository.save(acc);
	}
	
	@Override
	public BigDecimal getBalance(String accountNumber,String pin) {
		Account acc=getAccount(accountNumber);
		verifyPin(acc,pin);
		return acc.getBalance();
	}
	
	@Override 
	@Transactional
	public Transaction deposit(String accountNumber,String pin,BigDecimal amount) {
		Account acc=getAccount(accountNumber);
		verifyPin(acc,pin);
		acc.deposit(amount);
		accountRepository.save(acc);
		return transactionRepository.save(new Transaction(acc,"Deposit",amount,LocalDateTime.now()));
	}
	
	@Override
	@Transactional
	public Transaction withDrawl(String accountNumber,String pin,BigDecimal amount) {
		Account acc=getAccount(accountNumber);
		verifyPin(acc,pin);
		
		if(acc.getBalance().compareTo(amount)<0) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		
		acc.withDrawl(amount);
		accountRepository.save(acc);
		
		return transactionRepository.save(new Transaction(acc,"WithDrawl",amount,LocalDateTime.now()));
	}
	
	
	@Override
    @Transactional
    public Transaction transfer(String fromAccNo, String pin, String toAccNo, BigDecimal amount) {
        Account from = getAccount(fromAccNo);
        verifyPin(from, pin);
        Account to = getAccount(toAccNo);

        if (from.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Not enough balance");
        }

        from.withDrawl(amount);
        to.deposit(amount);
        accountRepository.save(from);
        accountRepository.save(to);
        
        
        Transaction senderTx = new Transaction(
                from, 
                "TRANSFER", 
                amount, 
                LocalDateTime.now()
        );
        transactionRepository.save(senderTx);

        Transaction receiverTx = new Transaction(
                to, 
                "TRANSFER_IN", 
                amount, 
                LocalDateTime.now()
        );
        transactionRepository.save(receiverTx);
        
        return senderTx;

    }

    @Override
    public List<Transaction> getTransactions(String accountNumber, String pin) {
        Account acc = getAccount(accountNumber);
        verifyPin(acc, pin);
        return transactionRepository.findByAccountOrderByTimestampDesc(acc);
    }
}



