package com.zadanie.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class ConnectionsCount implements Serializable {

	public ConnectionsCount() {
		super();
	}

	@Id
	@GeneratedValue
	private Long id;
	private String ip;
	private Date creationTime;
	private Integer count;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ConnectionsCount [id=" + id + ", ip=" + ip + ", creationTime="
				+ creationTime + ", count=" + count + "]";
	}

}
