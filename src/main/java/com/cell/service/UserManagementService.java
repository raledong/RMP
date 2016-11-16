package com.cell.service;

import java.util.List;

import com.cell.model.User;

public interface UserManagementService {

	//获得程序员列表，即可选跟踪者列表
	public List<User> getProgrammerList();
}
