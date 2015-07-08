<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${applicationScope.Oversystems.sys_name} - 求租列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/seekRent/css/seekRentList_css.css"/>
	<script type="text/javascript">
		function rentOut(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id";
    	}
    	function personal(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryPersonal";
    	}
    	function index(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex";
    	}
    	function company(){
    		window.location.href="${pageContext.request.contextPath}/Companys?method=selForFront";
    	}
    	function broker(){
    		window.location.href="${pageContext.request.contextPath}/Brokeres?method=selForFront";
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
                    <li><a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">经纪人登录</a>&nbsp;客服：<font>${applicationScope.Oversystems.sys_tel }</font>&nbsp;</li>
                </ul>
            </div>
        </div>
        <div class="b_search">
        	<img src="${pageContext.request.contextPath}/${applicationScope.Oversystems.sys_logo}" id="logo"/>
            <div class="search_input">
            	<jsp:include page="../../common/searchBar.jsp"></jsp:include>
            </div>
        </div>
        <div class="b_middle">
        	<div class="middle_title">
                <ul class="middle_title_ul">
                    <li id="index" onclick="index()">首&nbsp;页</li><li id="border_1"></li>
                    <li id="out_rent" onclick="rentOut()">出租房源</li><li id="border_2"></li>
                    <li id="personal_house" onclick="personal()">个人房源</li><li id="border_3"></li>
                    <li id="seek_rent">求&nbsp;租</li><li id="border_4"></li>
                    <li id="company" onclick="company()">中介公司</li><li id="border_5"></li>
                    <li id="broker" onclick="broker()">经纪人</li>
                </ul>
            </div>
            <div class="display_count">成都租房网有<font>${requestScope.houseCount}</font>条求租信息。</div>
            
            <div class="middle_left">
                <div class="house_menus_div">
                    <div class="house_menus_title">
                        <h2>求租列表</h2>
                        <span><a href="#">更多>></a></span>
                    </div>
                    <div class="house_menus_content">
                    	<c:forEach items="${requestScope.seekRentList}" var="seekRent">
                    		<div class="menu_object_div">
	                        	<p class="object_rentType">${seekRent.sr_id}</p>
	                            <p class="object_title"><a href="#">${seekRent.sr_infos}</a>&nbsp;&nbsp;(
									<c:forEach items="${requestScope.smallAreaList}" var="smallArea">
										<c:if test="${smallArea.sa_id==seekRent.sa_id}">${smallArea.sa_name}</c:if>
									</c:forEach>
								)</p>
	                            <p class="object_price"><font>${seekRent.sr_price}</font>元/月</p>
	                            <p class="object_name">${seekRent.sr_tel}</p>
	                        </div>
                    	</c:forEach>
                    </div>
                </div>
            </div>
            <div class="middle_right">
            	<div class="house_submit_div">
                	<div class="house_submit_img_div"><img src=""/></div>
                    <div class="house_submit_content">
                    	<h2>我要上传求租信息</h2>
                        <p>填写您的求租信息，帮您免费求租</p>
                        <p>本周已有<font>${requestScope.houseCount}</font>人发布了求租房源信息</p>
                        <div class="role_div">
                             <div class="do_submit" style="text-align:center"><a href="${pageContext.request.contextPath}/SeekRent?method=selForFront">我要求租</a></div>
                        </div>
                    </div>
                </div>
                <img class="middle_right_img" src=""/>
                <div class="rent_picture" style="margin-top:10px">
                    <img class="rent_picture_content" src="${pageContext.request.contextPath}/front/houses/img/1318574841325.jpg">                  
                </div>
                  <div class="rent_picture" style="">
                    <img class="rent_picture_content" src="${pageContext.request.contextPath}/front/houses/img/uma_sl_220x220_2.jpg">                  
                </div>
            </div>
        </div>
        <jsp:include page="../../common/pager.jsp">
        	<jsp:param value="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent" name="url"/>
        </jsp:include>
        <div class="b_footer">
            <jsp:include page="../../common/footer.jsp"></jsp:include>
        </div>
    </div>
  </body>
</html>
