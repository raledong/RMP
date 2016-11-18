package com.cell.dao.impl;

import java.util.List;

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
	
	@Override
	public List<RiskType> getAllRiskTypes(int userId) {
		String hql = "from RiskType riskType where createdBy = :userId";
		return this.findByNamedParam(hql, "userId", userId);
	}

	@Override
	public RiskType getRiskTypeByInfo(String info) {
		String hql = "from RiskType riskType where info = :info";
		List<RiskType> resultList = this.findByNamedParam(hql, "info", info);
		return (resultList!=null&&!resultList.isEmpty()) ? resultList.get(0):null;
	}


	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskTypeDao riskTypeDao = ctx.getBean("riskTypeDao", RiskTypeDao.class);
//		RiskType riskType = new RiskType();
//		riskType.setInfo("系统崩溃");
//		riskType.setCreatedBy(1);
//		riskTypeDao.add(riskType);
		System.out.println(riskTypeDao.getRiskTypeByInfo("系统崩溃啦啦啦").getId());
	}

	
}
