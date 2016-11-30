package com.cell.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cell.service.RiskAnalyseService;
import com.cell.viewmodel.RiskAnalyseModel;

public class ChartAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7738135223711767411L;
	
	@Autowired
    private RiskAnalyseService riskAnalyseService;
	
	private List<RiskAnalyseModel> top5AcknowledgedRisks;
	private List<RiskAnalyseModel> top5TroubledRisks;
	
	private Date startTime;
    private Date endTime;

	public String showChart() {
		return SUCCESS;
	}
	
	public String analyseRisk() {
		startTime=stringToDate(request.getParameter("startTime"));
    	endTime=stringToDate(request.getParameter("endTime"));
    	top5AcknowledgedRisks=riskAnalyseService.getTop5AcknowledgedRisks(startTime, endTime);
    	top5TroubledRisks=riskAnalyseService.getTop5TroubledRisks(startTime, endTime);
    	
    	System.out.println("top5AcknowledgedRisks"+top5AcknowledgedRisks.get(0).getRiskType().getInfo());
    	
    	if(startTime==null||startTime.equals("")||endTime==null||endTime.equals("")){
    		System.out.println("date错误！！！");
    		return ERROR;
    	}
		return SUCCESS;
	}
	
	/**
     * string转date
     * @param str
     * @return
     */
    public Date stringToDate(String str) {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {
        	date = sdf.parse(str);   
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
        date = java.sql.Date.valueOf(str);
        return date;  
    }

	public List<RiskAnalyseModel> getTop5AcknowledgedRisks() {
		return top5AcknowledgedRisks;
	}

	public void setTop5AcknowledgedRisks(List<RiskAnalyseModel> top5AcknowledgedRisks) {
		this.top5AcknowledgedRisks = top5AcknowledgedRisks;
	}

	public List<RiskAnalyseModel> getTop5TroubledRisks() {
		return top5TroubledRisks;
	}

	public void setTop5TroubledRisks(List<RiskAnalyseModel> top5TroubledRisks) {
		this.top5TroubledRisks = top5TroubledRisks;
	}
	
}
