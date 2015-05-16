<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="./user/addUser.jsp">添加用户</a>
    <table border="1">
    	<tr>
    		<td>用户id</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>操作</td>
   		</tr>
   		<s:iterator value="#userList">
   			<tr>
   				<td>${userId}</td>
   				<td>${userName }</td>
   				<td>${password }</td>
   				<td><s:a action="userAction_delete?userId=%{userId}">删除</s:a></td>
   			</tr>
   		</s:iterator>
    </table>
  </body>
</html>
