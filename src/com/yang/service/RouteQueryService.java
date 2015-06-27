package com.yang.service;

import java.util.List;

import com.yang.base.BaseDao;
import com.yang.entity.DirectRouteView;
import com.yang.entity.OneTranferRouteView;
import com.yang.entity.TwoTranferRouteView;


public interface RouteQueryService extends BaseDao<DirectRouteView> {
	/**
	 * 
	 * @Description: 通过起始和目标站点查询直达路线
	 * @param beginStationName 起始站点name
	 * @param endStationName 目标站点name
	 * @return List<DirectRouteView>
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-18
	 */
	public List<DirectRouteView> checkDirectRoute(String beginStationName, String endStationName);
	/**
	 * 
	 * @Description: 通过始末站点查询一次换乘的路线
	 * @param beginStationName
	 * @param endStationName
	 * @return List<OneTranferRouteView>
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-27
	 */
	public List<OneTranferRouteView> checkOneChangeRoute(String beginStationName, String endStationName);
	/**
	 * 
	 * @Description: 通过始末站点查询两次换乘的路线
	 * @param beginStationName
	 * @param endStationName
	 * @return List<OneTranferRouteView>
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-27
	 */
	public List<TwoTranferRouteView> checkTwoChangeRoute(String beginStationName, String endStationName);
}
