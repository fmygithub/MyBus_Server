package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.DirectRouteView;
import com.yang.entity.OneTranferRouteView;
import com.yang.entity.TwoTranferRouteView;
import com.yang.service.RouteQueryService;

@Service
public class RouteQueryServiceImpl extends BaseDaoImpl<DirectRouteView>
		implements RouteQueryService {

	@Override
	public List<DirectRouteView> checkDirectRoute(String beginStationName, String endStationName) {
		String sql = "from DirectRouteView dr "
				+ "where dr.id.beginStationName = ? "
				+ "and dr.id.endStationName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, beginStationName);
		query.setString(1, endStationName);
		@SuppressWarnings("unchecked")
		List<DirectRouteView> drList = query.list();
		if (drList.size() != 0){
			return drList;
		}
		return null;
	}

	@Override
	public List<OneTranferRouteView> checkOneChangeRoute(String beginStationName,
			String endStationName) {
		String sql = "from OneTranferRouteView otr "
				+ "where otr.id.beginStationName = ? "
				+ "and otr.id.endStationName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, beginStationName);
		query.setString(1, endStationName);
		query.setFirstResult(0);  
    query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<OneTranferRouteView> orList = query.list();
		if (orList.size() != 0){
			return orList;
		}
		return null;
	}
	@Override
	public List<TwoTranferRouteView> checkTwoChangeRoute(String beginStationName,
			String endStationName) {
		String sql = "from TwoTranferRouteView otr "
				+ "where otr.id.beginStationName = ? "
				+ "and otr.id.endStationName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, beginStationName);
		query.setString(1, endStationName);
		query.setFirstResult(0);  
    query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<TwoTranferRouteView> orList = query.list();
		if (orList.size() != 0){
			return orList;
		}
		return null;
	}
}
