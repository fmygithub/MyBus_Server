package com.yang.entity;

/**
 * 
 * ClassName: Position
 * @Description: 站点位置信息
 * @author: fengmengyang
 * @date: 2015-5-15
 */
public class Position {
	private int positionId;
	/**
	 * x轴坐标值
	 */
	private String axis_x;
	/**
	 * y轴坐标值
	 */
	private String axis_y;
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getAxis_x() {
		return axis_x;
	}
	public void setAxis_x(String axis_x) {
		this.axis_x = axis_x;
	}
	public String getAxis_y() {
		return axis_y;
	}
	public void setAxis_y(String axis_y) {
		this.axis_y = axis_y;
	}
	
	
	
}
