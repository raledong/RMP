package com.cell.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.enumType.Level;
import com.cell.model.Risk;
import com.cell.model.RiskStatus;
import com.cell.service.RiskManagementService;

@Repository
public class RiskAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
    
    @Autowired
    private RiskManagementService riskManagementService;
     
    private List<Risk> riskList;//风险列表
    private List<RiskStatus> riskStatusList;//风险状态列表
    private String riskId;//风险编号
    private String projectId;//项目编号
    private String riskInfo;//风险内容
    private String riskProbability;//可能性
    private String riskImpact;//影响程度
    private String riskTrigger;//触发器（阈值）
    private String riskCreatedAt;//提交时间
    private String riskCreatedBy;//提交者
    private String riskFollowedBy;//跟踪者
    private String statusId;//状态编号
    private String statusInfo;//状态内容
    private String statusCreatedBy;//状态提交者
    private String statusCreatedAt;//状态提交时间
    
    private String errorMessage;
    
     
    public String showRisks(){
//        riskList=riskManagementService.getAllRisks(Integer.parseInt(projectId));
    	riskList=riskManagementService.getAllRisks(1);
    	request.setAttribute("riskList", riskList);
    	System.out.println("该项目当前risk列表共："+riskList.size()+"项");
    	System.out.println("risk列表：");
    	for(Risk risk:riskList){
    		riskInfo=risk.getInfo();
    		System.out.println(riskInfo);
    	}
    	System.out.println("该项目当前risk列表显示完成！！！");
        return SUCCESS;
    }
    
    
    public String addRisk(){
    	System.out.println("这里是添加项目风险项的开始页面！！！");
    	riskList=riskManagementService.getAllRisks(1);
    	request.setAttribute("riskList", riskList);
    	System.out.println("目前项目risk数："+riskList.size());
    	return SUCCESS;
    }

 
    /**
     * 添加一个风险项
     * @return
     */
    public String add(){
        System.out.println("开始新增风险项！！！");
        if(!this.validateRiskForm()){
            System.out.println("空！！！");
            return ERROR;
        }
        Risk risk = new Risk();
        risk.setProjectId(1);
        risk.setInfo(riskInfo);
        risk.setProbability(Level.fromCode(transform(riskProbability)));
        risk.setImpact(Level.fromCode(transform(riskImpact)));
        risk.setTrigger(riskTrigger);
        risk.setCreatedAt(new Date());
        risk.setCreatedBy(1);
        risk.setFollowedBy(1);
        System.out.println("新增的risk："+risk.getInfo()+risk.getProbability());
        riskManagementService.createRisk(risk);
        return SUCCESS;
    }
    
    public int transform(String probability){
    	switch(probability.toLowerCase()){
    	case "high" :  return 2;
    	case "medium" : return 1;
    	case "low" : return 0;
    	default: return -1;
    	}
    }
 
    
    /**
     * 修改一个风险项
     * @return
     */
    public String modRisk(){
        if(riskId==null || riskId.equals("") || !validateRiskForm()){
        	System.out.println("修改失败！！！");
			return ERROR;
		}
        
		Risk risk = riskManagementService.getRiskById(Integer.parseInt(riskId));
		risk.setInfo(riskInfo);
		risk.setProbability(Level.fromCode(transform(riskProbability)));
		risk.setImpact(Level.fromCode(transform(riskImpact)));
		risk.setTrigger(riskTrigger);
		riskManagementService.updateRisk(risk);
		System.out.println("风险项修改完成！！！");
		return SUCCESS;
    }
    
    
    /**
     * @return boolean
     * 检验表格内容是否合法
     */
    public boolean validateRiskForm(){
        errorMessage = "";
        boolean valid = true;
        if(riskInfo==null || riskInfo.equals("")){
            errorMessage = errorMessage.concat("未填风险内容");
            valid = false;
        }
        if(riskTrigger==null || riskTrigger.equals("")){
            errorMessage = errorMessage.concat("未填触发器");
            valid = false;
        }
        return valid;
    }
    
    /**
     * 检查输入是否合法
     * @return boolean
     */
    public boolean validateRiskStatusForm(){
        errorMessage = "";
        boolean valid = true;
        if(statusInfo==null || statusInfo.equals("")){
            errorMessage = errorMessage.concat("未填状态内容");
            valid = false;
        }
        return valid;
    }
    
    
    /**
     * 查看某个项目某风险项的状态跟踪
     * @return
     */
    public String statusTracking(){
//    	riskList=riskManagementService.getAllRisks(1);
//    	request.setAttribute("riskList", riskList);
//    	System.out.println("该项目当前risk列表共："+riskList.size()+"项");
//    	System.out.println("risk列表：");
//    	for(Risk risk:riskList){
//    		riskInfo=risk.getInfo();
//    		System.out.println(riskInfo);
//    	}
    	
    	riskStatusList=riskManagementService.getAllRiskStatusByRiskId(1);
    	request.setAttribute("riskStatusList", riskStatusList);
    	System.out.println("该项目当前该risk共："+riskStatusList.size()+"条状态跟踪");
    	System.out.println("riskStatus列表：");
    	for(RiskStatus riskStatus:riskStatusList){
    		System.out.println(riskStatus.getId());
    	}
    	return SUCCESS;
    }
    
    /**
     * 添加一个风险状态跟踪
     * @return
     */
    public String addStatus(){
        System.out.println("开始新增风险状态跟踪！！！");
        if(!this.validateRiskStatusForm()){
            System.out.println("空！！！");
            return ERROR;
        }
        RiskStatus riskStatus = new RiskStatus();
        riskStatus.setRiskId(1);
        riskStatus.setInfo(statusInfo);
        riskStatus.setCreatedAt(new Date());
        riskStatus.setCreatedBy(1);
        System.out.println("新增的riskStatus："+riskStatus.getInfo());
        riskManagementService.createRiskStatus(riskStatus);
        return SUCCESS;
    }


	public List<Risk> getRiskList() {
		return riskList;
	}


	public void setRiskList(List<Risk> riskList) {
		this.riskList = riskList;
	}


	public String getRiskId() {
		return riskId;
	}


	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getRiskInfo() {
		return riskInfo;
	}


	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}


	public String getRiskProbability() {
		return riskProbability;
	}


	public void setRiskProbability(String riskProbability) {
		this.riskProbability = riskProbability;
	}


	public String getRiskImpact() {
		return riskImpact;
	}


	public void setRiskImpact(String riskImpact) {
		this.riskImpact = riskImpact;
	}


	public String getRiskTrigger() {
		return riskTrigger;
	}


	public void setRiskTrigger(String riskTrigger) {
		this.riskTrigger = riskTrigger;
	}


	public String getRiskCreatedAt() {
		return riskCreatedAt;
	}


	public void setRiskCreatedAt(String riskCreatedAt) {
		this.riskCreatedAt = riskCreatedAt;
	}


	public String getRiskCreatedBy() {
		return riskCreatedBy;
	}


	public void setRiskCreatedBy(String riskCreatedBy) {
		this.riskCreatedBy = riskCreatedBy;
	}


	public String getRiskFollowedBy() {
		return riskFollowedBy;
	}


	public void setRiskFollowedBy(String riskFollowedBy) {
		this.riskFollowedBy = riskFollowedBy;
	}


	public List<RiskStatus> getRiskStatusList() {
		return riskStatusList;
	}


	public void setRiskStatusList(List<RiskStatus> riskStatusList) {
		this.riskStatusList = riskStatusList;
	}


	public String getStatusId() {
		return statusId;
	}


	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}


	public String getStatusInfo() {
		return statusInfo;
	}


	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}


	public String getStatusCreatedBy() {
		return statusCreatedBy;
	}


	public void setStatusCreatedBy(String statusCreatedBy) {
		this.statusCreatedBy = statusCreatedBy;
	}


	public String getStatusCreatedAt() {
		return statusCreatedAt;
	}


	public void setStatusCreatedAt(String statusCreatedAt) {
		this.statusCreatedAt = statusCreatedAt;
	}
     
}