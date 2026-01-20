package com.example.AtmApplication.exception;

public class AccountAlreadyFound extends RuntimeException{
	public AccountAlreadyFound(String message) {
		super(message);
	}
}
