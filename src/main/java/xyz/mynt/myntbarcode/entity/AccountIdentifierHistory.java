package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="AccountIdentifierHistory")
public class AccountIdentifierHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -782759808198178326L;
	
	@Id
	@Column(name="id")
	@Access(AccessType.PROPERTY)
	private long id;
	
	@Column(name="account_identifier", nullable =false)
	private long accountIdentifierId;
	
	@Column(name="client_account_identifier")
	private String clientAccountIdentifier;
	
	@Column(name="gcash_wallet", length = 11)
	private String gcashWallet;
	
	@Column(name="hashed_pin")
	private String hashedPin;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="extra_details")
	@Type(type="text")
	private String extraDetails;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_created")
	private Date dateTimeCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_modified")
	private Date dateTimeModified;


	public long getAccountIdentifierId() {
		return accountIdentifierId;
	}

	public void setAccountIdentifierId(long accountIdentifierId) {
		this.accountIdentifierId = accountIdentifierId;
	}

	public String getClientAccountIdentifier() {
		return clientAccountIdentifier;
	}

	public void setClientAccountIdentifier(String clientAccountIdentifier) {
		this.clientAccountIdentifier = clientAccountIdentifier;
	}

	public String getGcashWallet() {
		return gcashWallet;
	}

	public void setGcashWallet(String gcashWallet) {
		this.gcashWallet = gcashWallet;
	}

	public String getHashedPin() {
		return hashedPin;
	}

	public void setHashedPin(String hashedPin) {
		this.hashedPin = hashedPin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getExtraDetails() {
		return extraDetails;
	}

	public void setExtraDetails(String extraDetails) {
		this.extraDetails = extraDetails;
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

	
	
}
