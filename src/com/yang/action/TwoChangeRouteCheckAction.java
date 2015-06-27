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

import com.yang.base.BaseAction;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;
import com.yang.entity.TwoTranferRouteView;
import com.yang.util.MapPackage;

@Controller(value = "twoChangeRouteCheckAction")
@Scope("prototype")
public class TwoChangeRouteCheckAction extends BaseAction<TwoTranferRouteView> {
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;

	// http请求和响应
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// 要传输的json对象
	JSONObject json = new JSONObject();

	public String check() throws Exception {
		System.out.println("起始站点：" + model.getId().getBeginStationName());
		System.out.println("目标站点：" + model.getId().getEndStationName());
		List<MapPackage> mapList = new ArrayList<MapPackage>();

		// 查询一次换乘路线
		List<TwoTranferRouteView> twoChangeList = routeCheckService
				.checkTwoChangeRoute(model.getId().getBeginStationName(), model.getId()
						.getEndStationName());
		System.out.println("两次换乘路线数:"+twoChangeList.size());
		// 遍历所有换乘路线
		for (TwoTranferRouteView or : twoChangeList) {
			long routeId1 = or.getId().getRouteId1();
			String routeName1 = or.getId().getRouteName1();
			long routeId2 = or.getId().getRouteId2();
			String routeName2 = or.getId().getRouteName2();
			long routeId3 = or.getId().getRouteId3();
			String routeName3 = or.getId().getRouteName3();
			long beginMarker = or.getId().getBeginMarker();
			long changeMarker11 = or.getId().getTranferMarker11();
			long changeMarker12 = or.getId().getTranferMarker12();
			long changeMarker22 = or.getId().getTranferMarker22();
			long changeMarker23 = or.getId().getTranferMarker23();
			
			long endMarker = or.getId().getEndMarker();

			// 获取经过的所有站点
			List<RouteStation> rsList1 = routeStationService.findByRouteAndMarker(
					routeId1, beginMarker, changeMarker11);
			List<RouteStation> rsList2 = routeStationService1.findByRouteAndMarker(
					routeId2, changeMarker12, changeMarker22);
			List<RouteStation> rsList3 = routeStationService2.findByRouteAndMarker(
					routeId3, changeMarker23, endMarker);
			
			Map<String,List<Station>> routeStationsMap = new HashMap<String,List<Station>>();
			// 过滤
			List<Station> stationList1 = new ArrayList<Station>();
			for (RouteStation rs : rsList1) {
				if (rs.getStation().getRouteStations() != null) {
					rs.getStation().setRouteStations(null);
				}
				stationList1.add(rs.getStation());
			}
			routeStationsMap.put(routeName1, stationList1);
			
			List<Station> stationList2 = new ArrayList<Station>();
			for (RouteStation rs : rsList2) {
				if (rs.getStation().getRouteStations() != null) {
					rs.getStation().setRouteStations(null);
				}
				stationList2.add(rs.getStation());
			}
			routeStationsMap.put(routeName2, stationList2);
			
			List<Station> stationList3 = new ArrayList<Station>();
			for (RouteStation rs : rsList3) {
				if (rs.getStation().getRouteStations() != null) {
					rs.getStation().setRouteStations(null);
				}
				stationList3.add(rs.getStation());
			}
			routeStationsMap.put(routeName3, stationList3);
			
			MapPackage tempMap = new MapPackage();
			tempMap.setKey(or);
			tempMap.setValue(routeStationsMap);
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
