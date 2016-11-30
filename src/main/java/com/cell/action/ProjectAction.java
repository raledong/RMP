package com.cell.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.enumType.Level;
import com.cell.model.Project;
import com.cell.model.RiskPlan;
import com.cell.model.RiskPlanItem;
import com.cell.model.RiskType;
import com.cell.service.ProjectManagementService;
import com.cell.service.RiskAnalyseService;
import com.cell.service.RiskManagementService;
import com.cell.service.RiskPlanManagementService;
import com.cell.viewmodel.PlanModel;
import com.cell.viewmodel.RiskAnalyseModel;

@Repository
public class ProjectAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProjectManagementService projectManagementService;
    @Autowired
    private RiskPlanManagementService riskPlanManagementService;
    @Autowired
    private RiskAnalyseService riskAnalyseService;
    @Autowired
    private RiskManagementService riskManagementService;
     
    private List<Project> projectList;//项目列表
    private List<RiskPlan> riskPlanList;//计划列表
    private List<RiskPlanItem> riskPlanItemList;//计划条目列表
    private List<RiskPlanItem> importRiskList;//导入的计划条目列表
    private List<RiskType> riskTypeList;//风险类型列表
    
    private ArrayList<PlanModel> planModelList;
    
    private RiskAnalyseModel mostAcknowledgedRisk;
    private RiskAnalyseModel mostTroubledRisk;
    private RiskType riskType;
    
    private String projectId;//项目编号
    private String projectName;//项目名称
    private String projectDescription;//项目描述
    private String projectCreatedAt;//提交时间
    private String projectCreatedBy;//提交者
    
    private String riskId;//风险编号
    private String riskInfo;//风险内容
    private String riskProbability;//可能性
    private String riskImpact;//影响程度
    private String riskTrigger;//触发器（阈值）
    
    private String riskTypeId;
    private String riskTypeInfo;
    private String riskTypeCreateBy;
    
    private int count;
    
    private Date startTime;
    private Date endTime;
    
    private String userId;
    
    private String errorMessage;
    
    public String showProjects(){
    	projectList=projectManagementService.getAllProjects();
    	riskPlanList=riskPlanManagementService.getAllRiskPlans((int) this.getSession().get("userId"));
    	riskPlanItemList=new ArrayList<RiskPlanItem>();
    	planModelList=new ArrayList<PlanModel>();
    	for(RiskPlan riskPlan:riskPlanList){
    		PlanModel planModel=new PlanModel();
    		planModel.setRiskPlan(riskPlan);
    		planModel.setRiskPlanItemList(riskPlanManagementService.getAllRiskPlanItems(riskPlan.getId()));
    		planModelList.add(planModel);
    	}
    	return SUCCESS;
    }
    
    
    public String addProject(){
    	if(!this.validateForm()){
            return ERROR;
        }
        Project project = new Project();
        project.setName(projectName);
        project.setDescription(projectDescription);
        project.setCreatedAt(new Date());
        project.setCreatedBy((int) this.getSession().get("userId"));
        projectManagementService.createProject(project);
    	return SUCCESS;
    }
    
    /**
     * @return boolean
     * 检验输入是否合法
     */
    public boolean validateForm(){
        errorMessage = "";
        boolean valid = true;
        if(projectName==null || projectName.equals("")){
            errorMessage = errorMessage.concat("未填项目名称");
            valid = false;
        }
        if(projectDescription==null || projectDescription.equals("")){
            errorMessage = errorMessage.concat("未填项目描述");
            valid = false;
        }
        return valid;
    }
    
    
    public String createRA(){
    	riskTypeList=riskManagementService.getAllRiskTypes((int) this.getSession().get("userId"));
    	return SUCCESS;
    }
    
    /**
     * 分析获取当前用户管理的risk的识别最多项和演变成问题最多项
     * @return
     */
    public String analyse(){
    	startTime=stringToDate(request.getParameter("startTime"));
    	endTime=stringToDate(request.getParameter("endTime"));
    	mostAcknowledgedRisk=riskAnalyseService.getMostAcknowledgedRisk(startTime, endTime, (int)this.getSession().get("userId"));
    	mostTroubledRisk=riskAnalyseService.getMostTroubledRisk(startTime, endTime, (int)this.getSession().get("userId"));
    	if(startTime==null||startTime.equals("")||endTime==null||endTime.equals("")){
    		System.out.println("date错误！！！");
    		return ERROR;
    	}
    	return SUCCESS;
    }
    
    /**
     * string转date
     * @param str
     * @return
     */
    public Date stringToDate(String str) {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {
        	date = sdf.parse(str);   
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
        date = java.sql.Date.valueOf(str);
        return date;  
    }
    
    public String importMostAcknowledgedRisk(){
    	
    	RiskPlanItem ra=new RiskPlanItem();
    	ra.setTypeId(mostAcknowledgedRisk.getRiskType().getId());
    	ra.setInfo(mostAcknowledgedRisk.getRiskType().getInfo());
    	riskPlanItemList.add(ra);
    	
    	System.out.println("riskPlanItemList"+riskPlanItemList.size());
    	
    	return SUCCESS;
    }
    
    public String importMostTroubledRisk(){
    	
    	RiskPlanItem rt=new RiskPlanItem();
    	rt.setTypeId(mostTroubledRisk.getRiskType().getId());
    	rt.setInfo(mostTroubledRisk.getRiskType().getInfo());
    	riskPlanItemList.add(rt);
    	
    	return SUCCESS;
    }
    
    
    public String modRiskPlanItem(){
    	
    	riskId=request.getParameter("riskId");
        riskTypeId=request.getParameter("riskTypeId");
        riskInfo=request.getParameter("riskInfo");
        riskProbability=request.getParameter("riskProbability");
        riskImpact=request.getParameter("riskImpact");
        riskTrigger=request.getParameter("riskTrigger");
    	
    	if(!this.validateRiskForm()){
    		System.out.println(errorMessage);
    		System.out.println("修改item出错！！！");
            return ERROR;
        }
    	
		RiskPlanItem riskPlanItem = new RiskPlanItem();
		riskPlanItem.setTypeId(Integer.parseInt(riskTypeId));
		riskPlanItem.setInfo(riskInfo);
		riskPlanItem.setProbability(Level.fromCode(transform(riskProbability)));
		riskPlanItem.setImpact(Level.fromCode(transform(riskImpact)));
		riskPlanItem.setTrigger(riskTrigger);
		System.out.println("riskPlanItem"+riskPlanItem.getId()+riskPlanItem.getInfo());
		int i=Integer.parseInt(riskId);
		if(i>=0&&i<riskPlanItemList.size())
			riskPlanItemList.set(i, riskPlanItem);
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
     * @return boolean
     * 检验表格内容是否合法
     */
    public boolean validateRiskForm(){
        errorMessage = "";
        boolean valid = true;
//        riskInfo=request.getParameter("riskInfo");
//        riskTrigger=request.getParameter("riskTrigger");
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
    
    public String addRiskPlanItem(){
    	
        riskTypeId=request.getParameter("riskTypeId");
        riskInfo=request.getParameter("riskInfo");
        riskProbability=request.getParameter("riskProbability");
        riskImpact=request.getParameter("riskImpact");
        riskTrigger=request.getParameter("riskTrigger");
    	
    	if(!this.validateRiskForm()){
    		System.out.println(errorMessage);
    		System.out.println("添加item出错！！！");
            return ERROR;
        }
        
		RiskPlanItem riskPlanItem = new RiskPlanItem();
		riskPlanItem.setTypeId(Integer.parseInt(riskTypeId));
		riskPlanItem.setInfo(riskInfo);
		riskPlanItem.setProbability(Level.fromCode(transform(riskProbability)));
		riskPlanItem.setImpact(Level.fromCode(transform(riskImpact)));
		riskPlanItem.setTrigger(riskTrigger);
		riskPlanItemList.add(riskPlanItem);
		return SUCCESS;
    }
    
    
    public String saveRA(){
    	
    	RiskPlan riskPlan=new RiskPlan();
    	riskPlan.setCreatedAt(new Date());
    	riskPlan.setCreatedBy((int)this.getSession().get("userId"));
    	
    	riskPlanManagementService.createRiskPlan(riskPlan);
    	
    	int a=riskPlanList.size()+1;
    	
    	for(int i=0;i<riskPlanItemList.size();i++){
    		riskPlanItemList.get(i).setPlanId(a);
    		riskPlanManagementService.createRiskPlanItem(riskPlanItemList.get(i));
		}
    	
    	return SUCCESS;
    }


	public List<Project> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectCreatedAt() {
		return projectCreatedAt;
	}


	public void setProjectCreatedAt(String projectCreatedAt) {
		this.projectCreatedAt = projectCreatedAt;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getProjectCreatedBy() {
		return projectCreatedBy;
	}


	public void setProjectCreatedBy(String projectCreatedBy) {
		this.projectCreatedBy = projectCreatedBy;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RiskPlan> getRiskPlanList() {
		return riskPlanList;
	}

	public void setRiskPlanList(List<RiskPlan> riskPlanList) {
		this.riskPlanList = riskPlanList;
	}


	public ArrayList<PlanModel> getPlanModelList() {
		return planModelList;
	}


	public void setPlanModelList(ArrayList<PlanModel> planModelList) {
		this.planModelList = planModelList;
	}

	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public RiskType getRiskType() {
		return riskType;
	}


	public void setRiskType(RiskType riskType) {
		this.riskType = riskType;
	}


	public String getRiskTypeId() {
		return riskTypeId;
	}


	public void setRiskTypeId(String riskTypeId) {
		this.riskTypeId = riskTypeId;
	}


	public String getRiskTypeInfo() {
		return riskTypeInfo;
	}


	public void setRiskTypeInfo(String riskTypeInfo) {
		this.riskTypeInfo = riskTypeInfo;
	}


	public String getRiskTypeCreateBy() {
		return riskTypeCreateBy;
	}


	public void setRiskTypeCreateBy(String riskTypeCreateBy) {
		this.riskTypeCreateBy = riskTypeCreateBy;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public RiskAnalyseModel getMostAcknowledgedRisk() {
		return mostAcknowledgedRisk;
	}


	public void setMostAcknowledgedRisk(RiskAnalyseModel mostAcknowledgedRisk) {
		this.mostAcknowledgedRisk = mostAcknowledgedRisk;
	}


	public RiskAnalyseModel getMostTroubledRisk() {
		return mostTroubledRisk;
	}


	public void setMostTroubledRisk(RiskAnalyseModel mostTroubledRisk) {
		this.mostTroubledRisk = mostTroubledRisk;
	}


	public List<RiskPlanItem> getRiskPlanItemList() {
		return riskPlanItemList;
	}


	public void setRiskPlanItemList(List<RiskPlanItem> riskPlanItemList) {
		this.riskPlanItemList = riskPlanItemList;
	}


	public List<RiskPlanItem> getImportRiskList() {
		return importRiskList;
	}


	public void setImportRiskList(List<RiskPlanItem> importRiskList) {
		this.importRiskList = importRiskList;
	}


	public List<RiskType> getRiskTypeList() {
		return riskTypeList;
	}


	public void setRiskTypeList(List<RiskType> riskTypeList) {
		this.riskTypeList = riskTypeList;
	}
}
