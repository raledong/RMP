package com.cell.dao;

import java.util.List;

import com.cell.model.RiskPlanItem;

public interface RiskPlanItemDao extends GenericDao<RiskPlanItem, Integer>{

	public List<RiskPlanItem> getRiskPlanItemByPlanId(int planId);
}
