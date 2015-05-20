
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>百度地图</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
<!-- <script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=CBYFZnaUOeHv0ZllEFT9CEuc"></script> -->
<script type="text/javascript"
	src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
	height: 100%
}
</style>
</head>
<body>
	<%-- <h1><s:a action="routeCheckAction_checkUI.action">查询页面</s:a></h1> --%>
	<!-- 保存map的长度 -->
	<input id="mapSize" type="hidden" value="${routeSize }" />
	<s:iterator value="dlMap" status="dl">
		<input id="stationCount<s:property value='#dl.index'/>" type="hidden"
			value="<s:property value='key.directRouteViewId.stationCount'/>" />
		<s:iterator value="value" status="rs">
			<input
				id="stationName<s:property value='#dl.index'/><s:property value='#rs.index'/>"
				type="hidden" value="${station.stationName }" />
			<input
				id="axis_x<s:property value='#dl.index'/><s:property value='#rs.index'/>"
				type="hidden" value="${station.axis_x }" />
			<input
				id="axis_y<s:property value='#dl.index'/><s:property value='#rs.index'/>"
				type="hidden" value="${station.axis_y }" />
		</s:iterator>
	</s:iterator>
	<%-- <input id="stationCount" type="hidden"
		value="${dr.directRouteViewId.stationCount }" />
	<s:iterator value="rsList" status="rs">
		<input id="stationName<s:property value='#rs.index'/>" type="hidden"
			value="${station.stationName }" />
		<input id="axis_x<s:property value='#rs.index'/>" type="hidden"
			value="${station.axis_x }" />
		<input id="axis_y<s:property value='#rs.index'/>" type="hidden"
			value="${station.axis_y }" />
	</s:iterator> --%>
	<div id="container"></div>
</body>
</html>
<script type="text/javascript">
	var map = new BMap.Map("container"); // 创建地图实例  
	map.addControl(new BMap.NavigationControl()); //添加平移缩放控件  
	map.addControl(new BMap.ScaleControl()); //添加放大、缩小控件  
	map.enableScrollWheelZoom();//允许鼠标滑轮操作  

	//获取所有的路线数
	var routeCount = document.getElementById("mapSize").value;
	//保存路线中的所有站点数组
	var routeStationArray = new Array();
	for ( var j = 0; j < routeCount; j++) {
		var stationArray = new Array();
		// 获取路线中的站点数
		var stationCount = document.getElementById("stationCount" + j).value;
		for ( var i = 0; i <= stationCount; i++) {
			var stationName = document.getElementById("stationName" + j + i).value;
			var axis_x = document.getElementById("axis_x" + j + i).value;
			var axis_y = document.getElementById("axis_y" + j + i).value;
			var point = new BMap.Point(axis_x, axis_y); // 创建点坐标  
			stationArray[i] = point;
			//alert(stationArray.length);
			map.centerAndZoom(point, 15); // 初始化地图，设置中心点坐标和地图级别  

			var marker = new BMap.Marker(point); // 创建标注
			map.addOverlay(marker); // 将标注添加到地图中

			// 创建站点信息覆盖标签
			var label = new BMap.Label(stationName, {
				offset : new BMap.Size(20, -10)
			});
			marker.setLabel(label);
		}
		
		routeStationArray[j] = stationArray;
		
		var beginStation = document.getElementById("stationName" + j + "0").value;
		var endStation = document.getElementById("stationName" + j
				+ stationCount).value;
		var opts = {
			width : 50, // 信息窗口宽度    
			height : 20, // 信息窗口高度    
			title : "从" + beginStation + "到" + endStation
		// 信息窗口标题   
		};
		var infoWindow = new BMap.InfoWindow("共" + stationCount + "站", opts); // 创建信息窗口对象    
		map.openInfoWindow(infoWindow, map.getCenter()); // 打开信息窗口
	}

	//绘制路线弧线
	for ( var i = 0; i < routeCount; i++) {
		var curve = new BMapLib.CurveLine(routeStationArray[i], {
			strokeColor : "blue",
			strokeWeight : 3,
			strokeOpacity : 0.5
		}); //创建弧线对象
		map.addOverlay(curve); //添加到地图中
	}
	//curve.enableEditing(); //开启编辑功能
</script>
