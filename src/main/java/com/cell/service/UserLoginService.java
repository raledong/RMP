package com.cell.service;

import com.cell.model.User;
import com.cell.viewmodel.SignupForm;

public interface UserLoginService {
	
	
	/**
	 * 使用邮箱，密码和邀请码进行注册
	 * @param signupForm
	 * @return
	 */
	public boolean signup(SignupForm signupForm);
	
	/**
	 * 登录
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean signin(String userId, String password);
	
	
	/**
	 * 已经登录的用户查看自己的基本信息
	 * @param userId
	 * @return
	 */
	public User getPersonInfo(String userId);
	
	
	/**
	 * @param id
	 * @return
	 */
	public User getUserById(String id);

}
