package com.cell.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cell.model.Project;
import com.cell.service.ProjectManagementService;

@Repository
public class ProjectAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProjectManagementService projectManagementService;
     
    private List<Project> projectList;//项目列表
    private String projectId;//项目编号
    private String projectName;//项目名称
    private String projectDescription;//项目描述
    private String projectCreatedAt;//提交时间
    private String projectCreatedBy;//提交者
    
    private String userId;
    
    private String errorMessage;
    
    
    
    public String showProjects(){
    	projectList=projectManagementService.getAllProjects();
    	request.setAttribute("projectList", projectList);
    	System.out.println(projectList.size());
    	for(Project project:projectList){
    		projectName=project.getName();
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
}
