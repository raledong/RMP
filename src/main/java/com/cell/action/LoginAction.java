package com.cell.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.service.UserLoginService;

@Repository
public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserLoginService loginService;
	
	private String id;
	private String password;
	
	public String signin(){
		if(id==null){
			return SUCCESS;
		}
		if(id.equals("1")){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
