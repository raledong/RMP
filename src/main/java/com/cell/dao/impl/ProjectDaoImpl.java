package com.cell.dao.impl;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.ProjectDao;
import com.cell.dao.RiskDao;
import com.cell.enumType.Level;
import com.cell.model.Project;
import com.cell.model.Risk;

@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl extends GenericDaoImpl<Project, Integer> implements ProjectDao{

	public ProjectDaoImpl() {
		super(Project.class);
	}
	

	@Override
	public void addProgrammer(int projectId, int programmerId) {
		String sql = "insert into projects_programmers (project_id, programmer_id) values(?, ?)";
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, projectId);
		query.setParameter(1, programmerId);
		query.executeUpdate();
	}
	
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProjectDao projectDao = ctx.getBean("projectDao",ProjectDao.class);
		Project project = new Project();
		project.setDescription("this is test1");
		project.setName("test1");
		project.setCreatedBy(1);
		projectDao.add(project);
		projectDao.addProgrammer(1, 1);
	}


}
