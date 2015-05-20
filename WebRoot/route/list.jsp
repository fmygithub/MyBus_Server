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
  <h1>路线列表页&nbsp;&nbsp;&nbsp;<s:a action="routeAction_addUI.action">添加路线</s:a></h1>
    <table border="1">
    	<tr>
    		<td>路线id</td>
    		<td>路线名</td>
    		<td>站点</td>
    		<td>操作</td>
    	</tr>
    	<s:iterator value="routeList">
    		<tr>
    			<td>${routeId }</td>
    			<td>${routeName }</td>
    			<td>[
    				<s:iterator value="routeStations">
    					${station.stationName },
    				</s:iterator>
    				]
    			</td>
    			<td><s:a action="routeAction_delete?routeId=%{routeId}">删除</s:a></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
