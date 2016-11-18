package com.cell.service;

import java.util.List;

import com.cell.model.RiskType;

public interface RiskTypeManagementService {

	public int createRiskType(RiskType riskType);
	
	public List<RiskType> getAllRiskTypes(int userId);
	
	public void deleteRiskType(int riskTypeId);
	
	public void updateRiskType(RiskType riskType);
}
