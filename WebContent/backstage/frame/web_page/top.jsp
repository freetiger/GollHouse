<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>顶部页面</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/frame/css/top_css.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script>
		var id="";
    	function initTime(){
			var date=new Date();
			$("#year").html(date.getFullYear());
			$("#month").html(date.getMonth()+1);
			$("#day").html(date.getDate());
			id=$("#main_menu_1").attr("id");
		}
		function clickEven(obj){
			var lis=document.getElementById("main_menus_ul").childNodes;
			mouseMoveEven(obj);
			for(var i=0;i<lis.length;i++){
				if($(lis[i]).children().attr("id")==$(obj).attr("id")){
					id=$(lis[i]).children().attr("id");
					$(obj).parent().css("background","#0048b4");
					$(obj).css("color","white");
				}else{
					$(lis[i]).css("background","none");
					$(lis[i]).children().css("color","black");
				}
			}
		}
		function mouseOverEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css({width:"-=2px",borderLeft:"1px #999 solid",borderTopLeftRadius:"10px",borderTopRightRadius:"10px",borderRight:"1px #999 solid"});
			}
		}
		function mouseMoveEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("border","0");
				$(obj).css({width:"+=2px"});
			}
		}
		function logout(){
			return confirm("是否注销?");
		}
    </script>
</head>

<body onLoad="initTime()">
	<div class="main_div">
    	<div class="top_div">
        	<img src="../img/backstage_logo.png" class="logo"/>
            <div class="main_menus_div">
                <ul id="main_menus_ul">
              		<li style="background:#0048b4;"><a href="right.jsp" target="right" id="main_menu_1" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)" style="color:white;">首页</a></li>
                	<c:forEach items="${sessionScope.menuList}" var="topmenu" varStatus="i">
                	  <c:if test="${topmenu.f_id==0}">
                		  <li><a href="${pageContext.request.contextPath}/${topmenu.m_url}" target="left" id="main_menu_${i.index+2}" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)">${topmenu.m_name}</a></li>
                	  </c:if>
  	              	</c:forEach>
                </ul>
            </div>
        </div>
        <div class="bottom_div">
        	<p class="welcome">欢迎：<img src="c"/><font>${sessionScope.manager.uname}</font><font>${sessionScope.managerPower.p_name}</font></p>
            <p class="today">今天是：<span id="year"></span>年<span id="month"></span>月<span id="day"></span>日</p>
            <p class="function"><a href="javascript:;" onclick="history.go(-1);">后退</a>&nbsp;<a href="javascript:;" onclick="history.go(1);">前进</a>&nbsp;<a href="${pageContext.request.contextPath}/Managers?method=logout" target="_top" onclick="return logout();">注销</a></p>
        </div>
    </div>
</body>
</html>