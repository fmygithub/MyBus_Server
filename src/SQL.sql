// 创建直达路线视图 
create view view_direct_route as
	select 
		rs1.station_id          as begin_station_id,
		station1.station_name   as begin_station_name,
		rs2.station_id          as end_station_id,
		station2.station_name   as end_station_name,
		rs1.route_id            as route_id,
		route.route_name        as route_name,
		rs1.marker              as begin_marker,
		rs2.marker              as end_marker,
		rs2.marker - rs1.marker as  station_count 
    from 
    	tb_route_station rs1,tb_route_station rs2,tb_station station1,tb_station station2,tb_route route
	where 
		rs1.route_id = rs2.route_id
		and
		rs1.station_id = station1.station_id
		and
		rs2.station_id = station2.station_id
		and
		rs1.route_id = route.route_id
		and
		rs1.marker < rs2.marker;
// 删除直达路线视图
drop view view_direct_route;
// 查询直达路线视图
select * from view_direct_route v where v.begin_station_id = 7 and v.end_station_id = 10; 
select * from view_direct_route v where v.begin_station_name = '宝德学院' and v.end_station_name = '天津城建大学'; 
select * from view_direct_route where route_id = 5;

select * from tb_route_station;

// 创建一次换乘视图
create view view_one_tranfer_route as
	select 
		direct1.begin_station_id                      as begin_station_id,
		direct1.begin_station_name                    as begin_station_name,
		direct1.begin_marker                          as begin_marker,
		direct1.route_id                              as route_id1,
		direct1.route_name                            as route_name1,
		direct1.station_count						  as station_count1,
		direct1.end_station_id                        as tranfer_station_id,
		direct1.end_station_name                      as tranfer_station_name,
		direct1.end_marker                            as tranfer_marker,
		direct2.begin_marker                          as tranfer_marker1,
		direct2.route_id                              as route_id2,
		direct2.route_name                            as route_name2,
		direct2.station_count                         as station_count2,
		direct2.end_station_id                        as end_station_id,
		direct2.end_station_name                      as end_station_name,
		direct2.end_marker                            as end_marker
	from
		view_direct_route direct1,
		view_direct_route direct2
	where
		direct1.end_station_id = direct2.begin_station_id
		and
		direct1.route_id != direct2.route_id;
		
//删除一次换乘视图
drop view view_one_tranfer_route;
//查询换乘路线
select * from view_one_tranfer_route ot where ot.begin_station_name = '宝德学院'  and ot.end_station_name = '浦口道' limit 5;
select * from view_one_tranfer_route;


// 创建两次换乘视图
create view view_two_tranfer_route as
	select 
		direct1.begin_station_id                      as begin_station_id,
		direct1.begin_station_name                    as begin_station_name,
		direct1.begin_marker                          as begin_marker,
		direct1.route_id                              as route_id1,
		direct1.route_name                            as route_name1,
		direct1.station_count						  as station_count1,
		direct1.end_station_id                        as tranfer_station_id1,
		direct1.end_station_name                      as tranfer_station_name1,
		direct1.end_marker                            as tranfer_marker11,
		direct2.begin_marker                          as tranfer_marker12,
		direct2.route_id                              as route_id2,
		direct2.route_name                            as route_name2,
		direct2.station_count                         as station_count2,
		direct2.end_station_id                        as tranfer_station_id2,
		direct2.end_station_name                      as tranfer_station_name2,
		direct2.end_marker                            as tranfer_marker22,
		direct3.begin_marker                          as tranfer_marker23,
		direct3.route_id                              as route_id3,
		direct3.route_name                            as route_name3,
		direct3.station_count                         as station_count3,
		direct3.end_station_id                        as end_station_id,
		direct3.end_station_name                      as end_station_name,
		direct3.end_marker                            as end_marker
	from
		view_direct_route direct1,
		view_direct_route direct2,
		view_direct_route direct3
	where
		direct1.end_station_id = direct2.begin_station_id
		and
		direct2.end_station_id = direct3.begin_station_id
		and
		direct1.route_id != direct2.route_id
		and
		direct2.route_id != direct3.route_id;

//删除两次换乘视图
drop view view_two_tranfer_route;
//查询换乘路线
select * from view_two_tranfer_route ot where ot.begin_station_name = '宝德学院'  and ot.end_station_name = '浦口道';

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

select * from tb_route_station where route_id = 4 order by marker asc;
select * from tb_route;


select * from tb_user order by user_id asc;

delete from tb_user where user_id in (14,15);