package com.cell.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.UserDao;
import com.cell.enumType.Role;
import com.cell.model.User;


@Repository(value="userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}
	

	@Override
	public List<User> getUserByIdentity(Role role) {
		String hql = "from User user where user.role = :role";
		return this.findByNamedParam(hql, "role", role);
	}
	
	
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean("userDao",UserDao.class);
		User user = new User();
		user.setName("rale");
		user.setPassword("12345");
		user.setRole(Role.Programmer);
		userDao.add(user);
//		userDao.delete(10000000);
		System.out.println(userDao.findAll());
		for(User temp : userDao.getUserByIdentity(Role.Programmer)){
			System.out.println(temp.getRole());
		}
	}

	
}
