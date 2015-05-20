package com.yang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.DirectRouteView;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;

@Controller(value = "routeCheckAction")
@Scope("prototype")
public class RouteCheckAction extends BaseAction<DirectRouteView> {
	private static final long serialVersionUID = 1L;

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
	public String check() {
		System.out.println("进入check方法！");
		System.out.println("beginStationId:"
				+ model.getDirectRouteViewId().getBeginStationId());

		// 保存所有直达路线和该路线所有的站点
		Map<DirectRouteView, List<RouteStation>> dlMap = new HashMap<DirectRouteView, List<RouteStation>>();

		// 查询直达路线
		List<DirectRouteView> drList = routeCheckService.checkRoute(model
				.getDirectRouteViewId().getBeginStationId(), model
				.getDirectRouteViewId().getEndStationId());
		// 遍历所有直达路线
		for (DirectRouteView dr : drList) {
			long routeId = dr.getDirectRouteViewId().getRouteId();
			long beginMarker = dr.getDirectRouteViewId().getBeginMarker();
			long endMarker = dr.getDirectRouteViewId().getEndMarker();

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

}
