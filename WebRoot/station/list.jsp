<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <h1>站点列表页&nbsp;&nbsp;&nbsp;&nbsp;<s:a href="./station/addStation.jsp">添加站点</s:a></h1>
    <table border="1">
		<tr>
			<td>站点id</td>
			<td>站点名</td>
			<td>位置坐标</td>
			<td>操作</td>
		</tr>
		<s:iterator value="#stationList">
			<tr>
				<td>${stationId }</td>
				<td>${stationName }</td>
				<td>[${axis_x },${axis_y }]</td>
				<td><s:a action="stationAction_delete?stationId=%{stationId}">删除</s:a></td>
		</s:iterator>
	</table>
		<s:debug></s:debug>
  </body>
</html>
