package com.cell.service;

import com.cell.model.Project;
import com.cell.viewmodel.ProjectForm;

public interface ProjectManagementService {

	//创建项目
	public void createProject(Project project);
	public void createProject(ProjectForm project);
	
	//添加程序员
	public void addProgrammer(int projectId, int programmerId);
	
}
