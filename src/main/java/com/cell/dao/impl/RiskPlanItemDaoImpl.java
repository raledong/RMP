package com.cell.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.RiskPlanItemDao;
import com.cell.model.RiskPlanItem;

@Repository(value="riskPlanItemDao")
@Transactional
public class RiskPlanItemDaoImpl extends GenericDaoImpl<RiskPlanItem, Integer> implements RiskPlanItemDao{

	public RiskPlanItemDaoImpl() {
		super(RiskPlanItem.class);
	}

	@Override
	public List<RiskPlanItem> getRiskPlanItemByPlanId(int planId) {
		String hql = "from RiskPlanItem riskPlanItem where riskPlanItem.planId = :planId";
		return this.findByNamedParam(hql, "planId", planId);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskPlanItemDao dao = ctx.getBean("riskPlanItemDao", RiskPlanItemDao.class);
		RiskPlanItem item = new RiskPlanItem();
		item.setPlanId(1);
		item.setTypeId(10);
		item.setInfo("test riskPlanItem");
		dao.add(item);
		System.out.println(dao.getRiskPlanItemByPlanId(2).size());
	}

}
