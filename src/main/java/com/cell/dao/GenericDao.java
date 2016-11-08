package com.cell.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**
 * 这个接口用于实现基本的增删改查工作，用不同的entity可以将其初始化
 * @author rale
 */

/**
 * @author rale
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDao<T, ID extends Serializable> {
	
	/**
	 * 添加数据至数据库
	 * @param entity
	 */
	public ID add(T entity);
	
	
	/**
	 * 更新数据库数据
	 * @param entity
	 */
	public void update(T entity);
	
	
	/**
	 * 删除数据库数据
	 * @param id
	 */
	public void delete(ID id);
	
	
	/**
	 * 根据id查找相应实体
	 * @param id
	 * @return entity T
	 */
	public T findById(ID id);
	
	
	/**
	 * 获得所有实例
	 * @return List<T>
	 */
	public List<T> findAll();
	
	
	/**
	 * 及时提交变更
	 */
	public void flush(Session session);


	/**
	 * 及时清理session
	 * @param session
	 */
	public void clear(Session session);

	/**
	 * 通过指定column的值获得相应的查询结果
	 * @param queryString String
	 * @param paramName String
	 * @param value Object
	 * @return List<entity>
	 */
	public List<T> findByNamedParam(String queryString, String paramName, Object value);

	/**
	 * 设定多个column值获得相应的查询结果
	 * @param queryString String
	 * @param paramNames String[]
	 * @param values Object[]
	 * @return List<Entity>
	 */
	public List<T> findByNamedParam(String queryString, String[] paramNames,Object[] values);

	/**
	 * 使用hql语句进行查询
	 * @param hql String
	 * @return List<entity>
	 */
	public List<T> HQLQuery(String hql);
	
	

	
}
