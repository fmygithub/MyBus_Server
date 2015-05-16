package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yang.base.BaseAction;
import com.yang.entity.User;

@Controller(value="userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	/**
	 * @Fields serialVersionUID: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	JSONObject temp = new JSONObject();
	JSONObject json = new JSONObject();

	
	
	public String add() {
		//添加之前先校验
		User user = userService.findUserByName(model.getUserName());
		if (user == null) {
			try {
				userService.save(model);
				return "toList";
			} catch (Exception e) {
				//有异常就表示保存失败
				e.getStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "该用户名已存在！");
		}
		return "add";
	}
	
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String delete() throws Exception {
		userService.delete(model.getUserId());
		return "toList";
	}
	
	/**
	 * 
	 * @Description: 登陆相关方法
	 * @return String
	 * @throws
	 * @author: fengmengyang
	 * @date: 2015-5-15
	 */
	public String login() {
		System.out.println(model.getUserName());
		User user = userService.findUserByName(model.getUserName());
		if (user != null) {
			if (user.getPassword().equals(model.getPassword())){
				JOptionPane.showMessageDialog(null, "登陆成功！");
			} else {
				JOptionPane.showMessageDialog(null, "密码不正确!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "用户不存在！");
		}
		return null;
	}
}
