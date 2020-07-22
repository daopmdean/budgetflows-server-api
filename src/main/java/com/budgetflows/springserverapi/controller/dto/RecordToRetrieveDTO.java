package com.budgetflows.springserverapi.controller.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "record")
public class RecordToRetrieveDTO {

	@Column(name = "money")
	private double money;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "created")
	private Date created;
	
	public RecordToRetrieveDTO() {
		// TODO Auto-generated constructor stub
	}

	public RecordToRetrieveDTO(double money, String reason, Date created) {
		this.money = money;
		this.reason = reason;
		this.created = created;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
