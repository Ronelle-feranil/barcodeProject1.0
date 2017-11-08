package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Base Updated Date Entity
 * 
 * @author karl.cubilo
 *
 */

@MappedSuperclass
public class BaseUpdatedDate extends BaseCreatedDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8034829083330663401L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_modified")
	private Date dateTimeModified;
	
	@PrePersist
	private void create() {
		dateTimeModified = getDateTimeCreated();
	}
	
	@PreUpdate
	protected void onUpdate() {
		dateTimeModified = new Date();
	}
	
	public Date getDateTimeModified() {
		return dateTimeModified;
	}

	public void setDateTimeModified(Date dateTimeModified) {
		this.dateTimeModified = dateTimeModified;
	}

}
