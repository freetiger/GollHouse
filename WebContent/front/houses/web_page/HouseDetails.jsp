<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  	 <title>${requestScope.house.h_name}-${requestScope.systems.sys_name}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="${requestScope.systems.sys_tag},${requestScope.house.h_tag}">
	<meta http-equiv="description" content="${requestScope.systems.sys_infos}">
	
 <link type="text/css" href="${pageContext.request.contextPath}/front/houses/css/HouseDetails.css" rel="stylesheet" />
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=846b0044865e29d73dc3af374b6d7a47"></script>
<script type="text/javascript">
		var wid;
		var timeCount;
		$(document).ready(function(){
			 wid= ${requestScope.house.list[4]};//获取共有多少图片
			$("#auto_list").css("width",wid*132+"px");
			if(wid>2){
				timeCount=setInterval(imgMove,5000);
			}
		})
		//图片滚动的方法
		function imgMove(){
			var s=$("#auto_list").css("margin-left");
			var num=s.substring(0,s.indexOf("p"));
			if(num>-(wid-3)*130){
				$("#auto_list").animate({marginLeft:"-=130px"},1000);
			}
			else{
				$("#auto_list").animate({marginLeft:"0px"},1000);
			}
		}
		//点击改变大图
		function changeImg(obj){
			$("#img").attr("src",$(obj).attr("src"));
		}
		function stopTime(){
			clearInterval(timeCount);
		}
		function startTime(){
			if(wid>2){
				timeCount=setInterval(imgMove,5000);
			}
		} 
		function lastImg(){
			var s=$("#auto_list").css("margin-left");
			var num=s.substring(0,s.indexOf("p"));
			if(num<=-130){
				$("#auto_list").animate({marginLeft:"+=130px"},1000);
			}
			else{
				
				$("#auto_list").animate({marginLeft:"-"+(wid-2)*132+"px"},1000);
			}
		}
		function nextImg(){
			var s=$("#auto_list").css("margin-left");
			var num=s.substring(0,s.indexOf("p"));
			if(num>-(wid-2)*130){
				$("#auto_list").animate({marginLeft:"-=130px"},1000);
			}
			else{
				$("#auto_list").animate({marginLeft:"0px"},500);
			}
		}
	//地图部分
	function searchsuper(){ 
		$("#content").html("");
		var local = new BMap.LocalSearch(map, {    
		 renderOptions: {map: map, panel: "content"},
		 pageCapacity:3     
		});    
		local.search("超市"); 
	}
	function searchSchool(){ 
		$("#content").html("");
		var local = new BMap.LocalSearch(map, {    
		 renderOptions: {map: map, panel: "content"},
		 pageCapacity: 4     
		});    
		local.search("学校"); 
	}
	function searchtransit(){ 
		$("#content").html("");
		var local = new BMap.LocalSearch(map, {    
		 renderOptions: {map: map, panel: "content"},
		 pageCapacity: 4    
		});    
		local.search("公交"); 
	}
	</script>
</head>

