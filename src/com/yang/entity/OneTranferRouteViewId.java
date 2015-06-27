package com.yang.entity;

import java.io.Serializable;

public class OneTranferRouteViewId implements Serializable{

	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 起始站点
	 */
	private Long beginStationId;
	private String beginStationName;
	/**
	 * 起始站点在换乘路线1中的位置
	 */
	private Long beginMarker;
	/**
	 * 换乘路线1
	 */
	private Long routeId1;
	private String routeName1;
	private Integer stationCount1;
	/**
	 * 换乘站点
	 */
	private Long tranferStationId;
	private String tranferStationName;
	/**
	 * 换乘站点在路线1中的位置
	 */
	private Long tranferMarker;
	/**
	 * 换乘站点在路线2中的位置
	 */
	private Long tranferMarker1;
	/**
	 * 换乘路线2
	 */
	private Long routeId2;
	private String routeName2;
	private Integer stationCount2;
	/**
	 * 目标站点
	 */
	private Long endStationId;
	private String endStationName;
	/**
	 * 目标站点在路线2中的位置
	 */
	private Long endMarker;
	/**
	 * 从起点到终点的所经过的站点数
	 */
	private Integer staionCount;
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
	public Long getRouteId1() {
		return routeId1;
	}
	public void setRouteId1(Long routeId1) {
		this.routeId1 = routeId1;
	}
	public Long getTranferStationId() {
		return tranferStationId;
	}
	public void setTranferStationId(Long tranferStationId) {
		this.tranferStationId = tranferStationId;
	}
	public Long getTranferMarker() {
		return tranferMarker;
	}
	public void setTranferMarker(Long tranferMarker) {
		this.tranferMarker = tranferMarker;
	}
	public Long getRouteId2() {
		return routeId2;
	}
	public void setRouteId2(Long routeId2) {
		this.routeId2 = routeId2;
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
	public Integer getStaionCount() {
		return staionCount;
	}
	public void setStaionCount(Integer staionCount) {
		this.staionCount = staionCount;
	}
	public String getBeginStationName() {
		return beginStationName;
	}
	public void setBeginStationName(String beginStationName) {
		this.beginStationName = beginStationName;
	}
	public Integer getStationCount1() {
		return stationCount1;
	}
	public void setStationCount1(Integer stationCount1) {
		this.stationCount1 = stationCount1;
	}
	public String getTranferStationName() {
		return tranferStationName;
	}
	public void setTranferStationName(String tranferStationName) {
		this.tranferStationName = tranferStationName;
	}
	public Integer getStationCount2() {
		return stationCount2;
	}
	public void setStationCount2(Integer stationCount2) {
		this.stationCount2 = stationCount2;
	}
	public String getEndStationName() {
		return endStationName;
	}
	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}
	public String getRouteName1() {
		return routeName1;
	}
	public void setRouteName1(String routeName1) {
		this.routeName1 = routeName1;
	}
	public String getRouteName2() {
		return routeName2;
	}
	public void setRouteName2(String routeName2) {
		this.routeName2 = routeName2;
	}
	public Long getTranferMarker1() {
		return tranferMarker1;
	}
	public void setTranferMarker1(Long tranferMarker1) {
		this.tranferMarker1 = tranferMarker1;
	}
	
}
