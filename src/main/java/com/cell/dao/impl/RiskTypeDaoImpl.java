package com.cell.dao.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskTypeDao;
import com.cell.model.RiskType;

@Repository(value="riskTypeDao")
@Transactional
public class RiskTypeDaoImpl extends GenericDaoImpl<RiskType, Integer> implements RiskTypeDao{

	public RiskTypeDaoImpl() {
		super(RiskType.class);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskTypeDao riskTypeDao = ctx.getBean("riskTypeDao", RiskTypeDao.class);
		RiskType riskType = new RiskType();
		riskType.setInfo("系统崩溃");
		riskType.setCreatedBy(1);
		riskTypeDao.add(riskType);
	}

}
