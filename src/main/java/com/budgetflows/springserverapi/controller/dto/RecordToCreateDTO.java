package com.budgetflows.springserverapi.controller.dto;

public class RecordToCreateDTO {
	private double money;
	private String reason;
	private String user_email;

	public RecordToCreateDTO(double money, String reason, String user_email) {
		this.money = money;
		this.reason = reason;
		this.user_email = user_email;
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

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

}
