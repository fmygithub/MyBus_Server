package com.yang.action;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.Route;

@Controller(value="routeAction")
@Scope("prototype")
public class RouteAction extends BaseAction<Route>{
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;

	public String add() {
		//校验是否重复添加
		Route route = routeService.findRouteByName(model.getRouteName());
		if (route == null) {
			try {
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
