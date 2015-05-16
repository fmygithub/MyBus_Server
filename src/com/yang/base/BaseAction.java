package com.yang.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yang.service.RouteService;
import com.yang.service.UserService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	protected UserService userService;
	@Resource
	protected RouteService routeService;

	protected T model;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			// 得到model的类型信�?
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<?> clazz = (Class<?>) pt.getActualTypeArguments()[0];

			// 通过反射生成model的实�?
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
}