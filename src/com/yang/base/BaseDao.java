package com.yang.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param i
	 */
	void delete(Long i);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);
	void merge(T entity);
	/**
	 * 查询实体，如果id为null，则返回null，并不会抛异常�?
	 * 
	 * @param id
	 * @return
	 */
	T findById(Long id);

	/**
	 * 查询实体
	 * 
	 * @param ids
	 * @return
	 */
	List<T> findByIds(Long[] ids);

	/**
	 * 查询实体
	 * 
	 * @return
	 */
	List<T> findAll();
}
