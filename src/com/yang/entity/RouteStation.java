package com.yang.entity;

public class RouteStation {
	private int id;
	/**
	 * 站点在路线中的位置
	 */
	private int marker;
	/**
	 * 路线实体，与中间表构成一对多
	 */
	private Route route;
	/**
	 * 站点信息，与中间表构成一对多关系
	 */
	private Station station;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarker() {
		return marker;
	}
	public void setMarker(int marker) {
		this.marker = marker;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	
}
