package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Otp")
public class OTP extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4744033376535720063L;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_identifier_id",referencedColumnName="account_identifier",nullable = false)
	private AccountIdentifier accountIdentifier;
	
	@Column(name="otp_string")
	private int otpString;
	
	@Column(name="status")
	private boolean status;
	
	public int getOtpString() {
		return otpString;
	}

	public void setOtpString(int otpString) {
		this.otpString = otpString;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public AccountIdentifier getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
	
}
