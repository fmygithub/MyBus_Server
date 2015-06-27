package com.yang.entity;

import java.io.Serializable;

/**
 * 
 * ClassName: TwoTranferRouteView
 * @Description: 两次换乘
 * @author: fengmengyang
 * @date: 2015-6-25
 */
public class TwoTranferRouteView implements Serializable{
	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	private TwoTranferRouteViewId id;

	public TwoTranferRouteViewId getId() {
		return id;
	}

	public void setId(TwoTranferRouteViewId id) {
		this.id = id;
	}
	
}
