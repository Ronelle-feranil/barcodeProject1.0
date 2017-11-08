package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MerchantKeys")
public class MerchantKeys extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1148973920810638592L;
	
	@Column(name="merchant_key")
	private String merchantKey;
	
	@Column(name="token")
	private String token;

	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merchant_id",referencedColumnName="id",nullable = false)
	private Merchant merchant;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}
	
	
}
