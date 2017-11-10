package xyz.mynt.myntbarcode.domain;

public class SevenElevenResponse {
	
	private String type;
	
	private String merchanteRef;
	
	private double amount;
	
	private String authCode;
	
	private String responseCode;
	
	private String responseDesc;
	
	private String remarks;
	
	private String token;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMerchanteRef() {
		return merchanteRef;
	}

	public void setMerchanteRef(String merchanteRef) {
		this.merchanteRef = merchanteRef;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
