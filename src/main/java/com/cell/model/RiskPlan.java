package com.cell.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="risk_plans")
public class RiskPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="risk_plan_id")
	private int id;

	@Column(name="risk_plan_created_by")
	private int createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="risk_created_at")
	private Date createdAt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
