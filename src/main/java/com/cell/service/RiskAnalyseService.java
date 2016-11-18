package com.cell.service;

import java.util.Date;
import java.util.List;

import com.cell.viewmodel.RiskAnalyseModel;

//提供风险的统计功能
public interface RiskAnalyseService {
	/**
	 * 获得单个项目经理在某个时间段内被识别最多的风险类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param userId 用户id
	 * 若有并列，则返回其中之一
	 * */
	public RiskAnalyseModel getMostAcknowledgedRisk(Date startTime, Date endTime, int userId);
	
	/**
	 * 获得单个项目经理在某个时间段内演变成问题最多的风险类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param userId 用户id
	 * */
	public RiskAnalyseModel getMostTroubledRisk(Date startTime, Date endTime, int userId);
	
	/**
	 * 统计所有风险，获得在某个时间段内被识别最多的风险类型，用于图表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * */
	public List<RiskAnalyseModel> getTop5AcknowledgedRisks(Date startTime, Date endTime);
	
	/**
	 * 统计所有风险，获得在某个时间段内演变成问题最多的风险类型，用于图表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * */
	public List<RiskAnalyseModel> getTop5TroubledRisks(Date startTime, Date endTime);
}
