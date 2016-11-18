package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.RiskTypeDao;
import com.cell.model.RiskType;
import com.cell.service.RiskTypeManagementService;

@Service
public class RiskTypeManagementServiceImpl implements RiskTypeManagementService{
     
	@Autowired
	private RiskTypeDao riskTypeDao;

	@Override
	public int createRiskType(RiskType riskType) {
		return riskTypeDao.add(riskType);
	}

	@Override
	public List<RiskType> getAllRiskTypes(int userId) {
		return riskTypeDao.getAllRiskTypes(userId);
	}

	@Override
	public void deleteRiskType(int riskTypeId) {
		riskTypeDao.delete(riskTypeId);
	}

	@Override
	public void updateRiskType(RiskType riskType) {
		riskTypeDao.update(riskType);
	}
	
	
}
