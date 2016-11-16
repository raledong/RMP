package com.cell.dao;

import java.util.Date;
import java.util.List;

import com.cell.model.RiskStatus;

public interface RiskStatusDao extends GenericDao<RiskStatus, Integer>{

	public List<RiskStatus> findByRiskId(int riskId);
	
	public List<RiskStatus> findRiskStatusOnTime(Date startTime, Date endTime, int userId);
	
	public List<RiskStatus> findHappenedRiskStatusOnTime(Date startTime, Date endTime, int userId);
}
