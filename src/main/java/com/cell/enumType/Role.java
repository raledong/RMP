package com.cell.enumType;

//用户的角色
public enum Role {

	Administrator(0, "管理员"),
	Programmer(1, "程序员"),
	Manager(2, "项目经理");

	private int code;
	private String character;
	
	private Role(int code, String character){
		this.code = code;
		this.character = character;
	}
	
	public static Role fromCode(int code){
		if(code == 0)
			return Administrator;
		if(code == 1)
			return Programmer;
		if(code == 2)
			return Manager;
		return null;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getCharacter(){
		return this.character;
	}
	
}
