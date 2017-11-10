package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import xyz.mynt.myntbarcode.enums.Status;

@Entity
@Table(name="OTPHistory")
public class OTPHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6690459799267140057L;
	
	@Id
	@Column(name="id")
	@Access(AccessType.PROPERTY)
	private long id;
	
	@Column(name="account_identifier_id")
	private long accountIdentifier;
	
	@Column(name="otp_string")
	private int otpString;
	
	@Column(name="status", columnDefinition = "tinyint")  
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_created")
	private Date dateTimeCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_modified")
	private Date dateTimeModified;

	public long getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(long accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public int getOtpString() {
		return otpString;
	}

	public void setOtpString(int otpString) {
		this.otpString = otpString;
	}

	public Date getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	public Date getDateTimeModified() {
		return dateTimeModified;
	}

	public void setDateTimeModified(Date dateTimeModified) {
		this.dateTimeModified = dateTimeModified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
