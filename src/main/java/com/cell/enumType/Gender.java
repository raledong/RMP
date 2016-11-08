package com.cell.enumType;

public enum Gender {
	MALE(0, "男"),
	FEMALE(1, "女");
	
	private int code;
	private String message;
	
	private Gender(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public static Gender fromCode(int code){
		if(code == 0)
			return MALE;
		
		if(code == 1)
			return FEMALE;
		
		return null;
	}
	
	public int getCode(){
		return this.code;
	}

	
	public String getMessage(){
		return this.message;
	}
	
	public String toString(){
		return message;
	}
	
}
