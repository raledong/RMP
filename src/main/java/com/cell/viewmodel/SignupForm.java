package com.cell.viewmodel;

//前端表格模型
public class SignupForm {
	
	//登录名
	private String userName;
	
	//登录密码
	private String password;
	
	//重新输入密码
	private String repassword;
		

	
	public SignupForm(String userName, String password, String repassword){
		this.setUserName(userName);
		this.password = password;
		this.repassword = repassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
