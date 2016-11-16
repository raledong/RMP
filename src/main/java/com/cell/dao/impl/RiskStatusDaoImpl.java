package com.cell.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@Override
	public List<RiskStatus> findRiskStatusOnTime(Date startTime, Date endTime, int userId) {
		String hql = "from RiskStatus riskStatus where riskStatus.createdAt >= :startTime and riskStatus.createdAt <= :endTime and riskStatus.createdBy=:userId";
		String[] paramNames = {"startTime", "endTime", "userId"};
		Object[] values = {startTime, endTime, userId};
		return this.findByNamedParam(hql, paramNames, values);
	}
	
	@Override
	public List<RiskStatus> findHappenedRiskStatusOnTime(Date startTime, Date endTime, int userId) {
		String hql = "from RiskStatus riskStatus where riskStatus.createdAt >= :startTime and riskStatus.createdAt <= :endTime and riskStatus.isHappened = 1";
		String[] paramNames = {"startTime", "endTime"};
		Object[] values = {startTime, endTime};
		return this.findByNamedParam(hql, paramNames, values);
	}

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskStatusDao riskStatusDao = ctx.getBean("riskStatusDao", RiskStatusDao.class);
//		RiskStatus riskStatus = new RiskStatus();
//		riskStatus.setInfo("项目突然闪退");
//		riskStatus.setRiskId(1);
//		riskStatus.setCreatedBy(1);
//		riskStatus.setIsHappened(1);
//		riskStatusDao.add(riskStatus);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date startTime = null;
		try {
			startTime = sdf.parse("2016-11-7");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date endTime = null;
		try {
			endTime = sdf.parse("2016-11-21");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(RiskStatus temp : riskStatusDao.findHappenedRiskStatusOnTime(startTime, endTime, 1)){
			System.out.println(temp.getId());
		}
	}

	

	
	

}
