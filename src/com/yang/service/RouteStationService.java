package com.yang.service;

import java.util.List;

import com.yang.base.BaseDao;
import com.yang.entity.Route;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;

public interface RouteStationService extends BaseDao<RouteStation>{
	/**
	 * 
	 * @Description: 通过路线和始末站点在路线中的位置查找路线和站点信息
	 * @param @param routeId
	 * @param @param beginMarker
	 * @param @param endMarker
	 * @param @return
	 * @return List<RouteStation>
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-25
	 */
	public List<RouteStation> findByRouteAndMarker(Long routeId, Long beginMarker, Long endMarker); 
	/**
	 * 
	 * @Description: 通过路线名查找该路线的所有站点
	 * @param routeName
	 * @return List<Station>
	 * @author: fengmengyang
	 * @date: 2015-5-25
	 */
	public List<Station> findStationsByRouteName(String routeName);
	/**
	 * 
	 * @Description: 通过站点名查找所有通过该站点的路线
	 * @param stationName
	 * @return List<Route>
	 * @author: fengmengyang
	 * @date: 2015-5-25
	 */
	public List<Route> findRoutesByStationName(String stationName);
	/**
	 * 
	 * @Description: 通过路线id和位置查找对象
	 * @param routeId
	 * @param marker
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public RouteStation findByMarker(Long routeId, Long marker);
	/**
	 * 
	 * @Description: 根据路线和站点位置删除路线中的站点
	 * @param routeId
	 * @param marker
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public void deleteByMarker(Long routeId, Long marker);
}
