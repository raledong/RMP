package com.cell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cell.enumType.Level;

@Entity
@Table(name="risk_plan_items")
public class RiskPlanItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="risk_plan_item_id")
	private int id;
	
	@Column(name="risk_plan_item_plan_id")
	private int planId;

	@Column(name="risk_plan_item_type_id")
	private int typeId;
	
	@Column(name="risk_plan_item_info")
	private String info;
	
	@Column(name="risk_plan_item_probability")
	private Level probability;
	
	@Column(name="risk_plan_item_impact")
	private Level impact;
	
	@Column(name="risk_plan_item_trigger")
	private String trigger;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Level getProbability() {
		return probability;
	}

	public void setProbability(Level probability) {
		this.probability = probability;
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
}
