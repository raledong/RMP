package com.cell.viewmodel;

import java.util.List;

import com.cell.model.RiskPlan;
import com.cell.model.RiskPlanItem;

public class PlanModel {
	private RiskPlan riskPlan;
	private List<RiskPlanItem> riskPlanItemList;
	public RiskPlan getRiskPlan() {
		return riskPlan;
	}
	public void setRiskPlan(RiskPlan riskPlan) {
		this.riskPlan = riskPlan;
	}
	public List<RiskPlanItem> getRiskPlanItemList() {
		return riskPlanItemList;
	}
	public void setRiskPlanItemList(List<RiskPlanItem> riskPlanItemList) {
		this.riskPlanItemList = riskPlanItemList;
	}
}
