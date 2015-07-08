<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
  <head>
    <title>楼盘详情页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/backstage/houses/css/houseInformation.css" 

>
	<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="js/right.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=846b0044865e29d73dc3af374b6d7a47"></script>
 	<script type="text/javascript">
 		$(document).ready(function(){
 			var map=new BMap.Map("map");
 			var point=new BMap.Point($("#bd_x").val(),$("#bd_y").val());
 			map.centerAndZoom(point,15);
 			map.enableScrollWheelZoom();
 			var mark=new BMap.Marker(point);
 			map.addOverlay(mark);
 			addlabel(map,point);
 		}) 	
 		function addlabel(map,point){
 			var label=new BMap.Label("");
 			label.setStyle

({borderRadius:"5px",fontSize:"14px",background:"blue",color:"#fff",fontWeight:"bolder",border:"none"});
 			label.setContent("<div style='width:100px;height:20px;text-align:center'>${requestScope.house.h_name}

</div>");
 			label.setPosition(point);
 			label.setOffset(new BMap.Size(0,-35));
 			map.addOverlay(label);
 		}
 		
 	</script>
 
  </head>
  
  <body>
	<div class="main">
    	<div class="title">
        	<p id="title_P_place">&nbsp;当前位置：<font color="red">${requestScope.house.h_name} </font>详情</p>
        </div>
        <div class="mainbody">
        	<!--正文的上半部分-->
        	<div class="center_top">
                <!--基本信息-->
                <div class="essentialNews">
                	<div class="news_title"><span>基本信息</span></div>
                    <div class="news_context">
                    		<table class="news_table">
                    		<!--list中0为房屋类型，1为付款方式，2为出租类型,3为发布人的对象-->
                    			   <tr> <td>房源标题:</td><td class="text" colspan="3" >${requestScope.house.h_title}</td></tr>
                    			   <tr> <td>房源名称:</td><td class="text">${requestScope.house.h_name}</td><td>付款方式:</td><td class="text">${requestScope.house.list[1]}</td></tr>
					               <tr> <td>房源楼层:</td><td class="text">${requestScope.house.h_floor}/${requestScope.house.h_all_floor}层</td><td>房源面积:</td><td class="text">${requestScope.house.h_proportion}m²</td></tr>
					               <tr> <td>房源价格:</td><td class="text">${requestScope.house.h_price}元/月</td><td>房源类型:</td><td class="text">${requestScope.house.list[0]}</td></tr>
					               <tr> <td>发布人:</td><td class="text">
					               		<c:if test="${requestScope.house.h_ischarge==0}">${requestScope.house.list[3].per_name}</c:if>
					               		<c:if test="${requestScope.house.h_ischarge==1}">${requestScope.house.list[3].b_realname}</c:if>
					               </td><td>出租方式:</td><td class="text">${requestScope.house.list[2]}</td></tr>
					               <tr> <td>发布时间:</td><td class="text">${requestScope.house.h_publictime}</td><td>关键字：</td><td class="text">${requestScope.house.h_tag}</td></tr>
                    		</table>
                    </div>
                </div>
               <!-- 地图区域 -->
	          <div class="maplist">
	          	<p style="margin-left:10px;">地图定位:</p>
	          		<span  style="margin-left:10px;">经度</span><input type="text" name="bd_x" id="bd_x" 

style="width:100px;" value="${requestScope.house.h_xpoint}"/>
	          	<span>纬度</span><input type="text" name="bd_y" id="bd_y" style="width:100px;" 

value="${requestScope.house.h_ypoint}"/>
	          	<div id="map" style="width:100%;height:85%;margin-top:8px;border:#ccc 1px solid"></div>
	          </div>  
	          <!--  正文的下半部-->
	          <div class="center_summary">
	          		<div class="summary_title"><span>房源简 介</span></div>
	                <div class="summary_context">
	                	${requestScope.house.h_infos}
	                </div>
	          </div>
            </div>
            <!--图片 -->
       		<div class="images">
       			<div class="img_f">
       				<c:forEach items="${requestScope.imgList}" var="houseImg">
       					<img src="${pageContext.request.contextPath}/${houseImg.hi_url}" class="img">
       				</c:forEach>
       			
       			</div>
       		</div>     
       </div>
    </div>
</body>
</html>
