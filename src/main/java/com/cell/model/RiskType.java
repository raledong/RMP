package com.cell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_types")
public class RiskType {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="risk_type_id")
	private int id;

	@Column(name="risk_type_info", nullable=false)
	private String info;
	
	@Column(name="risk_type_created_by")
	private int createdBy;

	public RiskType(){
		
	}
	
	public RiskType(int id, String info){
		this.id = id;
		this.info = info;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

}
