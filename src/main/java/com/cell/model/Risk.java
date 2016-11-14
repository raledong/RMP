package com.cell.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cell.convertor.LevelConverter;
import com.cell.enumType.Level;

@Entity
@Table(name="risks")
public class Risk {

	public Risk(){
		//default constructor
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="risk_id")
	private int id;
	
	@Column(name="risk_project_id", nullable=false)
	private int projectId;
	
	@Column(name="risk_info", nullable=false)
	private String info;
	
	
	@Column(name="risk_probability")
	@Convert(converter = LevelConverter.class)
	private Level probability;
	
	@Column(name="risk_impact")
	@Convert(converter = LevelConverter.class)
	private Level impact;
	
	@Column(name="risk_trigger")
	private String trigger;
	
	@Column(name="risk_created_by", nullable=false)
	private int createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="risk_created_at")
	private Date createdAt;
	
	@Column(name="risk_followed_by", nullable=false)
	private int followedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Level getImpact() {
		return impact;
	}
	public void setImpact(Level impact) {
		this.impact = impact;
	}
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
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
	public int getFollowedBy() {
		return followedBy;
	}
	public void setFollowedBy(int followedBy) {
		this.followedBy = followedBy;
	}

	public Level getProbability() {
		return probability;
	}

	public void setProbability(Level probability) {
		this.probability = probability;
	}
}
