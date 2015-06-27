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

<title>My JSP 'routeStationManage.jsp' starting page</title>

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
	<h3>
		<s:property value="#route.routeName" /> &nbsp;&nbsp;&nbsp;
		<s:a action="#routeStationAction_addUI?routeId=%{route.routeId}">添加站点</s:a>
	</h3>
	<table border="1">
		<tr>
			<th>站点名</th>
			<th>marker</th>
			<th>操作</th>
		</tr>
		<s:iterator value="#route.routeStations">
			<tr>
				<td>${station.stationName }</td>
				<td>${marker }</td>
				<td>
					<s:if test="marker == 1">
						上移
					</s:if>
					<s:else>
						<s:a
						action="routeStationAction_up?routeId=%{route.routeId}
						&marker=%{marker}">上移</s:a>
					</s:else>
					<s:a
						action="routeStationAction_down?routeId=%{route.routeId}
						&marker=%{marker}">下移</s:a>
					<s:a action="routeStationAction_delete?routeId=%{route.routeId}
						&marker=%{marker}">删除</s:a></td>
			</tr>
		</s:iterator>
	</table>
	<s:debug></s:debug>
</body>
</html>