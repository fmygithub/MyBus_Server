package com.yang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.Route;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;
import com.yang.service.RouteStationService;

@Service
public class RouteStationServiceImpl extends BaseDaoImpl<RouteStation> implements RouteStationService{

	@Override
	public List<RouteStation> findByRouteAndMarker(Long routeId, Long beginMarker,
			Long endMarker) {
		String sql = "from RouteStation rs where rs.route.routeId = ? and rs.marker <= ? and rs.marker >= ? order by rs.marker asc";
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

	@Override
	public List<Station> findStationsByRouteName(String routeName) {
		String sql = "from RouteStation rs where rs.route.routeName = ? order by rs.marker asc";
		Query query = getSession().createQuery(sql);
		query.setString(0, routeName);
		@SuppressWarnings("unchecked")
		List<RouteStation> rsList = query.list();
		List<Station> stationList = new ArrayList<Station>();
		if (rsList.size() != 0) {
			for (RouteStation rs : rsList	) {
				stationList.add(rs.getStation());
			}
			return stationList;
		}
		return null;
	}

	@Override
	public List<Route> findRoutesByStationName(String stationName) {
		String sql = "from RouteStation rs where rs.station.stationName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, stationName);
		@SuppressWarnings("unchecked")
		List<RouteStation> rsList = query.list();
		List<Route> routeList = new ArrayList<Route>();
		if (rsList.size() != 0) {
			for (RouteStation rs : rsList	) {
				routeList.add(rs.getRoute());
			}
			return routeList;
		}
		return null;
	}

	@Override
	public RouteStation findByMarker(Long routeId, Long marker) {
		System.out.println(routeId+"  "+marker);
		//获取该路线上一个站点的id
		String sql = "from RouteStation rs where rs.route.routeId = ? and rs.marker = ?";
		Query query = getSession().createQuery(sql);
		query.setLong(0, routeId);
		query.setLong(1, marker);
		RouteStation rs = (RouteStation) query.uniqueResult();
		return rs;
	}

	@Override
	public void deleteByMarker(Long routeId, Long marker) {
		String sql = "delete RouteStation rs where rs.route.routeId = ? and rs.marker = ?";
		Query query = getSession().createQuery(sql);
		query.setLong(0, routeId);
		query.setLong(1, marker);
		query.executeUpdate();
	}
	
}
