package com.example.sywyu01.config.exception;

public class AlreadyExistedUserException extends RuntimeException{
	public AlreadyExistedUserException(String message) {
		super(message);
	}

}
