package com.cell.dao;

import java.util.List;

import com.cell.model.RiskType;

public interface RiskTypeDao extends GenericDao<RiskType, Integer>{

	public List<RiskType> getAllRiskTypes(int userId);
	public RiskType getRiskTypeByInfo(String info);
	
}
