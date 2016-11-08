package com.cell.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.model.HarveyName;
import com.cell.service.TestService;


@Repository
public class TestAction extends BaseAction {
	//以下是依赖注入
	@Autowired
	private TestService testService;
	
	private Map<String, Object> jsonResult;
	private List<HarveyName> jsonList;
	private String hello;
	
	public String welcome(){
		hello = "hello";
		return SUCCESS;
		//这个结果会按照字符串形式在struts配置文件中寻找对应项返回，这个字符串可以自己定义
	}
	
	public String jsonGet(){
		//防止生命周期未结束使用了原来的数据
		jsonResult = new HashMap<String, Object>();
		HarveyName hn = testService.getList().get(0);
		jsonResult.put("harveynamedefault", hn);
		return SUCCESS;
	}
	
	public String jsonListGet(){
		jsonList = new ArrayList<HarveyName>();
		jsonList = testService.getList();
		return SUCCESS;
	}

	/*
	 * 关于这个private属性值的set\get方法说明
	 * set是服务器通过struts拿到前台传送的数据时对属性值进行赋值使用的
	 * get是struts拿到服务器数据进行处理时需要的【当然懒得区分这些就可以set\get都写，但是麻烦
	 * */
	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}
	
	public List<HarveyName> getJsonList() {
		return jsonList;
	}

	public String getHello() {
		return hello;
	}
	

}
