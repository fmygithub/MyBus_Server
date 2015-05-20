package com.yang.service;

import java.util.List;

import com.yang.base.BaseDao;
import com.yang.entity.RouteStation;

public interface RouteStationService extends BaseDao<RouteStation>{
	public List<RouteStation> findByRouteAndMarker(Long routeId, Long beginMarker, Long endMarker); 
}
