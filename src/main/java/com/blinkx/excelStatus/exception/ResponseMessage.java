package com.blinkx.excelStatus.exception;

public class ResponseMessage {
	
	private String msgKey;
	
	private String msg;

	public ResponseMessage() {
		
	}

	public ResponseMessage(String msgKey, String msg) {
		this.msgKey = msgKey;
		this.msg = msg;
	}
	
	

}
