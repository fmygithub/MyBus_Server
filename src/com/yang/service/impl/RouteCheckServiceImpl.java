package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.DirectRouteView;
import com.yang.service.RouteCheckService;

@Service
public class RouteCheckServiceImpl extends BaseDaoImpl<DirectRouteView>
		implements RouteCheckService {

	@Override
	public List<DirectRouteView> checkRoute(Long beginStationId, Long endStationId) {
		String sql = "from DirectRouteView dr "
				+ "where dr.directRouteViewId.beginStationId = ? "
				+ "and dr.directRouteViewId.endStationId = ?";
		Query query = getSession().createQuery(sql);
		query.setLong(0, beginStationId);
		query.setLong(1, endStationId);
		@SuppressWarnings("unchecked")
		List<DirectRouteView> drList = query.list();
		if (drList.size() != 0){
			return drList;
		}
		return null;
	}
}
