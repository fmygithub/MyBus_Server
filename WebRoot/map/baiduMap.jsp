
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
	<form action="stationAction_add.action" method="post">
		请输入站点名:<input type="text" name="stationName" /> <br> 请选择所属路线:
		<s:select name="routeId" list="#routeList" size="1"
			headerValue="请选择路线" headerKey="" listKey="routeId"
			listValue="routeName" />
		<br>
		 站点在路线中的位置：<input  type="text" name="marker" />
		<br>
		请输入站点位置：
		x轴：<input id="x" type="text" name="axis_x" />&nbsp; 
		y轴：<input id="y" type="text" name="axis_y" /> &nbsp;
		<br> 
		<input type="submit" value="添加" />
	</form>
	<div id="container"></div>
</body>
</html>
<script type="text/javascript">
	var map = new BMap.Map("container"); // 创建地图实例  
	map.addControl(new BMap.NavigationControl()); //添加平移缩放控件  
	map.addControl(new BMap.ScaleControl()); //添加放大、缩小控件  
	map.enableScrollWheelZoom();//允许鼠标滑轮操作  

	var longitude = "117.10014642419";//经度  117.21081309,39.1439299
	var latitude = "39.100717287146";//纬度  
	var point = new BMap.Point(longitude, latitude); // 创建点坐标  
	map.centerAndZoom(point, 15); // 初始化地图，设置中心点坐标和地图级别  

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

	marker.enableDragging();
	marker.addEventListener("dragend", function(e) {
		//alert("当前位置：" + e.point.lng + ", " + e.point.lat);
		var jing_du_value = e.point.lng;
		var wei_du_value = e.point.lat;
		//alert(e.point.lng + "," + e.point.lat);
		var jing_du = document.getElementById("x");
		var wei_du = document.getElementById("y");
		jing_du.value = jing_du_value;
		wei_du.value = wei_du_value;
	});

	/* //单击获取点击的经纬度
	map.addEventListener("click", showInfo);
	function showInfo(e) {
	}
	 */
	//marker.addEventListener("click", showInfo);
</script>
