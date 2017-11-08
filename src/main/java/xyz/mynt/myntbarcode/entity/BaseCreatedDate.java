package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Base Created Date Entity 
 * @author karl.cubilo
 *
 */
@MappedSuperclass
public class BaseCreatedDate extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3404032932515946772L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime_created")
	private Date dateTimeCreated;

	@PrePersist
	protected void onCreate() {
		setDateTimeCreated(new Date());
	}

	public Date getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

}
