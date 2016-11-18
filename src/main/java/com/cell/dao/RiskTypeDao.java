package com.cell.dao;

import java.util.Date;
import java.util.List;

import com.cell.model.RiskType;
import com.cell.viewmodel.RiskAnalyseModel;

public interface RiskTypeDao extends GenericDao<RiskType, Integer>{

	public List<RiskType> getAllRiskTypes(int userId);
	public RiskType getRiskTypeByInfo(String info);
	
	public List<RiskAnalyseModel> getListOrderByProblem(String startTime, String endTime, int number);
	
	public List<RiskAnalyseModel> getListOrderByAcknowledgement(String startTime, String endTime, int number);
}
