package xyz.mynt.myntbarcode.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="APILogs")
public class APILogs extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2815474530271471384L;
	
	@Column(name= "source_ip")
	private String sourceIP;
	
	@Column(name= "api_accessed")
	private String apiAccessed;

	@Column(name="request")
	@Type(type="text")
	private String request;
	
	@Column(name="response")
	@Type(type="text")
	private String response;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time_request")
	private Date dateTimeRequest;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time_response")
	private Date dateTimeResponse;

	public String getSourceIP() {
		return sourceIP;
	}

	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	public String getApiAccessed() {
		return apiAccessed;
	}

	public void setApiAccessed(String apiAccessed) {
		this.apiAccessed = apiAccessed;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getDateTimeRequest() {
		return dateTimeRequest;
	}

	public void setDateTimeRequest(Date dateTimeRequest) {
		this.dateTimeRequest = dateTimeRequest;
	}

	public Date getDateTimeResponse() {
		return dateTimeResponse;
	}

	public void setDateTimeResponse(Date dateTimeResponse) {
		this.dateTimeResponse = dateTimeResponse;
	}
	
	
}
