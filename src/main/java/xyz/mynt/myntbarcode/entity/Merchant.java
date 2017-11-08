package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity for Merchant
 * 
 * @author karl.cubilo
 *
 */

@Entity
@Table(name="Merchant")
public class Merchant extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7581820046510518406L;
	
	@Column(name="merchant_id")
	private long merchantID;
	
	@Column(name="prefix")
	private String prefix;
	
	@Column(name="merchant_name")
	private String merchantName;
	
	@Column(name="merchant_gcash_wallet")
	private String merchantGcashWallet;
	
	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;
	
	@Column(name="merchant_category")
	private String merchantCategory;
	
	@Column(name="merchant_industry")
	private String merchantIndustry;

	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number_branch")
	private String mobileNumberBranch;
	
	@Column(name="mobile_number_hq")
	private String mobileNumberHq;
	
	@Column(name="status")
	private boolean status;
	
	@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.PERSIST,mappedBy="merchant")
	private List<MerchantKeys> merchantKeys;
	
	public long getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(long merchantID) {
		this.merchantID = merchantID;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getMerchantCategory() {
		return merchantCategory;
	}

	public void setMerchantCategory(String merchantCategory) {
		this.merchantCategory = merchantCategory;
	}

	public String getMerchantIndustry() {
		return merchantIndustry;
	}

	public void setMerchantIndustry(String merchantIndustry) {
		this.merchantIndustry = merchantIndustry;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumberBranch() {
		return mobileNumberBranch;
	}

	public void setMobileNumberBranch(String mobileNumberBranch) {
		this.mobileNumberBranch = mobileNumberBranch;
	}

	public String getMobileNumberHq() {
		return mobileNumberHq;
	}

	public void setMobileNumberHq(String mobileNumberHq) {
		this.mobileNumberHq = mobileNumberHq;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<MerchantKeys> getMerchantKeys() {
		return merchantKeys;
	}

	public void setMerchantKeys(List<MerchantKeys> merchantKeys) {
		this.merchantKeys = merchantKeys;
	}
	
}
