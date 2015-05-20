package com.yang.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.Route;
import com.yang.entity.RouteStation;
import com.yang.entity.Station;

@Controller(value="routeAction")
@Scope("prototype")
public class RouteAction extends BaseAction<Route>{
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long[] stationIds;
	
	public Long[] getStationIds() {
		return stationIds;
	}

	public void setStationIds(Long[] stationIds) {
		this.stationIds = stationIds;
	}

	public String addUI() {
		List<Station> stationList = stationService.findAll();
		ActionContext.getContext().put("stationList", stationList);
		return "add";
	}
	
	public String add() {
		//校验是否重复添加
		Route route = routeService.findRouteByName(model.getRouteName());
		if (route == null) {
			try {
				List<RouteStation> rsList = new ArrayList<RouteStation>();
				List<Station> stationList = stationService.findByIds(stationIds);
				for (Station station : stationList){
					RouteStation rs = new RouteStation();
					rs.setRoute(model);
					rs.setStation(station);
					rsList.add(rs);
				}
				model.setRouteStations(new HashSet<RouteStation>(rsList));
				routeService.save(model);
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "该路线已存在！");
		}
		return "toList";
	}
	
	public String list() {
		List<Route> routeList = routeService.findAll();
		ActionContext.getContext().put("routeList", routeList);
		return "list";
	}
	
	public String delete() {
		routeService.delete(model.getRouteId());
		return "toList";
	}
}
