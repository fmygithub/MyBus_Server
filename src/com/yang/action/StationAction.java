package com.yang.action;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.Station;

@Controller(value="stationAction")
@Scope("prototype")
public class StationAction extends BaseAction<Station>{

	/**
	 * @Fields serialVersionUID: 
	 */
	private static final long serialVersionUID = 1L;

	public String add() {
		System.out.println("进入add方法");
		//先检查站点是否重复添加
		Station station = stationService.findStationByName(model.getStationName());
		if (station != null) {
			JOptionPane.showMessageDialog(null, "该站点已添加！");
		} else {
			stationService.save(model);
		}
		ActionContext.getContext().put("station", model);
		return "add";
	}
	
	public String list() {
		System.out.println("进入list方法");
		List<Station> stationList = stationService.findAll();
		ActionContext.getContext().put("stationList", stationList);
		return "list";
	}
	
	public String delete() {
		stationService.delete(model.getStationId());
		return "toList";
	}
	
	public String findStationByName() {
		Station station = stationService.findStationByName(model.getStationName());
		ActionContext.getContext().put("station", station);
		return "add";
	}
}
