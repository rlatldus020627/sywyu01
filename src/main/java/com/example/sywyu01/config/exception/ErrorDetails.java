package com.example.sywyu01.config.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String details;

}
