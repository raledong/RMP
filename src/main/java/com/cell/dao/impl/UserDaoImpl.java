package com.cell.dao.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.UserDao;
import com.cell.model.User;


@Repository(value="userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean("userDao",UserDao.class);
		User user = new User("rale","12345");
		user.setName("rale");
		user.setPassword("12345");
		userDao.add(user);
//		userDao.delete(10000000);
		System.out.println(userDao.findAll());
	}
	
}
