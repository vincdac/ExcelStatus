package com.blinkx.excelStatus.exception;

public class SuccessReponseDto {
	
	private String msgKey;
	
	private String message;
	
	private Object object;

	public SuccessReponseDto(String msgKey, String message) {
		this.msgKey = msgKey;
		this.message = message;
	}

	public SuccessReponseDto(String msgKey, String message, Object object) {
		super();
		this.msgKey = msgKey;
		this.message = message;
		this.object = object;
	}
	
	

}
