<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>小区列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/smallArea/css/smallArealist.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			if($("#count").html()>10)
				$("#pageres").css("display","block");
		})
		function rentOut(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id";
    	}
    	function personal(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryPersonal";
    	}
    	function seekRent(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent";
    	}
    	function index(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex";
    	}
    	function broker(){
    		window.location.href="${pageContext.request.contextPath}/Brokeres?method=selForFront";
    	}
    	function company(){
    		window.location.href="${pageContext.request.contextPath}/Companys?method=selForFront";
    	}
    	function mousemove(obj){
    		$(obj).css({background:"rgb(0, 72, 180)",color:"#fff",cursor:"pointer"});
    	}
    	function mouseout(obj){
    		$(obj).css({background:"#fff",color:"#000"});
    	}
	</script>
  </head>
  
  <body>
    <div class="b_all">
        <div class="b_header">
            <div class="header_ul">
                <ul class="header_ul_left">
                    <li><a href="${pageContext.request.contextPath}/front/houses/web_page/index.jsp">首页</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">资讯</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">二手房</a>&nbsp;<a href="#">租房</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">装修</a>&nbsp;<a href="#">家居</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">业主论坛</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">地产数据</a>&nbsp;</li>
                </ul>
                <ul class="header_ul_right">
                    <li><a href="javascript:alert('会员之家筹备中... 敬请期待!');">登录</a>&nbsp;<a href="javascript:alert('会员之家筹备中... 敬请期待!');">注册</a>&nbsp;|&nbsp;</li>
                    <li><a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">经纪人登录</a>&nbsp;客服：<font>${applicationScope.Oversystems.sys_tel}</font>&nbsp;</li>
                </ul>
            </div>
        </div>
        <div class="b_search">
        	<img src="${pageContext.request.contextPath}/${applicationScope.Oversystems.sys_logo}" id="logo"/>
            <div class="search_input">
            	 <iframe src="front/common/searchBar.jsp" frameborder="0" style="width:100%;height:100%"></iframe>
            </div>
        </div>
        <div class="b_middle">
        	<div class="middle_title">
                <ul class="middle_title_ul">
                    <li id="index" onclick="index()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">首&nbsp;页</li><li id="border_1"></li>
                    <li id="personal_house" onclick="rentOut()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">出租房源</li><li id="border_2"></li>
                    <li id="personal_house" onclick="personal()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">个人房源</li><li id="border_3"></li>
                    <li id="seek_rent" onclick="seekRent()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">求&nbsp;租</li><li id="border_4"></li>
                    <li id="company" onclick="company()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">中介公司</li><li id="border_5"></li>
                    <li id="broker" onclick="broker()" onmouseover="mousemove(this)" onmouseout="mouseout(this)">经纪人</li>
                </ul>
            </div>
            <div class="display_count">${applicationScope.Oversystems.sys_name}有<font>${requestScope.nam}</font>套出租房正在出租，个人房源共有<font>${requestScope.Pnum}</font>套。</div>
            <div class="middle_left">
            	
            	<div style="width:100%;height:auto;">
            		<h2 style="width:100%;height:30px;border-bottom:2px solid rgb(0, 72, 180)">小区列表</h2>
            		<div style="width:100%;height:auto;">
            			<c:forEach items="${requestScope.small_list}" var="small_area">
	            			<div style="width:90%;height:80px;margin-top:10px;margin-left:10px;" class="companys">
	            				<img src="${pageContext.request.contextPath}/${small_area.list[0].sai_url}" style="width:120px;height:80px;float:left;"/>
	            				<div style="width:400px;height:80px;float:left;margin-left:10px;">
	            					<ul style="list-style:none;padding-left:10px;line-height:25px;font-size:17px;">
	            						<li>小区名称:<a href="${pageContext.request.contextPath}/FrontHouses?method=querySmallArea&sa_id=${small_area.sa_id}&typeName=${small_area.sa_name}">${small_area.sa_name}</a></li>
	            						<li>小区地址:${small_area.sa_address}</li>
	            						<li>物业费用:<font color="red">${small_area.sa_real_money}</font>元/平米</li>
	            					</ul>            				
	            				</div>
	            			</div>
            			</c:forEach>
            			
            		</div>
            		<div class="table_buttom" id="pageres" style="display:none;clear: both;">
						<div class="buttom_left">找到<span id="count">${requestScope.pages.counts}</span>条公司，当前第 ${requestScope.pages.currentPage}/${requestScope.pages.pageCount} 页</div>
		   				 <div class="buttom_right">
		      				<a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront&page=1"><input type="button" value="首页"></a>
		        			<a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront&page=${requestScope.pages.currentPage-1}"><input type="button" value="上一页"/></a>
		      				 <a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront&page=${requestScope.pages.currentPage+1}"><input type="button" value="下一页"/></a>      
		        			<a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront&page=${requestScope.pages.pageCount}"><input type="button" value="尾页"/></a>
				          </div>
				     </div>
            	</div>            	
            	
            	
            	
                <div class="house_menus_div">
                    <div class="house_menus_title">
                        <h2>房源列表</h2>
                        <span><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id">更多>></a></span>
                    </div>
                    
                     <div class="house_menus_content">
	                    <c:forEach items="${requestScope.houselist}" var="house">
	                    	<div class="menu_object_div">
	                        	<img src="${house.list[4][0].hi_url}"/>
	                            <div class="menu_object_message">
	                            	<p class="object_name"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}">${house.h_name }</a></p>
	                                <p class="object_date">${house.h_publictime}</p>
	                                <p class="object_address"><font color="red">${house.h_price}</font>元/月</p>
	                                <p class="object_infos" style="overflow:visible">${house.h_title}</p>
	                            </div>
	                        </div>
	                      </c:forEach>
	                      
                    </div>
                    
                </div>
            </div>
            <div class="middle_right">
            	<div class="house_submit_div">
                	<div class="house_submit_img_div"><img src=""/></div>
                    <div class="house_submit_content">
                    	<h2>我有房屋要出租</h2>
                        <p>填写您的房源信息，帮您免费出租</p>
                        <p>本周已有<font>${requestScope.ps}</font>人发布了成都租房房源</p>
                        <div class="role_div">
                            <div class="do_submit"><a href="${pageContext.request.contextPath}/relevance?method=selForFront&state=publish">我要出租</a></div>
                            <div class="do_submit_broker"><img src=""/><a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">我是经纪人>></a></div>
                        </div>
                    </div>
                </div>
                	 <!-- 广告位 -->
                <div class="rent_picture" style="margin-top:10px">
                    <img class="rent_picture_content" src="${pageContext.request.contextPath}/front/houses/img/1318574841325.jpg">                  
                </div>
                  <div class="rent_picture" style="">
                    <img class="rent_picture_content" src="${pageContext.request.contextPath}/front/houses/img/uma_sl_220x220_2.jpg">                  
                </div>
                
            </div>
        </div>
        <div class="b_footer">
            <jsp:include page="../../common/footer.jsp"></jsp:include>
        </div>
    </div>
  </body>
</html>
