package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.RiskPlanDao;
import com.cell.dao.RiskPlanItemDao;
import com.cell.model.RiskPlan;
import com.cell.model.RiskPlanItem;
import com.cell.service.RiskPlanManagementService;

@Service
public class RiskPlanManagementServiceImpl implements RiskPlanManagementService{

	@Autowired
	private RiskPlanDao riskPlanDao;
	
	@Autowired
	private RiskPlanItemDao riskPlanItemDao;
	
	@Override
	public int createRiskPlan(RiskPlan riskPlan) {
		return riskPlanDao.add(riskPlan);
	}

	@Override
	public RiskPlan getRiskPlanById(int riskPlanId) {
		return riskPlanDao.findById(riskPlanId);
	}

	@Override
	public List<RiskPlan> getAllRiskPlans(int userId) {
		return riskPlanDao.getRiskPlanByUserId(userId);
	}

	@Override
	public int createRiskPlanItem(RiskPlanItem riskPlanItem) {
		return riskPlanItemDao.add(riskPlanItem);
	}

	@Override
	public void updateRiskPlanItem(RiskPlanItem riskPlanItem) {
		riskPlanItemDao.update(riskPlanItem);
	}

	@Override
	public void deleteRiskPlanItem(int riskPlanItemId) {
		riskPlanItemDao.delete(riskPlanItemId);
	}

	@Override
	public List<RiskPlanItem> getAllRiskPlanItems(int planId) {
		return riskPlanItemDao.getRiskPlanItemByPlanId(planId);
	}

}
