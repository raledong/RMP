package com.cell.enumType;

//情况程度枚举类
public enum Level {
	
	LOW(0, "低"),
	MEDIUM(1, "中"),
	HIGH(2, "高");
	
	private int code;
	private String probability;
	
	private Level(int code, String probability){
		this.code = code;
		this.probability = probability;
	}

	public static Level fromCode(int code){
		if(code == 0)
			return LOW;
		if(code == 1)
			return MEDIUM;
		if(code == 2)
			return HIGH;
		return null;
	}
	
	public int getCode() {
		return code;
	}



	public String getProbability() {
		return probability;
	}

}
