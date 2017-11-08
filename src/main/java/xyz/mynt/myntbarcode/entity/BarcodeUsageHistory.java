package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	
	@Column(name="secondary_barcode_string")
	private String secondaryBarcodeString;

	@Column(name="account_identifier_id")
	private long accountIdentifierID;
	
	@Column(name="otp_string")
	private long otpString;
	
	@Column(name="status")
	private boolean status;

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

	public String getSecondaryBarcodeString() {
		return secondaryBarcodeString;
	}

	public void setSecondaryBarcodeString(String secondaryBarcodeString) {
		this.secondaryBarcodeString = secondaryBarcodeString;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	
}
