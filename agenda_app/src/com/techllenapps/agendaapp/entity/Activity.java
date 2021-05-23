package com.techllenapps.agendaapp.entity;

import java.util.Date;

public class Activity {
	private int id;
	private String tittle;
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;

	public Activity(int id, String tittle, String description, Date startDate, Date endDate, String status) {
		this.id = id;
		this.tittle = tittle;
		this.description = description;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Activity(String tittle, String description, Date endDate, Date startDate, String status) {
		this.tittle = tittle;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;

	}

	//used to add the activities in the database
	public Activity(String tittle, String description, Date startDate, Date endDate) {
		this.tittle = tittle;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Activity() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
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
		return "Activity [id=" + id + ", tittle=" + tittle + ", description=" + description + ", status=" + status
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}


}
