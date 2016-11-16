package com.cell.service;

import java.util.List;

import com.cell.model.RiskPlan;
import com.cell.model.RiskPlanItem;

public interface RiskPlanManagementService {

	//添加风险管理计划
	public int createRiskPlan(RiskPlan riskPlan);
	
	//通过风险管理计划的id获得管理计划
	public RiskPlan getRiskPlanById(int riskPlanId);
	
	//获得个人所有的风险管理计划 
	public List<RiskPlan> getAllRiskPlans(int userId);
	
	//添加单个风险计划条目
	public int createRiskPlanItem(RiskPlanItem riskPlanItem);

	//更新风险计划条目
	public void updateRiskPlanItem(RiskPlanItem riskPlanItem);
	
	//删除风险计划条目
	public void deleteRiskPlanItem(int riskPlanItemId);
	
	//获得单个风险计划的所有条目
	public List<RiskPlanItem> getAllRiskPlanItems(int planId);
}
