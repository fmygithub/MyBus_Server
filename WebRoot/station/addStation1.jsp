<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addStation.jsp' starting page</title>

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
	<h1>添加站点页面 &nbsp; &nbsp; &nbsp;<s:a action="stationAction_list">查看站点列表</s:a></h1>
	<form action="stationAction_add.action" method="post">
		请输入站点名:<input type="text" name="stationName" />
		<br>
		请选择所属路线:
		<s:select name="routeId" list="#routeList" size="1"
			headerValue="请选择路线" headerKey="" listKey="routeId"
			listValue="routeName" /> 
		<br>
		站点在路线中的位置：<input type="text" name="marker"/>
		<br>
		请输入站点位置：
		x轴：<input type="text" name="axis_x"/>&nbsp;
		y轴：<input type="text" name="axis_y"/> &nbsp;
		<br>
		<input type="submit" value="添加" />
	</form>
	<br>
	
</body>
</html>
