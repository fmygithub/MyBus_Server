package com.yang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.DirectRouteView;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;
import com.yang.util.MapPackage;

@Controller(value = "directRouteCheckAction")
@Scope("prototype")
public class DirectRouteCheckAction extends BaseAction<DirectRouteView> {
	private static final long serialVersionUID = 1L;

	// http请求和响应
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// 要传输的json对象
	JSONObject json = new JSONObject();

	/**
	 * 
	 * @Description: 准备查询界面的数据
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-18
	 */
	public String checkUI() {
		List<Station> stationList = stationService.findAll();
		ActionContext.getContext().put("stationList", stationList);
		return "checkUI";
	}

	/**
	 * 
	 * @Description: 根据始末站点查询路线
	 * @param @return
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-18
	 */
	public String check1() throws Exception {
		System.out.println("进入check方法！");
		System.out.println("beginStationId:"
				+ model.getId().getBeginStationId());

		// 保存所有直达路线和该路线所有的站点
		Map<DirectRouteView, List<RouteStation>> dlMap = new HashMap<DirectRouteView, List<RouteStation>>();

		// 查询直达路线
		List<DirectRouteView> drList = routeCheckService.checkDirectRoute(model
				.getId().getBeginStationName(), model
				.getId().getEndStationName());
		// 遍历所有直达路线
		for (DirectRouteView dr : drList) {
			long routeId = dr.getId().getRouteId();
			long beginMarker = dr.getId().getBeginMarker();
			long endMarker = dr.getId().getEndMarker();

			// System.out.println("beginMarker:"+beginMarker);
			// 获取经过的所有站点
			List<RouteStation> rsList = routeStationService.findByRouteAndMarker(
					routeId, beginMarker, endMarker);
			System.out.println(rsList.get(0).getStation().getStationName());
			dlMap.put(dr, rsList);
		}
		// 传递map的长度
		ActionContext.getContext().put("routeSize", dlMap.size());
		// 传输直达路线
		ActionContext.getContext().put("dlMap", dlMap);
		return "check";
	}

	public String check() throws Exception {

		List<MapPackage> mapList = new ArrayList<MapPackage>();

		// 查询直达路线
		List<DirectRouteView> drList = routeCheckService.checkDirectRoute(model
				.getId().getBeginStationName(), model
				.getId().getEndStationName());

		// 遍历所有直达路线
		for (DirectRouteView dr : drList) {
			long routeId = dr.getId().getRouteId();
			long beginMarker = dr.getId().getBeginMarker();
			long endMarker = dr.getId().getEndMarker();

			// System.out.println("beginMarker:"+beginMarker);
			// 获取经过的所有站点
			List<RouteStation> rsList = routeStationService.findByRouteAndMarker(
					routeId, beginMarker, endMarker);
			
			List<Station> stationList = new ArrayList<Station>();
			// 过滤
			for (RouteStation rs : rsList) {
				if (rs.getStation().getRouteStations() != null) {
					rs.getStation().setRouteStations(null);
				}
				stationList.add(rs.getStation());
			}
			MapPackage tempMap = new MapPackage();
			tempMap.setKey(dr);
			tempMap.setValue(stationList);
			mapList.add(tempMap);
		}
		System.out.println("mapList.size" + mapList.size());
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray temp = JSONArray.fromObject(mapList, config);
		json.put("json", temp);
		response.setCharacterEncoding("utf-8");
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
		return null;
	}

}
