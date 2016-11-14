package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.RiskDao;
import com.cell.dao.RiskStatusDao;
import com.cell.model.Risk;
import com.cell.model.RiskStatus;
import com.cell.service.RiskManagementService;
import com.cell.viewmodel.RiskForm;
import com.cell.viewmodel.RiskStatusForm;

@Service
public class RiskManagementServiceImpl implements RiskManagementService{

	@Autowired
	RiskDao riskDao;

	@Autowired
	RiskStatusDao riskStatusDao;
	
	@Override
	public List<Risk> getAllRisks(int projectId) {
		return riskDao.findByProjectId(projectId);
	}

	@Override
	public Risk getRiskById(int riskId) {
		return riskDao.findById(riskId);
	}

	@Override
	public int createRisk(Risk risk) {
		return riskDao.add(risk);
	}

	@Override
	public int createRisk(RiskForm risk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RiskStatus> getAllRiskStatusByRiskId(int riskId) {
		return riskStatusDao.findByRiskId(riskId);
	}

	@Override
	public int createRiskStatus(RiskStatus riskStatus) {
		return riskStatusDao.add(riskStatus);
	}

	@Override
	public int createRiskStatus(RiskStatusForm riskStatus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRisk(Risk risk) {
		// TODO Auto-generated method stub
		riskDao.update(risk);
	}
}
