package com.cell.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskStatusDao;
import com.cell.model.RiskStatus;

@Repository(value="riskStatusDao")
@Transactional
public class RiskStatusDaoImpl extends GenericDaoImpl<RiskStatus, Integer> implements RiskStatusDao{

	public RiskStatusDaoImpl() {
		super(RiskStatus.class);
	}
	
	@Override
	public List<RiskStatus> findByRiskId(int riskId) {
		String hql = "from RiskStatus riskStatus where riskStatus.riskId = :riskId";
		return this.findByNamedParam(hql, "riskId", riskId);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskStatusDao riskStatusDao = ctx.getBean("riskStatusDao", RiskStatusDao.class);
		RiskStatus riskStatus = new RiskStatus();
		riskStatus.setInfo("项目突然闪退");
		riskStatus.setRiskId(1);
		riskStatus.setCreatedBy(1);
		riskStatusDao.add(riskStatus);
		for(RiskStatus temp : riskStatusDao.findByRiskId(1)){
			System.out.println(temp.getRiskId());
		}
	}

	

}
