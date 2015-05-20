
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
	height: 90%
}
</style>
</head>
<body>
	<div style="height: 20">
		<!-- 站点添加 -->
		<div>
			<form action="stationAction_add.action" method="post">
				请输入站点名:<input type="text" name="stationName" />&nbsp; 经度：<input
					id="x" type="text" name="axis_x" />&nbsp; 纬度：<input id="y"
					type="text" name="axis_y" /> &nbsp; <input type="submit"
					value="添加" />
				<s:a action="stationAction_list.action">
					<span style="color: red">站点列表</span>
				</s:a>
			</form>
		</div>
		&nbsp;
		<div>
			<!-- 站点查询 -->
			<form action="./stationAction_findStationByName.action" method="post">
				请输入要查询的站点名:<input type="text" name="stationName" />&nbsp;&nbsp; <input
					type="submit" value="查询站点" />
			</form>
		</div>
	</div>
	<input id="stationName" type="hidden" value="${station.stationName }" />
	<input id="axis_x" type="hidden" value="${station.axis_x }" />
	<input id="axis_y" type="hidden" value="${station.axis_y }" />
	<div id="container"></div>
</body>
</html>
<script type="text/javascript">
	var map = new BMap.Map("container"); // 创建地图实例  
	map.addControl(new BMap.NavigationControl()); //添加平移缩放控件  
	map.addControl(new BMap.ScaleControl()); //添加放大、缩小控件  
	map.enableScrollWheelZoom();//允许鼠标滑轮操作  

	var stationName = document.getElementById("stationName").value;
	var axis_x = document.getElementById("axis_x").value;
	var axis_y = document.getElementById("axis_y").value;
	if (stationName == "" || axis_x == "" || axis_y == "") {
		axis_x = "117.10014642419";//经度  117.21081309,39.1439299
		axis_y = "39.100717287146";//纬度  
		var point = new BMap.Point(axis_x, axis_y); // 创建点坐标  
		map.centerAndZoom(point, 16); // 初始化地图，设置中心点坐标和地图级别  
	} else {
		var point = new BMap.Point(axis_x, axis_y); // 创建点坐标  
		map.centerAndZoom(point, 18); // 初始化地图，设置中心点坐标和地图级别  
		
		var opts = {
			width : 50, // 信息窗口宽度    
			height : 20, // 信息窗口高度    
			title : stationName // 信息窗口标题   
		};
		var infoWindow = new BMap.InfoWindow("",opts); // 创建信息窗口对象    
		map.openInfoWindow(infoWindow, map.getCenter()); // 打开信息窗口
	}
	//alert(axis_x + "--" + axis_y);

	var marker = new BMap.Marker(point); // 创建标注
	map.addOverlay(marker); // 将标注添加到地图中

	/* marker.addEventListener("click",getAttr);
	function getAttr(){
		alert("fadfa");
		var p = marker.getPosition();       //获取marker的位置
		alert("marker的位置是" + p.lng + "," + p.lat);   
	} */
	/* var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r) {
		if (this.getStatus() == BMAP_STATUS_SUCCESS) {
			marker = new BMap.Marker(r.point);
			map.addOverlay(marker);
			map.panTo(r.point);
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
			alert('您的位置：' + r.point.lng + ',' + r.point.lat);
		} else {
			alert('failed' + this.getStatus());
		}
	}, {
		enableHighAccuracy : true //高精度
	}); */

	//单击获取点击的经纬度
	map.addEventListener("click", moveMarker);
	function moveMarker(e) {
		map.removeOverlay(marker);
		//marker.dispose();
		var point = new BMap.Point(e.point.lng, e.point.lat); // 创建点坐标  
		showInfo(e);
		map.centerAndZoom(point, 18); // 初始化地图，设置中心点坐标和地图级别  

		marker = new BMap.Marker(point); // 创建标注
		map.addOverlay(marker); // 将标注添加到地图中
		marker.enableDragging();
		marker.addEventListener("dragend", showInfo);
	}

	//填充当前位置到文本框
	function showInfo(e) {
		var jing_du_value = e.point.lng;
		var wei_du_value = e.point.lat;
		//alert(e.point.lng + "," + e.point.lat);
		var jing_du = document.getElementById("x");
		var wei_du = document.getElementById("y");
		jing_du.value = jing_du_value;
		wei_du.value = wei_du_value;
	}
</script>
