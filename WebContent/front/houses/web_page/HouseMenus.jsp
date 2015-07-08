<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${applicationScope.Oversystems.sys_name} - 房源列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/houses/css/house_menus_css.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		function skip(url,number,num){	
			if(number==""){
				alert("请输入要跳转的页数");
				return;
			}else if(number>num){
				alert("当前最多只有"+num+"页,请正确输入");
				number=num;
			}else{
				var reg=/^[0-9]*$/;
				if(!reg.test(number)){
					alert("只能是数字，请正确输入");
					document.getElementById("returns").value="";
					return;
				}
			}
			window.location.href=url+number;
		}
		function index(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex";
    	}
    	function personal(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryPersonal";
    	}
    	function seekRent(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=querySeekRent";
    	}
    	function company(){
    		window.location.href="${pageContext.request.contextPath}/Companys?method=selForFront";
    	}
    	function broker(){
    		window.location.href="${pageContext.request.contextPath}/Brokeres?method=selForFront";
    	}
    	function a_click(obj){
    		$(obj).parent().parent().find("a").each(function(){
    			if($(this).prop("id")==$(obj).prop("id")){
    				$(this).css("color","red");
    			}else{
    				$(this).css("color","#004499");
    			}
    		});
    	}
	</script>
  </head>
  
  <body>
    <div class="b_all">
        <div class="b_header">
            <div class="header_ul">
                <ul class="header_ul_left">
                    <li><a href="#">搜房首页</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">资讯</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">二手房</a>&nbsp;<a href="#">租房</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">装修</a>&nbsp;<a href="#">家居</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">业主论坛</a>&nbsp;|&nbsp;</li>
                    <li><a href="#">地产数据</a>&nbsp;</li>
                </ul>
                <ul class="header_ul_right">
                    <li><a href="#">登录</a>&nbsp;<a href="#">注册</a>&nbsp;|&nbsp;</li>
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
                    <li id="out_rent">出租房源</li><li id="border_2"></li>
                    <li id="personal_house" onclick="personal()">个人房源</li><li id="border_3"></li>
                    <li id="seek_rent" onclick="seekRent()">求&nbsp;租</li><li id="border_4"></li>
                    <li id="company" onclick="company()">中介公司</li><li id="border_5"></li>
                    <li id="broker" onclick="broker()">经纪人</li>
                </ul>
            </div>
            <div class="display_count">成都租房网有<font>${requestScope.houseCount}</font>套出租房正在出租，个人房源共有<font>${requestScope.personalCount}</font>套。</div>
            <div class="terms_div">
                	<div class="terms_title_div">
                        <font class="terms_title_font">区域搜索：</font>
                        <font class="terms_title_font">价格：</font>
                        <font class="terms_title_font">户型：</font>
                        <font class="terms_title_font">特色：</font>
                        <font class="terms_title_font">年份：</font>
                        <font class="terms_title_font">小区：</font>
                    </div>
                    <div class="terms_content_div">
                        <div class="area_div">
                            <ul class="area_ul">
                            	<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&a_id=0&id_name=a_id" id="a_id0" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.areaList}" var="area" varStatus="ai">
                                 		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&a_id=${area.a_id}&id_name=a_id" id="a_id${area.a_id}" onclick="a_click(this)">${area.a_name}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="price_div">
                            <ul class="price_ul">
                            	<li><a href="#" id="price_1" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.rentMoneyList}" var="rentMoney" varStatus="rmi">
                                		<li><a href="#" id="price_id${rentMoney.rm_id}" onclick="a_click(this)">${rentMoney.rm_count}元</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="house_type_div">
                            <ul class="house_type_ul">
                            	<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&ht_id=0&id_name=ht_id" id="ht_id0" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.houseTypeList}" var="houseType" varStatus="hti">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&ht_id=${houseType.ht_id}&id_name=ht_id" id="ht_id${houseType.ht_id}" onclick="a_click(this)">${houseType.ht_name}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="feature_div">
                            <ul class="feature_ul">
                            	<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&rt_id=0&id_name=rt_id" id="rt_id0" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.rentTypeList}" var="rentType" varStatus="rti">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&rt_id=${rentType.rt_id}&id_name=rt_id" id="rt_id${rentType.rt_id}" onclick="a_click(this)">${rentType.rt_name}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="year_div">
                            <ul class="year_ul">
                            	<li><a href="#" id="year_1" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.houseYearList}" var="houseYear" varStatus="hyi">
                                		<li><a href="#" id="year_id${houseYear.hy_id}" onclick="a_click(this)">${houseYear.hy_years}年</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="small_area_div">
                            <ul class="small_area_ul">
                            	<li><a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront" id="sa_id0" onclick="a_click(this)">全部</a></li>
                                <c:forEach items="${requestScope.smallAreaList}" var="smallArea" varStatus="sai">
                                	<c:if test="${sai.index+1<=10}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&sa_id=${smallArea.sa_id}&id_name=sa_id" id="sa_id${smallArea.sa_id}" onclick="a_click(this)">${smallArea.sa_name}</a></li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            <div class="middle_left">
                <div class="house_menus_div">
                    <div class="house_menus_title">
                        <h2>房源列表</h2>
                        <span><a href="#">更多>></a></span>
                    </div>
                    <div class="house_menus_content">
                    	<c:forEach items="${requestScope.houseList}" var="house" varStatus="hi">
                    		<div class="menu_object_div">
	                        	<c:forEach items="${requestScope.houseImgPathList}" var="houseImg" varStatus="hii">
	                        		<c:if test="${hi.index==hii.index}"><img src="${pageContext.request.contextPath}/${houseImg}"/></c:if>
	                        	</c:forEach>
	                            <div class="menu_object_message">
	                            	<p class="object_title"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}&typeName=${requestScope.typeName}">${house.h_title}</a></p>
	                                <p class="object_name"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}&typeName=${requestScope.typeName}">${house.h_name}</a>&nbsp;</p>
	                                <p class="object_desc">[
										<c:forEach items="${requestScope.rentTypeList}" var="rentType">
											<c:if test="${rentType.rt_id==house.rt_id}">${rentType.rt_name}</c:if>
										</c:forEach>]&nbsp;${house.h_proportion}平米，${house.h_floor}/${house.h_all_floor}层</p>
	                                <p class="object_expediter">
										<c:if test="${house.h_ischarge==0}">
											<c:forEach items="${requestScope.personalList}" var="personal">
												<c:if test="${house.h_relevance_id==personal.per_id}">${personal.per_name}</c:if>
													&nbsp;联系电话：<b>${personal.per_tel}</b>
											</c:forEach>
										</c:if>
										<c:if test="${house.h_ischarge==1}">
											<c:forEach items="${requestScope.brokerlList}" var="broker">
												<c:if test="${house.h_relevance_id==broker.b_id}">${broker.b_realname}
													&nbsp;联系电话：<b>${broker.b_tel}</b>
												</c:if>
											</c:forEach>
										</c:if>
									</p>
	                            </div>
	                            <div class="menu_object_type">
	                            	<p><c:forEach items="${requestScope.houseTypeList}" var="houseType">
										<c:if test="${house.ht_id==houseType.ht_id}">${houseType.ht_name}</c:if>
									</c:forEach></p>
	                            </div>
	                            <div class="menu_object_price">
	                            	<p><b>${house.h_price}</b>元/月</p>
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
                        <p>本周已有<font>${requestScope.houseCount}</font>人发布了成都租房房源</p>
                        <div class="role_div">
                            <p class="do_submit" style="text-align:center;"><a href="${pageContext.request.contextPath}/relevance?method=selForFront&state=publish">我要出租</a></p>
                            <div class="do_submit_broker"><a href="${pageContext.request.contextPath}/front/brokeres/web_page/brokerLogin.jsp">我是经纪人>></a></div>
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
        </div>
        <div class="page_div" style="width:984px;margin:0px auto;">
        	<jsp:include page="../../common/pager.jsp">
        		<jsp:param value="${pageContext.request.contextPath}/FrontHouses?method=queryRentOutByPage" name="url"/>
        	</jsp:include>
        </div>
        <div class="b_footer">
            <jsp:include page="../../common/footer.jsp"></jsp:include>
        </div>
    </div>
  </body>
</html>
