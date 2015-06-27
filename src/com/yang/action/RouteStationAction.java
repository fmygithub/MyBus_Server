package com.yang.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.RouteStation;

@Controller(value = "routeStationAction")
@Scope("prototype")
public class RouteStationAction extends BaseAction<RouteStation> {
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long routeId;
	private Long stationId;
	
	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	/**
	 * 
	 * @Description: 上移动作
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public String up() {
		Long marker = model.getMarker();
		RouteStation rs1 = routeStationService.findByMarker(routeId, marker);
		RouteStation rs2 = routeStationService.findByMarker(routeId, marker-1);
		if (rs2 != null) {
			rs2.setMarker(marker);
			routeStationService.update(rs2);
		}
		rs1.setMarker(marker-1);
		routeStationService.update(rs1);
		
		ActionContext.getContext().getSession().put("routeId", routeId);
		return "toRouteStationManage";
	}
	/**
	 * 
	 * @Description: 下移动作
	 * @param @return
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public String down() {
		Long marker = model.getMarker();
		RouteStation rs1 = routeStationService.findByMarker(routeId, marker);
		RouteStation rs2 = routeStationService.findByMarker(routeId, marker+1);
		if (rs2 != null) {
			rs2.setMarker(marker);
			routeStationService.update(rs2);
		}
		rs1.setMarker(marker+1);
		routeStationService.update(rs1);
		
		ActionContext.getContext().getSession().put("routeId", routeId);
		return "toRouteStationManage";
	}
	/**
	 * 
	 * @Description: 删除动作
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public String delete() {
		Long marker = model.getMarker();
		routeStationService.deleteByMarker(routeId,marker);
		return "toRouteStationManage";
	}
	/**
	 * 
	 * @Description: 为路线添加站点
	 * @param @return
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-6-19
	 */
	public String addUI() {
		return null;
	}
}
