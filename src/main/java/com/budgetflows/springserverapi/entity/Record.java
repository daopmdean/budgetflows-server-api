package com.budgetflows.springserverapi.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="record_id")
	private int id;
	
	@Column(name="money")
	private double money;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="created")
	private Date created;
	
	@ManyToOne(
		cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
		},
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "user_email")
	private User user;
	
	public Record()  {
		
	}

	public Record(double money, String reason, User user) {
		this.money = money;
		this.reason = reason;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
