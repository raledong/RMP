package com.cell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.dao.ProjectDao;
import com.cell.model.Project;
import com.cell.service.ProjectManagementService;
import com.cell.viewmodel.ProjectForm;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void createProject(Project project) {
		projectDao.add(project);
	}

	@Override
	public void createProject(ProjectForm project) {
	}

	@Override
	public void addProgrammer(int projectId, int programmerId) {
		projectDao.addProgrammer(projectId, programmerId);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDao.findAll();
	}

	
}
