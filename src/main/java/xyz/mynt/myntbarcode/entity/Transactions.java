package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Transactions")
public class Transactions extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2224801989478533022L;
	
	@Column(name="merchant_id")
	private int merchantID;
	
	@Column(name="merchant_name")
	private String merchantName;
	
	@Column(name="merchant_gcash_wallet")
	private String merchantGcashWallet;

	@Column(name="subscriber_gcash_wallet" , length = 11)
	private String subscriberGcashWallet;
	
	@Column(name="barcode_string", length = 24)
	private String barcodeString;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="amount" , scale = 3, precision = 14)
	private BigDecimal amount;
	
	@Column(name="description")
	@Type(type="text")
	private String description;
	
	@Column(name="notify_url")
	private String notifyURL;
	
	@Column(name="gcash_transid")
	private String gcashTransID;
	
	@Column(name="merchant_transid")
	private String merchantTransID;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="source_instance")
	private String sourceInstance;

	public int getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(int merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantGcashWallet() {
		return merchantGcashWallet;
	}

	public void setMerchantGcashWallet(String merchantGcashWallet) {
		this.merchantGcashWallet = merchantGcashWallet;
	}

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

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotifyURL() {
		return notifyURL;
	}

	public void setNotifyURL(String notifyURL) {
		this.notifyURL = notifyURL;
	}

	public String getGcashTransID() {
		return gcashTransID;
	}

	public void setGcashTransID(String gcashTransID) {
		this.gcashTransID = gcashTransID;
	}

	public String getMerchantTransID() {
		return merchantTransID;
	}

	public void setMerchantTransID(String merchantTransID) {
		this.merchantTransID = merchantTransID;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSourceInstance() {
		return sourceInstance;
	}

	public void setSourceInstance(String sourceInstance) {
		this.sourceInstance = sourceInstance;
	}
	
	
	
}
