package com.cell.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.HarveyNameDao;
import com.cell.model.HarveyName;


@Repository
@Transactional
public class HarveyNameDaoImpl extends BaseDaoImpl<HarveyName> implements HarveyNameDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<HarveyName> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(HarveyName.class);
		return criteria.list();
	}

}
