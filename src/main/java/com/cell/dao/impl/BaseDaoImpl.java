package com.cell.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class BaseDaoImpl<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	public List<?> doSqlQuery(String sql){
		Session session = sessionFactory.getCurrentSession();
		return session.createSQLQuery(sql).list();
	}
	public List<?> doHqlQuery(String hql) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(Class t,long id){
    	Session session = sessionFactory.getCurrentSession();
		return (T)session.get(t, id);
    };
    /**
     * @param t entity类
     * @param coloum 字段 ！！！！！！！！注意！这里使用的是hql，所以关联键不能直接用，比如类a中含有类b，要使用a.b.id的形式来写不能采取a.b_id
     * @param value 取值
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public T getByColumn(Class t, String column, Object value) {
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(t);
    	criteria.add(Restrictions.eq(column, value));
		List<?> list = criteria.list();
		if ((list.size()) == 0){
			return null;
		}else{
			return (T)list.get(0);
		}
	}
    public void add(T t){
    	Session session = sessionFactory.getCurrentSession();
		session.save(t);
    };
    public void delete(T t){
    	Session session = sessionFactory.getCurrentSession();
		session.delete(t);
    };
    public void update(T t){
    	Session session = sessionFactory.getCurrentSession();
		session.update(t);
    };
    @SuppressWarnings("rawtypes")
	public int getCounts(Class t){
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(t);
    	int count = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
    	return count;
    }
}
