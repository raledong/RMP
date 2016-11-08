package com.cell.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cell.dao.GenericDao;




/**
 * genericDao接口的泛型实现 为抽象类
 * @author rale
 *
 * @param <T>
 * @param <ID>
 */
@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	private Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GenericDaoImpl(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass(){
		return this.persistentClass;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public Session currentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 根据id查找相应实体
	 * @param id
	 * @return entity T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id){
		T entity = null;
		Session session = this.currentSession();
		entity = (T)session.get(persistentClass, id);
		return entity;
	}
	
	/**
	 * 添加数据至数据库
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ID add(T entity){
		return (ID)currentSession().save(entity);
	}
	
	/**
	 * 更新数据库数据
	 * @param entity
	 */
	@Override
	public void update(T entity){
		currentSession().update(entity);;
	}
	
	/**
	 * 删除数据库数据
	 * @param id
	 */
	@Override
	public void delete(ID id){
		T entity = findById(id);
		Session session = currentSession();
		session.delete(entity);
	}
	
	
	/**
	 * 获得所有实例
	 * @return List<T>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		List<T> entityList = null;
		Session session = this.currentSession();
		entityList = (List<T>)session.createCriteria(persistentClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return entityList;
	}
	
	/**
	 * 及时提交变更
	 */
	@Override
	public void flush(Session session){
		if(session != null){
			session.flush();
		}
	}
	
	/**
	 * 及时清理session
	 * @param session
	 */
	@Override
	public void clear(Session session){
		if(session != null)
			session.clear();
	}
	
	/**
	 * 使用hql语句进行查询
	 * @param hql String
	 * @return List<entity>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> HQLQuery(String hql){
		return (List<T>)currentSession().createQuery(hql).list();
	}
	
	/**
	 * 通过指定column的值获得相应的查询结果
	 * @param queryString String
	 * @param paramName String
	 * @param value Object
	 * @return List<entity>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParam(String queryString, String paramName, Object value){
		return (List<T>)currentSession().createQuery(queryString).setParameter(paramName, value).list();
	}
	
	/**
	 * 设定多个column值获得相应的查询结果
	 * @param queryString String
	 * @param paramNames String[]
	 * @param values Object[]
	 * @return List<Entity>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParam(String queryString, String[] paramNames,Object[] values) {
		Query query = currentSession().createQuery(queryString);
		for(int i=0 ; i<paramNames.length ; i++){
			query.setParameter(paramNames[i], values[i]);
		}
		return (List<T>)query.list();
				
	}

}
