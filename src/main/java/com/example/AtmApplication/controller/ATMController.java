package com.example.AtmApplication.controller;

import com.example.AtmApplication.dto.AmountRequest;
import com.example.AtmApplication.dto.CreateAccount;
import com.example.AtmApplication.dto.PinRequest;
import com.example.AtmApplication.dto.TransactionRequest;
import com.example.AtmApplication.dto.TransferRequest;
import com.example.AtmApplication.model.Account;
import com.example.AtmApplication.model.Transaction;
import com.example.AtmApplication.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/atm")
public class ATMController {

    @Autowired
    private ATMService atmService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody CreateAccount request) {
        Account account = atmService.createAccount(request); // ✅ pass the DTO
        return ResponseEntity.ok(account);
    }

    @PostMapping("/accounts/{account}/balance")
    public ResponseEntity<BigDecimal> balance(
            @PathVariable String account,
            @RequestBody PinRequest request
    ) {
        BigDecimal balance = atmService.getBalance(account, request.getPin());
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/accounts/{account}/deposit")
    public ResponseEntity<?> deposit(
            @PathVariable String account,
            @RequestBody AmountRequest request
    ) {
        return ResponseEntity.ok(
            atmService.deposit(account, request.getPin(), request.getAmount())
        );
    }

    @PostMapping("/accounts/{account}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable String account,
    		 @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(atmService.withDrawl(account, request.getPin(), request.getAmount()));
    }

    @PostMapping("/accounts/{from}/transfer/{to}")
    public ResponseEntity<?> transfer(
            @PathVariable String from,
            @PathVariable String to,
            @RequestBody TransferRequest request
    ) {
        return ResponseEntity.ok(
            atmService.transfer(from, request.getPin(), to, request.getAmount())
        );
    }

    @PostMapping("/accounts/{account}/transactions")
    public ResponseEntity<List<Transaction>> transactions(
            @PathVariable String account,
            @RequestBody PinRequest request
    ) {
        return ResponseEntity.ok(
            atmService.getTransactions(account, request.getPin())
        );
    }

}