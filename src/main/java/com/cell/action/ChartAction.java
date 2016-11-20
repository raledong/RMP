package com.cell.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	private String dateRange;
	private List<RiskAnalyseModel> acknowledged;
	private List<RiskAnalyseModel> troubled;

	public String showChart() {
		Date endDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		Calendar date = Calendar.getInstance();
		date.setTime(endDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		Date startDate = new Date();
		try {
			startDate = sdf.parse(sdf.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acknowledged = riskAnalyseService.getTop5AcknowledgedRisks(startDate, endDate);
		troubled = riskAnalyseService.getTop5TroubledRisks(startDate, endDate);
		request.setAttribute("acknowledged", acknowledged);
		request.setAttribute("troubled", troubled);
		return SUCCESS;
	}
	
	public String refreshChart() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
		String start, end;
		Date startDate = new Date(), endDate = new Date();
		start = dateRange.split("-")[0].trim();
		end = dateRange.split("-")[1].trim();
		try {
			startDate = sdf.parse(start);
			endDate = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acknowledged = riskAnalyseService.getTop5AcknowledgedRisks(startDate, endDate);
		troubled = riskAnalyseService.getTop5TroubledRisks(startDate, endDate);
		request.setAttribute("acknowledged", acknowledged);
		request.setAttribute("troubled", troubled);acknowledged.size();
		return SUCCESS;
	}
	
	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public List<RiskAnalyseModel> getAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(List<RiskAnalyseModel> acknowledged) {
		this.acknowledged = acknowledged;
	}

	public List<RiskAnalyseModel> getTroubled() {
		return troubled;
	}

	public void setTroubled(List<RiskAnalyseModel> troubled) {
		this.troubled = troubled;
	}
}
