package com.blinkx.excelStatus.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;



@Entity
@Table(name="m_dump_data")
public class ExcelStatusEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String email;
	
	@Column(name="mandate_id")
	private String mandateId;
	
	@Column(name="bank_name")
	private String bankName;
	
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="bank_id")
	private String bankId;
	
//	@Column(name="amount")
//	private String amount;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="umrn")
	private String umrn;
	
	@Column(name="type")
	private String type;

//	@Column(name="registration_date")
//	private Date registration_date;
//	
//	@Column(name="approved_date")
//	private Date approved_date;
	
	@Column(name="registration_date")
	private String registration_date;
	
//	@Column(name="approved_date")
	private String approved_date;
//	
	@Column(name="status")
	private String status;
	
	@Column(name="status_reason")
	private String statusReason;
//	
	@Column(name="sub_status")
	private String subStatus;
	
//	@Column(name="users")
//	private String user;
	
//	 @Version
//	 private int version; 

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

	public String getUmrn() {
		return umrn;
	}

	public void setUmrn(String umrn) {
		this.umrn = umrn;
	}

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

	public String getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(String approved_date) {
		this.approved_date = approved_date;
	}
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

//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}

	

	public ExcelStatusEntity() {
		
	}

public ExcelStatusEntity(long id, String email, String mandateId, String bankName, String accountNumber, String bankId,
		double amount, String type, String registration_date, String status, String statusReason, String subStatus) {
	super();
	this.id = id;
	this.email = email;
	this.mandateId = mandateId;
	this.bankName = bankName;
	this.accountNumber = accountNumber;
	this.bankId = bankId;
	this.amount = amount;
	this.type = type;
	this.registration_date = registration_date;
	this.status = status;
	this.statusReason = statusReason;
	this.subStatus = subStatus;
}

public ExcelStatusEntity(long id, String email, String mandateId, String bankName, String accountNumber, String bankId,
		double amount, String umrn, String type, String registration_date, String approved_date, String status,
		String statusReason, String subStatus) {
	super();
	this.id = id;
	this.email = email;
	this.mandateId = mandateId;
	this.bankName = bankName;
	this.accountNumber = accountNumber;
	this.bankId = bankId;
	this.amount = amount;
	this.umrn = umrn;
	this.type = type;
	this.registration_date = registration_date;
	this.approved_date = approved_date;
	this.status = status;
	this.statusReason = statusReason;
	this.subStatus = subStatus;
}


	



}
