package com.yang.entity;

import java.util.Set;

/**
 * 
 * ClassName: Station
 * @Description: 站点实体
 * @author: fengmengyang
 * @date: 2015-5-15
 */
public class Station {
	private int stationId;
	/**
	 * 站点名
	 */
	private String stationName;
	/**
	 * 站点位置对象（一对一关系）
	 */
	private Position position;
	/**
	 * 路线对象（多对多关系）
	 */
	private Set<Route> routes;
	/**
	 * 与中间表构成一对多关系
	 */
	private Set<RouteStation> routeStations;
	
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Set<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	public Set<RouteStation> getRouteStations() {
		return routeStations;
	}
	public void setRouteStations(Set<RouteStation> routeStations) {
		this.routeStations = routeStations;
	}
	
	
}
