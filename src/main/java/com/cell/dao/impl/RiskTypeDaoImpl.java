package com.cell.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskTypeDao;
import com.cell.model.RiskType;
import com.cell.viewmodel.RiskAnalyseModel;

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


	@Override
	public List<RiskAnalyseModel> getListOrderByProblem(String startTime, String endTime, int number) {
		String sql = "select riskType.risk_type_id, riskType.risk_type_info, count(riskStatus.risk_status_id) "
				+ "from risk_types riskType, risks risks, risk_status riskStatus "
				+ "where riskType.risk_type_id = risks.risk_type_id  and risks.risk_id = riskStatus.risk_status_risk_id and riskStatus.risk_status_isHappened = 1 "
				+ "and riskStatus.risk_status_created_at <= '" + endTime  +"' and riskStatus.risk_status_created_at >= '" + startTime + "' " 
				+ "group by riskType.risk_type_id "
				+ "order by count(riskStatus.risk_status_id) desc "
				+ "limit " + number;
		List<Object[]> resultList = this.currentSession().createSQLQuery(sql).list();
		if(resultList != null){
			List<RiskAnalyseModel> modelList = new ArrayList<RiskAnalyseModel>();
			for(Object[] object : resultList){
				RiskAnalyseModel model = new RiskAnalyseModel(new RiskType(Integer.parseInt(object[0].toString()), (String)object[1]), Integer.parseInt(object[2].toString()));
				System.out.println(model.getCount() + " " + model.getRiskType().getId());
				modelList.add(model);
			}
			return modelList;
		}
		return null;
	}

	@Override
	public List<RiskAnalyseModel> getListOrderByAcknowledgement(String startTime, String endTime, int number) {
		String sql = "select a.risk_type_id, a.risk_type_info, count(b.risk_type_id) "
				+ "from risk_types a, risks b "
				+ "where a.risk_type_id = b.risk_type_id and b.risk_created_at <= '" + endTime + "' and b.risk_created_at >= '" + startTime + "' "
				+ "group by a.risk_type_id "
				+ "order by count(b.risk_type_id) desc "
				+ "limit " + number;
		List<Object[]> resultList = this.currentSession().createSQLQuery(sql).list();
		if(resultList != null){
			List<RiskAnalyseModel> modelList = new ArrayList<RiskAnalyseModel>();
			for(Object[] object : resultList){
				RiskAnalyseModel model = new RiskAnalyseModel(new RiskType(Integer.parseInt(object[0].toString()), (String)object[1]), Integer.parseInt(object[2].toString()));
				System.out.println(model.getCount() + " " + model.getRiskType().getId());
				modelList.add(model);
			}
			return modelList;
		}
		
		return null;
	}

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskTypeDao riskTypeDao = ctx.getBean("riskTypeDao", RiskTypeDao.class);
//		RiskType riskType = new RiskType();
//		riskType.setInfo("系统崩溃");
//		riskType.setCreatedBy(1);
//		riskTypeDao.add(riskType);
		System.out.println(riskTypeDao.getListOrderByAcknowledgement("2016-11-1", "2016-11-21", 5).size());
	}
}
