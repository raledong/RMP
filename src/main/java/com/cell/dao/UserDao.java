package com.cell.dao;

import java.util.List;

import com.cell.enumType.Role;
import com.cell.model.User;

public interface UserDao extends GenericDao<User, Integer>{

	public List<User> getUserByIdentity(Role identity);
}
