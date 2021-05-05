package com.techllenapps.agendaapp.entity;

import java.util.Date;

public class Activity {
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;
	
	public Activity(String description, String status, Date startDate, Date endDate) {
		super();
		this.description = description;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Activity [description=" + description + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	

}
