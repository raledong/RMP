package com.cell.action;

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
    private String projectName;//
    private String projectDescription;//
    private String projectCreatedAt;//提交时间
    private String projectCreatedBy;//提交者
    
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
}
