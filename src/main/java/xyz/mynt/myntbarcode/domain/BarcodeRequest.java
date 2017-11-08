package xyz.mynt.myntbarcode.domain;

import javax.validation.constraints.NotNull;

public class BarcodeRequest {
	
	@NotNull
	private String clientIdentifier;
	
	@NotNull
	private String gcashAppSessionID;
	
	@NotNull
	private String gcashWalletName;
	
	@NotNull
	private String pin;
	
	@NotNull
	private long timestamp;

	public String getClientIdentifier() {
		return clientIdentifier;
	}

	public void setClientIdentifier(String clientIdentifier) {
		this.clientIdentifier = clientIdentifier;
	}

	public String getGcashAppSessionID() {
		return gcashAppSessionID;
	}

	public void setGcashAppSessionID(String gcashAppSessionID) {
		this.gcashAppSessionID = gcashAppSessionID;
	}

	public String getGcashWalletName() {
		return gcashWalletName;
	}

	public void setGcashWalletName(String gcashWalletName) {
		this.gcashWalletName = gcashWalletName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getFieldValues() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.clientIdentifier);
		sb.append(this.gcashAppSessionID);
		sb.append(this.gcashWalletName);
		sb.append(this.pin);
		sb.append(this.getTimestamp());
		
		return sb.toString();
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
