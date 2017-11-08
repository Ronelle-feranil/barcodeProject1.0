package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Entity for Account Identifier
 * 
 * @author karl.cubilo
 *
 */

@Entity
@Table(name="AccountIdentifier")
public class AccountIdentifier extends BaseUpdatedDate implements Serializable{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -2539073495574635317L;

	@Column(name="account_identifier",unique = true, nullable =false)
	private long accountIdentifier;
	
	@Column(name="client_account_identifier")
	private String clientAccountIdentifier;
	
	@Column(name="gcash_wallet", length = 11)
	private String gcashWallet;
	
	@Column(name="hashed_pin")
	private String hashedPin;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="secondary_barcode_string")
	private String secondaryBarcodeString;
	
	@Column(name="extra_details")
	@Type(type="text")
	private String extraDetails;
	
	public long getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(long accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
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

	public String getSecondaryBarcodeString() {
		return secondaryBarcodeString;
	}

	public void setSecondaryBarcodeString(String secondaryBarcodeString) {
		this.secondaryBarcodeString = secondaryBarcodeString;
	}

}
