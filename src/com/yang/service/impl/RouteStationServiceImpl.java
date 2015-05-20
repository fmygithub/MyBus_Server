package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.RouteStation;
import com.yang.service.RouteStationService;

@Service
public class RouteStationServiceImpl extends BaseDaoImpl<RouteStation> implements RouteStationService{

	@Override
	public List<RouteStation> findByRouteAndMarker(Long routeId, Long beginMarker,
			Long endMarker) {
		String sql = "from RouteStation rs where rs.route.routeId = ? and rs.marker <= ? and rs.marker >= ?";
		Query query = getSession().createQuery(sql);
		query.setLong(0, routeId);
		query.setLong(1, endMarker);
		query.setLong(2, beginMarker);
		@SuppressWarnings("unchecked")
		List<RouteStation> rsList = query.list();
		if (rsList.size() != 0) {
			return rsList;
		}
		return null;
	}
	
}
