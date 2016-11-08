package com.cell.service;

import java.util.List;

import com.cell.model.HarveyName;


public interface TestService {
	/**
	 * 获取HarveyName的list，如果为空，则先存储，再读取
	 * @return
	 */
	public List<HarveyName> getList();
}
