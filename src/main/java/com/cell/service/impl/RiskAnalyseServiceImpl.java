package com.cell.service.impl;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cell.dao.RiskDao;
import com.cell.dao.RiskStatusDao;
import com.cell.dao.RiskTypeDao;
import com.cell.model.Risk;
import com.cell.model.RiskStatus;
import com.cell.service.RiskAnalyseService;
import com.cell.viewmodel.RiskAnalyseModel;

@Service
public class RiskAnalyseServiceImpl implements RiskAnalyseService{

	@Autowired
	private RiskStatusDao riskStatusDao;
	
	@Autowired
	private RiskDao riskDao;
	
	@Autowired
	private RiskTypeDao riskTypeDao;
	
	@Override
	public RiskAnalyseModel getMostAcknowledgedRisk(Date startTime, Date endTime, int userId) {
		List<Risk> riskList = riskDao.findByTime(startTime, endTime, userId);
		
		if(riskList != null && !riskList.isEmpty()){
			
			List<RiskAnalyseModel> modelList = new ArrayList<RiskAnalyseModel>();
			for(Risk tempRisk : riskList){
				
				boolean isExisted = false;
				for(RiskAnalyseModel tempModel : modelList){
					if(tempModel.getRiskType().getId() == tempRisk.getRiskTypeId()){
						isExisted = true;
						tempModel.setCount(tempModel.getCount()+1);
						break;
					}
				}
				if(!isExisted){
					RiskAnalyseModel model = new RiskAnalyseModel(riskTypeDao.findById(tempRisk.getRiskTypeId()), 1);
					modelList.add(model);
				}
			}
			
			RiskAnalyseModel result = modelList.get(0);
			for(RiskAnalyseModel tempModel : modelList){
				if(tempModel.getCount() > result.getCount()){
					result = tempModel;
				}
			}
			return result;
		}
		return null;
	}

	@Override
	public RiskAnalyseModel getMostTroubledRisk(Date startTime, Date endTime, int userId) {
		List<RiskStatus> riskStatusList = riskStatusDao.findHappenedRiskStatusOnTime(startTime, endTime, userId);
		
		if(riskStatusList != null && !riskStatusList.isEmpty()){
			List<RiskAnalyseModel> modelList = new ArrayList<RiskAnalyseModel>();
			for(RiskStatus tempStatus : riskStatusList){
				boolean isExisted = false;
				for(RiskAnalyseModel tempModel : modelList){
					if(tempModel.getRiskType().getId() == riskDao.findById(tempStatus.getRiskId()).getRiskTypeId()){
						tempModel.setCount(tempModel.getCount()+1);
						isExisted = true;
						break;
					}
				}
				
				if(!isExisted){
					RiskAnalyseModel model = new RiskAnalyseModel(riskTypeDao.findById(riskDao.findById(tempStatus.getRiskId()).getRiskTypeId()), 1);
					modelList.add(model);
				}
			}
			RiskAnalyseModel result = modelList.get(0);
			for(RiskAnalyseModel tempModel : modelList){
				if(tempModel.getCount() > result.getCount()){
					result = tempModel;
				}
			}
			return result;
		}
		
		return null;
	}
	
	@Override
	public List<RiskAnalyseModel> getTop5AcknowledgedRisks(Date startTime, Date endTime) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		return riskTypeDao.getListOrderByAcknowledgement(formatter.format(startTime), formatter.format(endTime), 5);
	}

	@Override
	public List<RiskAnalyseModel> getTop5TroubledRisks(Date startTime, Date endTime) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		return riskTypeDao.getListOrderByProblem(formatter.format(startTime), formatter.format(endTime), 5);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RiskAnalyseService service = ctx.getBean(RiskAnalyseService.class);
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
		System.out.println(service.getMostTroubledRisk(startTime, endTime, 1).getRiskType().getId() + " " + service.getMostTroubledRisk(startTime, endTime, 1).getCount());
	}

	

}
