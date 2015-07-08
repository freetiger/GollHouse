<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${param.flag==null}">
	<jsp:forward page="/FrontHouses?method=queryIndex"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <title>${applicationScope.Oversystems.sys_name} - 租房首页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/front/houses/css/index_css.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script type="text/javascript">
    	function rentOut(){
    		window.location.href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id";
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
                    <li id="index">首&nbsp;页</li><li id="border_1"></li>
                    <li id="out_rent" onclick="rentOut()">出租房源</li><li id="border_2"></li>
                    <li id="personal_house" onclick="personal()">个人房源</li><li id="border_3"></li>
                    <li id="seek_rent" onclick="seekRent()">求&nbsp;租</li><li id="border_4"></li>
                    <li id="company" onclick="company()">中介公司</li><li id="border_5"></li>
                    <li id="broker" onclick="broker()">经纪人</li>
                </ul>
            </div>
            <div class="display_count">成都租房网有<font>${requestScope.houseCount}</font>套出租房正在出租，个人房源共有<font>${requestScope.personalCount}</font>套。</div>
            <div class="middle_left">
            	<div class="terms_div">
                	<div class="terms_title_div">
                        <font id="area_font">区域搜索：</font>
                        <font id="price_font">价格：</font>
                        <font id="house_type_font">户型：</font>
                        <font id="feature_font">特色：</font>
                        <font id="year_font">年份：</font>
                        <font id="small_area_font">小区：</font>
                    </div>
                    <div class="terms_content_div">
                        <div class="area_div">
                            <ul class="area_ul">
                            	<li><a href="#" id="area_1">全部</a></li>
                                <c:forEach items="${requestScope.areaList}" var="area" varStatus="ai">
                                	<c:if test="${ai.index+1==7}">
                                 		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="area_id${area.a_id}">其他区县>></a></li>
                                 	</c:if>
                                 	<c:if test="${ai.index+1<7}">
                                 		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=a_id&a_id=${area.a_id}" id="area_id${area.a_id}">${area.a_name}</a></li>
                                 	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="price_div">
                            <ul class="price_ul">
                            	<li><a href="#" id="price_1">全部</a></li>
                                <c:forEach items="${requestScope.rentMoneyList}" var="rentMoney" varStatus="rmi">
                                	<c:if test="${rmi.index+1==4}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="price_id${rentMoney.rm_id}">其他价格>></a></li>
                                	</c:if>
                                	<c:if test="${rmi.index+1<4}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=rm_id&rm_id=${rentMoney.rm_id}" id="price_id${rentMoney.rm_id}">${rentMoney.rm_count}元</a></li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="house_type_div">
                            <ul class="house_type_ul">
                            	<li><a href="#" id="house_type_1">全部</a></li>
                                <c:forEach items="${requestScope.houseTypeList}" var="houseType" varStatus="hti">
                                	<c:if test="${hti.index+1==5}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="house_type_id${houseType.ht_id}">其他房型>></a></li>
                                	</c:if>
                                	<c:if test="${hti.index+1<5}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=ht_id&ht_id=${houseType.ht_id}" id="house_type_id${houseType.ht_id}">${houseType.ht_name}</a></li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="feature_div">
                            <ul class="feature_ul">
                            	<li><a href="#" id="feature_1">全部</a></li>
                                <c:forEach items="${requestScope.rentTypeList}" var="rentType" varStatus="rti">
                                	<c:if test="${rti.index+1==6}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="feature_id${rentType.rt_id}">其他特色>></a></li>
                                	</c:if>
                                	<c:if test="${rti.index+1<6}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=rt_id&rt_id=${rentType.rt_id}" id="feature_id${rentType.rt_id}">${rentType.rt_name}</a></li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="year_div">
                            <ul class="year_ul">
                            	<li><a href="#" id="year_1">全部</a></li>
                                <c:forEach items="${requestScope.houseYearList}" var="houseYear" varStatus="hyi">
                                	<c:if test="${hyi.index+1==5}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="year_id${houseYear.hy_id}">其他年份>></a></li>
                                	</c:if>
                                	<c:if test="${hyi.index+1<5}">
                                		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=hy_id&hy_id=${houseYear.hy_id}" id="year_id${houseYear.hy_id}">${houseYear.hy_years}年</a></li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="small_area_div">
                            <ul class="small_area_ul">
                            	<li><a href="${pageContext.request.contextPath}/SmallAreas?method=selForFront" id="small_area_1">全部</a></li>
                                <c:forEach items="${requestScope.smallAreaList}" var="smallArea" varStatus="sai">
                                	<c:if test="${sai.index+1==6}">
                                 		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id" id="small_area_id${smallArea.sa_id}">其他小区>></a></li>
                                 	</c:if>
                                 	<c:if test="${sai.index+1<6}">
                                 		<li><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=sa_id&sa_id=${smallArea.sa_id}" id="small_area_id${smallArea.sa_id}">${smallArea.sa_name}</a></li>
                                 	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="interested_house_div">
                    <div class="interested_house_title">
                        <h2>您可能感兴趣的房子</h2>
                        <span><a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=all_id">更多成都租房>></a></span>
                    </div>
                    <div class="interested_house_content">
                        <c:forEach items="${requestScope.interestList}" var="interest" varStatus="ii">
                        	<div class="interested_house_object" id="s${ii.index+1}" <c:if test="${ii.index+1==5}"> style="margin-right:0;"</c:if>>
                        		<c:forEach items="${requestScope.interestImgList}" var="interestImg" varStatus="iii">
                        			<c:if test="${iii.index==ii.index}">
	                            		<img src="${pageContext.request.contextPath}/${interestImg.hi_url}"/>
	                            	</c:if>
                        		</c:forEach>
	                            <p class="object_title"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${interest.h_id}">${interest.h_name}</a></p>
	                            <p class="object_desc">
								<c:forEach items="${requestScope.houseTypeList}" var="houseType">
	                            	<c:if test="${houseType.ht_id==interest.ht_id}">${houseType.ht_name}</c:if>
	                            </c:forEach>
								,${interest.h_proportion}㎡</p>
	                            <p class="object_price">${interest.h_price}元/月</p>
	                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="new_house_div">
                    <div class="new_house_title">
                        <h2>最新个人房源</h2>
                        <span>精选<font>${requestScope.personalCount}</font>条个人出租房源供您挑选&nbsp;<a href="${pageContext.request.contextPath}/FrontHouses?method=queryPersonal">更多>></a></span>
                    </div>
                    <div class="new_house_content">
                    	<c:forEach items="${requestScope.houseList}" var="house" varStatus="hi">
	                        <div class="new_house_object">
	                            <img src="c"/>
	                            <span class="new_house_desc"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}" class="desc_content">${house.h_title}</a>&nbsp;
	                            <c:forEach items="${requestScope.rentOutList}" var="rentOut">
                               		<c:if test="${rentOut.h_id==house.h_id}">
                               			<c:forEach items="${requestScope.areaList}" var="area">
                               				<c:if test="${area.a_id==rentOut.a_id}">
												<a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=a_id&a_id=${area.a_id}" class="desc_area">${area.a_name}</a>
											</c:if>
                               			</c:forEach>
                               		</c:if>
                               	</c:forEach>
	                            &nbsp;</span>
	                            <span class="new_house_type">
	                            <c:forEach items="${requestScope.houseTypeList}" var="houseType">
	                            	<c:if test="${houseType.ht_id==house.ht_id}">
		                            	<a href="${pageContext.request.contextPath}/FrontHouses?method=queryRentOut&id_name=ht_id&ht_id=${houseType.ht_id}" id="house_type_id${houseType.ht_id}">
		                            		${houseType.ht_name}
		                            	</a>
	                            	</c:if>
	                            </c:forEach>
	                            </span>
	                            <span class="new_house_price"><font>${house.h_price}</font>&nbsp;元/月</span>
	                            <span class="new_house_time">${house.h_publictime}</span>
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
        <div class="b_footer">
            <jsp:include page="../../../front/common/footer.jsp"></jsp:include>
        </div>
    </div>
</body>
</html>
