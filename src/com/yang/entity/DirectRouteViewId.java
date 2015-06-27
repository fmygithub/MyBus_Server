package com.yang.entity;

import java.io.Serializable;

public class DirectRouteViewId implements Serializable{
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 起始站点id
	 */
	private Long beginStationId;
	/**
	 * 起始站点name
	 */
	private String beginStationName;
	/**
	 * 起始站点在路线中的位置
	 */
	private Long beginMarker;
	/**
	 * 目标站点id
	 */
	private Long endStationId;
	/**
	 * 目标站点name
	 */
	private String endStationName;
	/**
	 * 目标站点在路线中的位置
	 */
	private Long endMarker;
	/**
	 * 路线id
	 */
	private Long routeId;
	private String routeName;
	/**
	 * 经过的总站点数
	 */
	private Integer stationCount;
	public Long getBeginStationId() {
		return beginStationId;
	}
	public void setBeginStationId(Long beginStationId) {
		this.beginStationId = beginStationId;
	}
	public Long getBeginMarker() {
		return beginMarker;
	}
	public void setBeginMarker(Long beginMarker) {
		this.beginMarker = beginMarker;
	}
	public Long getEndStationId() {
		return endStationId;
	}
	public void setEndStationId(Long endStationId) {
		this.endStationId = endStationId;
	}
	public Long getEndMarker() {
		return endMarker;
	}
	public void setEndMarker(Long endMarker) {
		this.endMarker = endMarker;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Integer getStationCount() {
		return stationCount;
	}
	public void setStationCount(Integer stationCount) {
		this.stationCount = stationCount;
	}
	public String getBeginStationName() {
		return beginStationName;
	}
	public void setBeginStationName(String beginStationName) {
		this.beginStationName = beginStationName;
	}
	public String getEndStationName() {
		return endStationName;
	}
	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
}
