package com.cell.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.model.User;
import com.cell.service.UserLoginService;

@Repository
public class LoginAction extends BaseAction{

	/**
	 * 登录
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserLoginService userLoginService;
	
	private String id;
	private String password;//密码
	private String gender;//性别
	private String role;//身份
	
	
	
	
	public String Login(){
		return LOGIN;
	}
	
	public String checkLogin(){
		if(authenticate()){
			//判断身份
//			System.out.println(id + ":" + password);
			
			if(userLoginService.signin(id, password)){
				User user = userLoginService.getUserById(id);
//				System.out.println(user);
				getSession().put("userId",user.getId());
				getSession().put("userRole", user.getRole());
				getSession().put("user", user);
				switch(user.getRole()){
				case Programmer: 
					role="Programmer";
					break;
				case Manager:
					role="Manager";
					break;
				default:
					break;
				}
				return SUCCESS;
			}
		}
		return ERROR;
		
	}
	
	/**
	 * 验证登录
	 */
	public boolean authenticate(){
		if(this.getId()==null||this.getId().equals("")){
			addActionError("用户名不能为空");
			return false;
		}
		if(this.getPassword()==null || this.getPassword().equals("")){
			addActionError("密码不能为空");
			return false;
		}
		return true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
