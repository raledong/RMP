package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.UserDao;
import com.cell.enumType.Role;
import com.cell.model.User;
import com.cell.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getProgrammerList() {
		return userDao.getUserByIdentity(Role.Programmer);
	}

}
