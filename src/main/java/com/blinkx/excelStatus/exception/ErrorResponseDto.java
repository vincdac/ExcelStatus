package com.blinkx.excelStatus.exception;

public class ErrorResponseDto {
	
	private String msgKey;
	
	private String message;

	public ErrorResponseDto(String msgKey, String message) {
		this.msgKey = msgKey;
		this.message = message;
	}

}
