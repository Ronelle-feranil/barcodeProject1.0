package xyz.mynt.myntbarcode.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaymentReferenceCreationRequest {
	
	@NotNull
    @Size(min=1, max=15)
	private String errorCode;
	
	@NotNull
    @Size(min=1, max=20)
	private String payID;
	
	
	@NotNull
    @Size(min=1, max=15)
	private String merchantID;
	
	@NotNull
    @Size(min=1, max=40)
	private String merchantRef;
	
	@NotNull
	private int amount;
	
	private long expDate;
	
	@NotNull
    @Size(min=1)
	private String token;
	
	private String message;
	
	@NotNull
    @Size(min=1)
	private String barcodeString;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getPayID() {
		return payID;
	}

	public void setPayID(String payID) {
		this.payID = payID;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerchantRef() {
		return merchantRef;
	}

	public void setMerchantRef(String merchantRef) {
		this.merchantRef = merchantRef;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getExpDate() {
		return expDate;
	}

	public void setExpDate(long expDate) {
		this.expDate = expDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBarcodeString() {
		return barcodeString;
	}

	public void setBarcodeString(String barcodeString) {
		this.barcodeString = barcodeString;
	}
	
}
