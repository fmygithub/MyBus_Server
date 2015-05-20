package com.yang.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.yang.base.BaseDaoImpl;
import com.yang.entity.Station;
import com.yang.service.StationService;

@Service
public class StationServiceImpl extends BaseDaoImpl<Station> implements StationService{

	@Override
	public Station findStationByName(String stationName) {
		String sql = "from Station station where station.stationName = ?";
		Query query = getSession().createQuery(sql);
		query.setString(0, stationName);
		@SuppressWarnings("unchecked")
		List<Station> stationList = query.list();
		if (stationList.size() != 0) {
			return stationList.get(0);
		}
		return null;
	}


}
