<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
    <form action="busQueryAction_check.action" method="post">
    	请输入路线名：<input type="text" name="route.routeName"/>
    	<input type="submit" value="查询"/>
    </form>
    <br>
    <form action="stationQueryAction_check.action" method="post">
    	请输入站点名：<input type="text" name="station.stationName"/>
    	<input type="submit" value="查询"/>
    </form>
    <br>
    
    <form action="directRouteCheckAction_check.action" method="post">
    	请输入起始站点名：<input type="text" name="id.beginStationName"/>
    	请输入起始站点名：<input type="text" name="id.endStationName"/>
    	<input type="submit" value="查询直达路线"/>
    </form>
    <br>
    
    <form action="oneChangeRouteCheckAction_check.action" method="post">
    	请输入起始站点名：<input type="text" name="id.beginStationName"/>
    	请输入起始站点名：<input type="text" name="id.endStationName"/>
    	<input type="submit" value="查询换乘一次路线"/>
    </form>
    <br>
    
  </body>
</html>
