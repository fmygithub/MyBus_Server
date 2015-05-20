package com.yang.service;

import java.util.List;

import com.yang.base.BaseDao;
import com.yang.entity.DirectRouteView;


public interface RouteCheckService extends BaseDao<DirectRouteView> {
	/**
	 * 
	 * @Description: 通过起始和目标站点查询路线
	 * @param beginStationId 起始站点id
	 * @param endStationId 目标站点id
	 * @param @return
	 * @return DirectRouteView
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-18
	 */
	public List<DirectRouteView> checkRoute(Long beginStationId, Long endStationId);
}
