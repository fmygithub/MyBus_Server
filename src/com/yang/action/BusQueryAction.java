package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.base.BaseAction;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;

@Controller(value = "busQueryAction")
@Scope("prototype")
public class BusQueryAction extends BaseAction<RouteStation> {

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
		List<Station> stationList = routeStationService
				.findStationsByRouteName(model.getRoute().getRouteName());
		if (stationList != null) {
			for (Station station : stationList) {
				if (station.getRouteStations() != null) {
					station.setRouteStations(null);
				}
			}
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray temp = JSONArray.fromObject(stationList, config);
		/*if (temp.size() == 1 && temp.get(0).toString().equals("null")) {
			System.out.println(temp.get(0).toString());
		}*/
		json.put("json", temp);
		response.setCharacterEncoding("utf-8");
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
		return null;
	}

}
