package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import xyz.mynt.myntbarcode.enums.Status;

@Entity
@Table(name="MerchantTransIDValidator")
public class MerchantTransIDValidator extends BaseCreatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6355663485971307832L;
	
	@Column(name="merchant_id")
	private int merchantID;
	
	@OneToOne
	@JoinColumn(name="merchant_transid", referencedColumnName = "merchant_transid",nullable = true)
	private Transactions transactions;
	
	@Column(name="status", columnDefinition = "tinyint")  
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public int getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(int merchantID) {
		this.merchantID = merchantID;
	}

	public Transactions getTransactions() {
		return transactions;
	}

	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
