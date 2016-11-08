package com.cell.dao;

import java.util.List;

import com.cell.model.HarveyName;


public interface HarveyNameDao extends BaseDao<HarveyName>{
	public List<HarveyName> getAll();
	
}