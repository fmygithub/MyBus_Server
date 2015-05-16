package com.yang.service;

import com.yang.base.BaseDao;
import com.yang.entity.Route;

public interface RouteService extends BaseDao<Route>{
	/**
	 * 
	 * @Description: 通过name查找实体
	 * @param routeName
	 * @return Route
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-15
	 */
	public Route findRouteByName(String routeName);
}
