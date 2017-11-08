package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base Entity
 * 
 * @author karl.cubilo
 *
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 6253553358756346763L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Access(AccessType.PROPERTY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
			this.id = id;
	}

}
