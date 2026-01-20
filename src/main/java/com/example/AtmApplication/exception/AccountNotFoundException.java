package com.example.AtmApplication.exception;


public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String message) {
		super(message);
	}
}
