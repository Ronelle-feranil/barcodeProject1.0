package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="AuditTrail")
public class AuditTrail extends BaseCreatedDate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2957079623320795511L;

	@Column(name="module")
	private String module;
	
	@Column(name="action")
	private String action;
	
	@Column(name="description")
	@Type(type="text")
	private String description;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
