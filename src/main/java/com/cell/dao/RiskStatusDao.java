package com.cell.dao;

import java.util.List;

import com.cell.model.RiskStatus;

public interface RiskStatusDao extends GenericDao<RiskStatus, Integer>{

	public List<RiskStatus> findByRiskId(int riskId);
}
