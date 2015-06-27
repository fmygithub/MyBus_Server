package com.yang.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.base.BaseAction;
import com.yang.entity.Route;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;
import com.yang.util.MapPackage;

@Controller(value = "stationQueryAction")
@Scope("prototype")
public class StationQueryAction extends BaseAction<RouteStation> {

	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;

	// http请求和响应
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// 要传输的json对象
	JSONObject json = new JSONObject();

	public String query() throws Exception {
		System.out.println("站点名：" + model.getStation().getStationName());
		List<Route> routeList = routeStationService.findRoutesByStationName(model
				.getStation().getStationName());
		Station station = stationService.findStationByName(model.getStation().getStationName());
		
		if (routeList != null) {
			for (Route route : routeList) {
				Set<RouteStation> routeStations = route.getRouteStations();
				if (routeStations != null) {
					route.setRouteStations(null);
				}
			}
		}
		if (station.getRouteStations() != null) {
			station.setRouteStations(null);
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		MapPackage map = new MapPackage();
		map.setKey(station);
		map.setValue(routeList);
		JSONObject temp = JSONObject.fromObject(map, config);
		System.out.println(temp.size());
		if (temp.size() == 0) {
			System.out.println(temp.get(0));
		}
		json.put("json", temp);
		response.setCharacterEncoding("utf-8");
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
		return null;
	}

}
