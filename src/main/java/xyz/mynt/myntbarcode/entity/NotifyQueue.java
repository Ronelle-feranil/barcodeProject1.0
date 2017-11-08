package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="NotifyQueue")
public class NotifyQueue extends BaseUpdatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8458111156105265233L;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_id", referencedColumnName="id" , nullable = false)
	private Transactions transactions;
	
	@Column(name="notify_url")
	private String notifyURL;
	
	@Column(name="description")
	@Type(type="text")
	private String description;

}
