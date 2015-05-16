package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.Route;
import com.yang.service.RouteService;

@Service
public class RouteServcieImpl extends BaseDaoImpl<Route> implements RouteService{

	@Override
	public Route findRouteByName(String routeName) {
		String sql = "from Route route where route.routeName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, routeName);
		@SuppressWarnings("unchecked")
		List<Route> routeList = query.list();
		if(routeList.size() != 0) {
			return routeList.get(0);
		}
		return null;
	}

}
