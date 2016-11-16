package com.cell.viewmodel;

import com.cell.model.RiskType;

//返回给界面的风险统计信息
public class RiskAnalyseModel {

	private RiskType riskType;
	
	private int count;

	public RiskAnalyseModel(RiskType riskType, int count){
		this.setRiskType(riskType);
		this.setCount(count);
	}
	public RiskType getRiskType() {
		return riskType;
	}

	public void setRiskType(RiskType riskType) {
		this.riskType = riskType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
