package com.yang.service;

import com.yang.base.BaseDao;
import com.yang.entity.Station;

public interface StationService extends BaseDao<Station>{
	/**
	 * 
	 * @Description: 通过站点名查找站点实体
	 * @param stationName
	 * @return Station
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-17
	 */
	public Station findStationByName(String stationName);
}
