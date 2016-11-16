package com.cell.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskPlanDao;
import com.cell.model.RiskPlan;

@Repository(value="riskPlanDao")
@Transactional
public class RiskPlanDaoImpl extends GenericDaoImpl<RiskPlan, Integer> implements RiskPlanDao{

	public RiskPlanDaoImpl() {
		super(RiskPlan.class);
	}

	@Override
	public List<RiskPlan> getRiskPlanByUserId(int userId) {
		String hql = "from RiskPlan riskPlan where riskPlan.createdBy = :createdBy";
		return this.findByNamedParam(hql, "createdBy", userId);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskPlanDao riskPlanDao = ctx.getBean("riskPlanDao", RiskPlanDao.class);
		RiskPlan riskPlan = new RiskPlan();
		riskPlan.setCreatedBy(2);
		riskPlanDao.add(riskPlan);
		System.out.println(riskPlanDao.getRiskPlanByUserId(2).size());
	}

}
