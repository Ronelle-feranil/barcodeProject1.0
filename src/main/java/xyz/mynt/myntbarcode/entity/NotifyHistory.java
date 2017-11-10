package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import xyz.mynt.myntbarcode.enums.Status;

@Entity
@Table(name="NotifyHistory")
public class NotifyHistory extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2579247988645438391L;
	
	@Column(name="trasaction_id")
	private long transactionID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="notify_id" ,referencedColumnName ="id")
	private NotifyQueue notifyQueue;
	
	@Column(name="notifty_url")
	private String notifyURL;
	
	@Column(name="description")
	@Type(type="text")
	private String description;
	
	@Column(name="params")
	@Type(type="text")
	private String params;

	@Column(name="status", columnDefinition = "tinyint")  
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public NotifyQueue getNotifyQueue() {
		return notifyQueue;
	}

	public void setNotifyQueue(NotifyQueue notifyQueue) {
		this.notifyQueue = notifyQueue;
	}

	public String getNotifyURL() {
		return notifyURL;
	}

	public void setNotifyURL(String notifyURL) {
		this.notifyURL = notifyURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
