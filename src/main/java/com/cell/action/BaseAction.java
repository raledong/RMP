package com.cell.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,  
        ServletRequestAware, ServletResponseAware {  
  
    private static final long serialVersionUID = 1L;  
 
    public HttpServletRequest   request;  
    public HttpServletResponse  response;
    public Map<String, Object> session;
    
    public void setSession(Map<String, Object> session) {  
        this.session = session;
    }

    public void setServletRequest(HttpServletRequest request) {  
       this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {  
       this.response = response;
    }
    
    public static boolean isDataIllegal(String data) {
    	if (data.contains(" ") || data.contains("<") || data.contains(">")
    			|| data.contains("=") || data.contains("+") || data.contains("!")
    			|| data.contains("&") || data.contains("-")) {
    		return true;
    	} else {
    		return false;
    	}
	}
    
    
    public Map<String, Object> getSession(){
    	return this.session;
    }
    
    public HttpServletRequest getServletRequest(){
    	return this.request;
    }
    
    public HttpServletResponse getServletRespone(){
    	return this.response;
    }

}