<body>
    <div class="main">
    	<!--标题-->
    	<div class="title">
        	<p class="header"><span class="header_left"><a href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex">首页</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id">租房</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent">求租</a></span>
            	<span class="header_right"><a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">登录</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">经济人登录</a>&nbsp;|&nbsp;客服电话:<font color="red">${requestScope.systems.sys_tel}</font></span>
            </p>
            <div class="logo">
            	<img src="${requestScope.systems.sys_logo}" width="100%" height="100%"/>
            </div>
           	<iframe src="${pageContext.request.contextPath}/front/common/searchBar.jsp" frameborder="0" class="searchBar"></iframe><!--引用的搜索条的页面-->
        </div>
        <!--菜单导航栏-->
        <div class="menu">
        	<a href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex" id="m_1">首&nbsp;页</a><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="m_2">租&nbsp;房</a><a href="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent" id="m_3">求&nbsp;租</a><a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront" id="m_4">小&nbsp;区</a>
        </div>
        <script>
        	$(".menu").children().each(function() {
                $(this).bind("mouseover",function(){
						$(this).css({color:"#0066C4",background:"#fff",borderTop:"red 5px solid"});
					}).bind("mouseout",function(){
						$(this).css({color:"#fff",background:"#0066C4",borderTop:"none"});
					})
            });
        </script>
        <p class="link">${requestScope.systems.sys_name}&nbsp;»${param.typeName}&nbsp;»<a href="">${requestScope.house.h_name}</a>&nbsp;<span style="float:right;font-size:14px;color:blue"><a href="${pageContext.request.contextPath}/front/person/web_page/qiuZu.jsp">我的租房条件</a></span></p>
	<!--  房源的基本信息-->
    	<div class="info"> 
        	<p class="houseName"><span class="h_1">${requestScope.house.h_title}</span><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" class="h_2">切换到租房列表 »</a></p>
            <p class="houseId">房源编号:${requestScope.house.h_number}&nbsp;&nbsp;发布时间:${requestScope.house.h_publictime}</p>
            <div class="houseInfo">
            	<div class="img">
                	 <img src="" id="img" title="房源图片" alt="房源图片"/> 
                      <img src="${pageContext.request.contextPath}/front/houses/img/last.png" class="last" title="上一张" style="float:left;border-radius:5px 0px 0px 5px;"  onclick="lastImg()" onmouseover="stopTime()" onmouseout="startTime()"/> 
                      <div class="imglist">
                      	<div id="auto_list" style="border:green 1px solid;height:100px;position:absolute;">
                    <!-- 从服务器读取图片-->
                    	<c:forEach items="${requestScope.imgList}" var="houseImg" varStatus="i">
                        	<img src="${pageContext.request.contextPath}/${houseImg.hi_url}" class="img${i.index}" style="width:125px;height:100px;float:left;border:#666 1px solid;margin-right:5px;" onclick="changeImg(this)">
                        </c:forEach>
                        </div>
                      </div>
                       <img src="${pageContext.request.contextPath}/front/houses/img/next.png" class="next" title="下一张" style="float:right;border-radius:0px 5px 5px 0px;" onclick="nextImg()" onmouseover="stopTime()" onmouseout="startTime()"/> 
                </div>		
                <div class="houseInfolist">
                	<ul style="margin:0px;padding:0px">
                    	<li>租金：<span style="color:red;font-size:20px;font-weight:bolder">${requestScope.house.h_price}</span>元/月&nbsp;${requestScope.house.list[1]}</li>
                        <li>户型：${requestScope.house.list[0]}&nbsp;${requestScope.house.list[2]}</li>
                        <li>面积：${requestScope.house.h_proportion}m²</li>
                        <li style="line-height:20px; border-bottom:#CCC 1px solid;">楼层：${requestScope.house.h_floor}/${requestScope.house.h_all_floor}层</li>
                        <li>小区：${requestScope.sa.sa_name}&nbsp;&nbsp;${requestScope.area.a_name}</li>
                         <li>地址：${requestScope.sa.sa_address}</li>
                        <li>房间配置：<div class="peizhi"><p>
                        	<c:forEach items="${requestScope.hetList}" var="het">${het.het_name}&nbsp;</c:forEach>
                         </p></div></li>
                    </ul>
                    <div class="phone">
                    	<img src="${pageContext.request.contextPath}/front/houses/img/phone.jpg" style="width:70px;heigt:70px;float:left;"/>
                        <div class="p_number"><p style="font-size:34px;font-weight:bolder;color:#0066C4;">
                       				 <c:if test="${requestScope.house.h_ischarge==0}">${requestScope.house.list[3].per_tel}</c:if>
					               	 <c:if test="${requestScope.house.h_ischarge==1}">${requestScope.house.list[3].b_tel}</c:if>
                        </p><p style="font-size:14px;color:#999">联系请说：我在${requestScope.systems.sys_name}看到的。</p></div>
                    </div>                
                </div>	               
            </div>
             <!--图片列表的自动滚动-->
    	<script type="text/javascript">
        	$("#img").attr("src",$(".img0").attr("src"));
        </script>  
        
    
           <div class="broker">
            <!--   经纪人-->
          	 <c:if test="${requestScope.house.h_ischarge==1}">
           		<div class="b_phone">
                	<a href="${pageContext.request.contextPath}/FrontHouses?method=queryBroker&b_id=${requestScope.house.list[3].b_id}&typeName=${requestScope.house.list[3].b_realname}"><img src="${pageContext.request.contextPath}/${requestScope.house.list[3].b_head_img}" style="width:180px;height:140px"/>
                    <p style="width:180px;height:20px;text-align:center;">${requestScope.house.list[3].b_realname}</p></a>
                </div>
                <div class="b_info">
                	<ul>
                    	<li><img src="${pageContext.request.contextPath}/front/houses/img/shenfen.png" title="已身份验证" alt="经纪人身份图片">&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/front/houses/img/yinnye.png" title="已验证营业执照" alt="经纪人营业执照图片"></li>
                        <li>信用度：${requestScope.house.list[3].b_level}</li>
                        <li>所在公司：${requestScope.house.list[3].b_company}</li>
                    </ul>
                </div>
               </c:if>
                <!--  个人-->
                <c:if test="${requestScope.house.h_ischarge==0}">
                    <p style="width:180px;height:50px;text-align:center;font-size:20px;line-height:50px;">联系人：${requestScope.house.list[3].per_name}</p></a>
                	<img src="${pageContext.request.contextPath}/front/houses/img/ch.jpg" style="width:200px;height:130px;margin-left:10px;"/>
                	<img src="${pageContext.request.contextPath}/front/houses/img/uma_sl_220x220_2.jpg" style="width:200px;height:110px;margin-left:10px;"/>
               </c:if>
               
           </div> 
        </div>
        <!--地图定位-->
        <div class="map">
        	<div class="map_title">房源的方位</div>
        	<div id="m_map"></div>
            <div class="map_select">
          	  <p class="map_right_title"><a href="javascript:;" onClick="searchsuper()">超市</a><a href="javascript:;" onClick="searchSchool()">学校</a><a href="javascript:;" onClick="searchtransit()">公交</a></p>
                <div id="content"></div>
            </div>
        </div>
        <script type="text/javascript">
			var map = new BMap.Map("m_map");            // 创建Map实例
			var point = new BMap.Point(${requestScope.house.h_xpoint},${requestScope.house.h_ypoint});    // 创建点坐标
			map.centerAndZoom(point,16);                     // 初始化地图,设置中心点坐标和地图级别。
			map.enableScrollWheelZoom();
			map.addControl(new BMap.NavigationControl());
			var marker=new BMap.Marker(point);
			map.addOverlay(marker);
			var label=new BMap.Label("");
			label.setStyle({borderRadius:"5px",fontSize:"14px",background:"blue",color:"#fff",fontWeight:"bolder",border:"none"});
			label.setContent("<div style='width:100px;height:20px;text-align:center'>${requestScope.house.h_name}</div>");
			label.setPosition(point);
			label.setOffset(new BMap.Size(0,-35));
			map.addOverlay(label);
			searchsuper();      
        </script>
        <!--房源详情-->
        
        <div class="house_info_top">
        	<div class="house_info_title">房源详情</div>
            <div id="house_content">${requestScope.house.h_infos}  </div>
        </div>
        <!--右侧公告栏-->
         <div class="b_h_list">
          	<c:if test="${requestScope.house.h_ischarge==1}">
	         	<h3 style="text-align:center;width:100%;height:30px;line-height:30px; border-bottom:#3CC 1px solid;">该经纪人其他房源</h3>
	            <div class="b_h_list_content">
	            	<table>
	            	<c:forEach items="${requestScope.house_list}" var="house" varStatus="i">
	            		<c:if test="${i.index<7}">
	            			<tr style="font-size:14px;text-align:center;height:30px;"><th style="width:30%"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}">${house.h_name}</a></th>
	            			<th style="width:30%"><font color="red">${house.h_price}</font>元/月</th><th style="width:30%">${house.h_proportion}平方米</th></tr>
	            		</c:if>
	            	</c:forEach>
	            	</table>
	            </div>
	        </c:if>  
	          
            <img src="${pageContext.request.contextPath}/front/houses/img/1318574841325.jpg"/>
            <img src="${pageContext.request.contextPath}/front/houses/img/houseback.jpg" />
            <img src="${pageContext.request.contextPath}/front/houses/img/houseback2.jpg"/>
                         
         </div>
        <!--网站的尾部-->
    	<iframe src="${pageContext.request.contextPath}/front/common/footer.jsp" id="copyright" frameborder="0"></iframe>
    </div>
</body>
</html>
