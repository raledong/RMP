package com.cell.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskDao;
import com.cell.enumType.Level;
import com.cell.model.Risk;

@Repository(value="riskDao")
@Transactional
public class RiskDaoImpl extends GenericDaoImpl<Risk, Integer> implements RiskDao{

	public RiskDaoImpl() {
		super(Risk.class);
	}
	

	@Override
	public List<Risk> findByProjectId(int projectId) {
		String hql = "from Risk risk where risk.projectId = :projectId";
		return this.findByNamedParam(hql, "projectId", projectId);
	}
	
	@Override
	public List<Risk> findByTime(Date startAt, Date endAt, int userId) {
		String hql = "from Risk risk where risk.createdAt >= :startAt and risk.createdAt <= :endAt and risk.createdBy = :userId";
		String[] namedParams = {"startAt", "endAt", "userId"};
		Object[] values = {startAt, endAt, userId};
		return this.findByNamedParam(hql, namedParams, values);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskDao riskDao = ctx.getBean("riskDao",RiskDao.class);
		Risk risk = new Risk();
		risk.setInfo("test risk database");
		risk.setFollowedBy(1);
		risk.setProbability(Level.HIGH);
		risk.setImpact(Level.MEDIUM);
		risk.setProjectId(10);
		risk.setRiskTypeId(0);
		risk.setTrigger("fail to add");
		riskDao.add(risk);
//		userDao.delete(10000000);
//		for(Risk temp : riskDao.findByProjectId(9)){
//			System.out.println(temp.getProbability());
//
//		}
	}


	


}
