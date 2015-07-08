<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>经纪人列表</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/company/css/companyList_css.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			if($("#count").html()>10)
				$("#pageres").css("display","block");
				
				
			$(".companys").each(function(i){
				var s=$("#leval"+i).val();
				var str="";
				for ( var j = 0; j< s; j++) {
					str+="<img src='${pageContext.request.contextPath}/front/brokeres/imgs/leval.png' style='width:20px;height:20px;'>";
				}
				$("#leval_img"+i).html(str);
						
			})
			
		})
		function moveMouse(obj){
			$(obj).css("background","rgb(83, 174, 207)");			
		}
		function Mouseout(obj){
			$(obj).css("background","#1b99de");
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
                    <li id="index"><a href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex">首&nbsp;页</a></li><li id="border_1"></li>
                    <li id="personal_house"><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id">出租房源</a></li><li id="border_2"></li>
                    <li id="personal_house"><a href="${pageContext.request.contextPath}/FrontHouses?method=queryPersonal">个人房源</a></li><li id="border_3"></li>
                    <li id="seek_rent"><a href="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent">求&nbsp;租</a></li><li id="border_2"></li>
                    <li id="seek_rent" style="width:100px;"><a href="${pageContext.request.contextPath}/Companys?method=selForFront">中介公司</a></li><li id="border_2"></li>
                     <li id="out_rent"><a href="" style="color:#fff">经纪人</a></li>
                </ul>
            </div>
            <div class="display_count">${applicationScope.Oversystems.sys_name}有<font id="AllNum">${requestScope.nam}</font>套出租房正在出租，个人房源共有<font id="psHouse">${requestScope.Pnum}</font>套。</div>
            <div class="middle_left">
            	<div style="width:100%;height:auto;">
            		<h2 style="width:100%;height:30px;border-bottom:2px solid rgb(0, 72, 180)">经纪人列表</h2>
            		<div style="width:100%;height:auto;">
            		
            			<c:forEach items="${requestScope.blist}" var="broker" varStatus="i">
	            			<div style="width:300px;height:200px;margin-top:10px;margin-left:10px;float:left;background:#1b99de;" class="companys" onmouseover="moveMouse(this)" onmouseout="Mouseout(this)">
	            				<a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&b_id=${broker.b_id}">
	            					<img src="${pageContext.request.contextPath}/${broker.b_head_img}" style="width:250px;height:120px;margin-left:20px;margin-top:5px;"/></a>
	            				<div style="width:300px;height:80px;">
	            					<ul style="list-style:none;padding-left:10px;line-height:20px;font-size:17px;">
	            						<li>真实姓名:<a href="${pageContext.request.contextPath}/FrontHouses?method=queryBroker&b_id=${broker.b_id}&typeName=${broker.b_realname}">${broker.b_realname}</a></li>
	            						<li>联系电话:${broker.b_tel}</li>
	            						<li>信用等级:<input type="hidden" value="${broker.b_level}" id="leval${i.index}"><font id="leval_img${i.index}"></font></li>
	            					</ul>            				
	            				</div>
	            			</div>
            			</c:forEach>
            			
            		</div>
            		<div class="table_buttom" id="pageres" style="display:none;clear: both;">
						<div class="buttom_left">找到<span id="count">${requestScope.pages.counts}</span>条公司，当前第 ${requestScope.pages.currentPage}/${requestScope.pages.pageCount} 页</div>
		   				 <div class="buttom_right">
		      				<a href="${pageContext.request.contextPath}/Brokeres?method=selForFront&page=1"><input type="button" value="首页"></a>
		        			<a href="${pageContext.request.contextPath}/Brokeres?method=selForFront&page=${requestScope.pages.currentPage-1}"><input type="button" value="上一页"/></a>
		      				 <a href="${pageContext.request.contextPath}/Brokeres?method=selForFront&page=${requestScope.pages.currentPage+1}"><input type="button" value="下一页"/></a>      
		        			<a href="${pageContext.request.contextPath}/Brokeres?method=selForFront&page=${requestScope.pages.pageCount}"><input type="button" value="尾页"/></a>
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
                            <div class="do_submit" style="text-align:center"><a href="${pageContext.request.contextPath}/relevance?method=selForFront&state=publish">我要出租</a></div>
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
