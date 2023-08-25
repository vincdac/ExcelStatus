package com.blinkx.excelStatus.dto;

import java.util.Date;

import jakarta.persistence.Column;

public class ExcelStatusDto {
	
	private long id;
	
	private String email;
	
	private String mandateId;
	
	private String bankName;
	
	private String accountNumber;
	
	private String bankId;
	
//	private String amount;
	
	private double amount;
	
//	private String umrn;
	
	private String type;

//	private Date registration_date;
//	
//	private Date approved_date;
	
	private String registration_date;
	
//	private String approved_date;
//	
	private String status;
	
	private String statusReason;
	
	private String subStatus;
	
//	@Column(name="users")
//	private String user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMandateId() {
		return mandateId;
	}

	public void setMandateId(String mandateId) {
		this.mandateId = mandateId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

//	public String getAmount() {
//		return amount;
//	}
//
//	public void setAmount(String amount) {
//		this.amount = amount;
//	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

//	public String getUmrn() {
//		return umrn;
//	}
//
//	public void setUmrn(String umrn) {
//		this.umrn = umrn;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Date getRegistration_date() {
//		return registration_date;
//	}
//
//	public void setRegistration_date(Date registration_date) {
//		this.registration_date = registration_date;
//	}
//
//	public Date getApproved_date() {
//		return approved_date;
//	}
//
//	public void setApproved_date(Date approved_date) {
//		this.approved_date = approved_date;
//	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

//	public String getApproved_date() {
//		return approved_date;
//	}
//
//	public void setApproved_date(String approved_date) {
//		this.approved_date = approved_date;
//	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String status_reason) {
		this.statusReason = status_reason;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String sub_status) {
		this.subStatus = sub_status;
	}
	
}
