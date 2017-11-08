package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Nonce")
public class Nonce extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4747359271802294733L;
	
	@Column(name="merchant_id")
	private long merchantID;
	
	@Column(name="hmac_hash")
	private String hmacHash;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp")
	private Date timestamp;
	
	@Column(name="nonce")
	private String nonce;
}
