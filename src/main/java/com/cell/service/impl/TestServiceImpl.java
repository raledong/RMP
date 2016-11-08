package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.HarveyNameDao;
import com.cell.model.HarveyName;
import com.cell.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private HarveyNameDao harveyNameDao;

	@Override
	public List<HarveyName> getList() {
		// TODO Auto-generated method stub
		List<HarveyName> mylist = harveyNameDao.getAll();
		if (mylist == null || mylist.size() == 0) {
			// 先存储
			String[] list = { "harvey", "harveyprince", "伯爵小轩", "轩辕泪", "林天仇", "木木天九" };
			for (int i = 0; i < list.length; i++) {
				HarveyName hn = new HarveyName();
				hn.setName(list[i]);
				harveyNameDao.add(hn);
			}
			mylist = harveyNameDao.getAll();
		}
		return mylist;
	}

}
