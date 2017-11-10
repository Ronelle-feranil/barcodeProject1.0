package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import xyz.mynt.myntbarcode.enums.Status;

@Entity
@Table(name="BarcodeUsageHistory")
public class BarcodeUsageHistory extends BaseCreatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5577351984164329744L;
	
	@Column(name="subscriber_gcash_wallet")
	private String subscriberGcashWallet;
	
	@Column(name="barcode_string")
	private String barcodeString;

	@Column(name="account_identifier_id")
	private long accountIdentifierID;
	
	@Column(name="otp_string")
	private long otpString;
	
	@Column(name="status", columnDefinition = "tinyint")  
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(name="secondary_barcode_string")
	private String secondaryBarcodeString;

	public String getSubscriberGcashWallet() {
		return subscriberGcashWallet;
	}

	public void setSubscriberGcashWallet(String subscriberGcashWallet) {
		this.subscriberGcashWallet = subscriberGcashWallet;
	}

	public String getBarcodeString() {
		return barcodeString;
	}

	public void setBarcodeString(String barcodeString) {
		this.barcodeString = barcodeString;
	}

	public long getAccountIdentifierID() {
		return accountIdentifierID;
	}

	public void setAccountIdentifierID(long accountIdentifierID) {
		this.accountIdentifierID = accountIdentifierID;
	}

	public long getOtpString() {
		return otpString;
	}

	public void setOtpString(long otpString) {
		this.otpString = otpString;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSecondaryBarcodeString() {
		return secondaryBarcodeString;
	}

	public void setSecondaryBarcodeString(String secondaryBarcodeString) {
		this.secondaryBarcodeString = secondaryBarcodeString;
	}

	
}
