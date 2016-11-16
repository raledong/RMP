package com.cell.dao;

import java.util.List;

import com.cell.model.RiskPlan;

public interface RiskPlanDao extends GenericDao<RiskPlan, Integer>{

	public List<RiskPlan> getRiskPlanByUserId(int userId);
}
