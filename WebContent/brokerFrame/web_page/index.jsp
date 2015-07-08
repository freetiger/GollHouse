<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/brokerFrame/css/index_css.css"/>
</head>

<body>
	<div class="main_div">
    	<div class="personal_messages">
        	<div class="left_div">
            	<img src="${pageContext.request.contextPath}/${sessionScope.broker.b_head_img }" id="header_img"/>
                <img src="" class="level_img"/>
                <p class="level_refresh"><a href="#">更新会员等级</a></p>
                <p class="name"><font>${sessionScope.broker.b_name }</font>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/brokerFrame/web_page/updateData.jsp">修改资料</a></p>
                <p class="vip">GOLL会员</p>
                <p class="integral">会员积分：<font>${sessionScope.broker.b_grade }</font>分</p>
            </div>
            <div class="right_div">
                <img src="" />
            	<div class="right_left_div">
                    <p class="house_count">房源数量：1200</p>
                    <p class="smallArea_count">小区数量：100</p>
                    <p class="rentOut_count">出租记录：(132)</p>
                    <p class="update_password"><a href="${pageContext.request.contextPath }/brokerFrame/web_page/updatePassword.jsp">修改密码</a></p>
                </div>
                <div class="right_right_div">
                	<p class="upload_house"><a href="${pageContext.request.contextPath }/brokerFrame/web_page/addHouse.jsp">上传房源</a></p>
                    <p class="goll_qq">企业QQ：838014177</p>
                    <p class="online_time">在线时间：8：00-22：00</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>