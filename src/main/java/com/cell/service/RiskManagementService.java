package com.cell.service;

import java.util.List;

import com.cell.model.Risk;
import com.cell.model.RiskStatus;
import com.cell.viewmodel.RiskForm;
import com.cell.viewmodel.RiskStatusForm;

public interface RiskManagementService {

	//获得所有风险条目
	public List<Risk> getAllRisks(int projectId);
	
	//通过风险的id获得风险条目
	public Risk getRiskById(int riskId);
	
	//创建一个新的风险条目
	public int createRisk(Risk risk);
	public int createRisk(RiskForm risk);
	
	
	//获得风险的所有状态
	public List<RiskStatus> getAllRiskStatusByRiskId(int riskId);

	//添加风险状态
	public int createRiskStatus(RiskStatus riskStatus);
	public int createRiskStatus(RiskStatusForm riskStatus);

	//修改一个风险项的部分条目
	public void updateRisk(Risk risk);
}
