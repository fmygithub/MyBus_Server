// 创建直达路线视图 
create view view_direct_route as
	select 
		rs1.station_id as begin_station,
		rs2.station_id as end_station,
		rs1.route_id   as route_id,
		rs1.marker as begin_marker,
		rs2.marker as end_marker,
		rs2.marker - rs1.marker as  station_count 
    from 
    	tb_route_station rs1,tb_route_station rs2
	where 
		rs1.route_id = rs2.route_id
		and
		rs1.marker < rs2.marker;
// 删除直达路线视图
drop view view_direct_route;
// 查询直达路线视图
select * from view_direct_route v where v.begin_station = 7 and v.end_station = 10; 

// 创建一次换乘视图
create view view_one_tranfer_route as
	select 
		direct1.begin_station as begin_station,
		direct1.begin_marker as begin_marker,
		direct1.route_id as route_id1,
		direct1.end_station as tranfer_station,
		direct1.end_marker as tranfer_marker,
		direct2.route_id as route_id2,
		direct2.end_station as end_station,
		direct2.end_marker as end_marker,
		direct1.station_count + direct2.station_count as station_count
	from
		view_direct_route direct1,
		view_direct_route direct2
	where
		direct1.end_station = direct2.begin_station
		and
		direct1.route_id != direct2.route_id;
		
//删除一次换乘视图
drop view view_one_tranfer_route;
//查询换乘路线
select * from view_one_tranfer_route ot where ot.begin_station = 7 and ot.end
select * from view_one_tranfer_route;
		
select * from tb_station;


select 
	rs1.station_id as begin_station,
	rs2.station_id as end_station,
	rs1.route_id   as route_id,
	rs2.marker - rs1.marker as  station_count 
from 
    tb_route_station rs1,tb_route_station rs2
where 
	rs1.route_id = rs2.route_id
	and
	rs1.marker < rs2.marker;
	
select * from tb_route_station ;

select * from tb_route_station rs where rs.route_id = 4 and rs.marker <= 6 and rs.marker >= 1;