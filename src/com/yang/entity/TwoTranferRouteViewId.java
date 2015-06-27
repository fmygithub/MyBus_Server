package com.yang.entity;

import java.io.Serializable;

public class TwoTranferRouteViewId implements Serializable{

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
	 * 换乘站点1
	 */
	private Long tranferStationId1;
	private String tranferStationName1;
	/**
	 * 换乘站点在路线1中的位置
	 */
	private Long tranferMarker11;
	/**
	 * 换乘站点在路线2中的位置
	 */
	private Long tranferMarker12;
	/**
	 * 换乘路线2
	 */
	private Long routeId2;
	private String routeName2;
	private Integer stationCount2;
	/**
	 * 换乘站点2
	 */
	private Long tranferStationId2;
	private String tranferStationName2;
	/**
	 * 换乘站点在路线2中的位置
	 */
	private Long tranferMarker22;
	/**
	 * 换乘站点在路线3中的位置
	 */
	private Long tranferMarker23;
	/**
	 * 换乘路线3
	 */
	private Long routeId3;
	private String routeName3;
	private Integer stationCount3;
	/**
	 * 目标站点
	 */
	private Long endStationId;
	private String endStationName;
	/**
	 * 目标站点在路线2中的位置
	 */
	private Long endMarker;
	public Long getBeginStationId() {
		return beginStationId;
	}
	public void setBeginStationId(Long beginStationId) {
		this.beginStationId = beginStationId;
	}
	public String getBeginStationName() {
		return beginStationName;
	}
	public void setBeginStationName(String beginStationName) {
		this.beginStationName = beginStationName;
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
	public String getRouteName1() {
		return routeName1;
	}
	public void setRouteName1(String routeName1) {
		this.routeName1 = routeName1;
	}
	public Integer getStationCount1() {
		return stationCount1;
	}
	public void setStationCount1(Integer stationCount1) {
		this.stationCount1 = stationCount1;
	}
	public Long getTranferStationId1() {
		return tranferStationId1;
	}
	public void setTranferStationId1(Long tranferStationId1) {
		this.tranferStationId1 = tranferStationId1;
	}
	public String getTranferStationName1() {
		return tranferStationName1;
	}
	public void setTranferStationName1(String tranferStationName1) {
		this.tranferStationName1 = tranferStationName1;
	}
	public Long getRouteId2() {
		return routeId2;
	}
	public void setRouteId2(Long routeId2) {
		this.routeId2 = routeId2;
	}
	public String getRouteName2() {
		return routeName2;
	}
	public void setRouteName2(String routeName2) {
		this.routeName2 = routeName2;
	}
	public Integer getStationCount2() {
		return stationCount2;
	}
	public void setStationCount2(Integer stationCount2) {
		this.stationCount2 = stationCount2;
	}
	public Long getTranferStationId2() {
		return tranferStationId2;
	}
	public void setTranferStationId2(Long tranferStationId2) {
		this.tranferStationId2 = tranferStationId2;
	}
	public String getTranferStationName2() {
		return tranferStationName2;
	}
	public void setTranferStationName2(String tranferStationName2) {
		this.tranferStationName2 = tranferStationName2;
	}
	public Long getRouteId3() {
		return routeId3;
	}
	public void setRouteId3(Long routeId3) {
		this.routeId3 = routeId3;
	}
	public String getRouteName3() {
		return routeName3;
	}
	public void setRouteName3(String routeName3) {
		this.routeName3 = routeName3;
	}
	public Integer getStationCount3() {
		return stationCount3;
	}
	public void setStationCount3(Integer stationCount3) {
		this.stationCount3 = stationCount3;
	}
	public Long getEndStationId() {
		return endStationId;
	}
	public void setEndStationId(Long endStationId) {
		this.endStationId = endStationId;
	}
	public String getEndStationName() {
		return endStationName;
	}
	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}
	public Long getEndMarker() {
		return endMarker;
	}
	public void setEndMarker(Long endMarker) {
		this.endMarker = endMarker;
	}
	public Long getTranferMarker11() {
		return tranferMarker11;
	}
	public void setTranferMarker11(Long tranferMarker11) {
		this.tranferMarker11 = tranferMarker11;
	}
	public Long getTranferMarker12() {
		return tranferMarker12;
	}
	public void setTranferMarker12(Long tranferMarker12) {
		this.tranferMarker12 = tranferMarker12;
	}
	public Long getTranferMarker22() {
		return tranferMarker22;
	}
	public void setTranferMarker22(Long tranferMarker22) {
		this.tranferMarker22 = tranferMarker22;
	}
	public Long getTranferMarker23() {
		return tranferMarker23;
	}
	public void setTranferMarker23(Long tranferMarker23) {
		this.tranferMarker23 = tranferMarker23;
	}
	
	
}
