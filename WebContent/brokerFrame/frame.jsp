<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>GOLL 经纪人后台</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/brokerFrame/css/brokerBackstage_index_css.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script>
		var id="";
    	function init(){
			var date=new Date();
			$("#year").html(date.getFullYear());
			$("#month").html(date.getMonth()+1);
			$("#day").html(date.getDate());
			id=$("#main_menu_1").attr("id");
			$("#left_div").css("height",window.screen.availHeight-130-28+"px");
			$("#left_ul_li_1").css("background","url(../img/left_li_bg.png)");
			id=$("#menu_ul_li_1").attr("id");
			$("#frame").css("width",window.screen.availWidth-162+"px");
			$("#frame").css("height",window.screen.availHeight-130-28+"px");
		}
		function clickTop(obj){
			var lis=document.getElementById("main_menus_ul").childNodes;
			mouseMoveEven(obj);
			for(var i=0;i<lis.length;i++){
				if($(lis[i]).children().attr("id")==$(obj).attr("id")){
					id=$(lis[i]).attr("id");
					$(obj).parent().css("background","#0048b4");
					$(obj).css("color","white");
				}else{
					$(lis[i]).css("background","none");
					$(lis[i]).children().css("color","black");
				}
			}
			
		}
		function mouseOverEvenTop(obj){
			if($(obj).attr("id")!=id){
				$(obj).css({width:"-=2px",borderLeft:"1px #999 solid",borderTopLeftRadius:"10px",borderTopRightRadius:"10px",borderRight:"1px #999 solid"});
			}
		}
		function mouseMoveEvenTop(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("border","0");
				$(obj).css({width:"+=2px"});
			}
		}
		function clickLeft(obj){
			var lis=$("#menu_ul>li");
			for(var i=0;i<lis.length;i++){
				if($(lis[i]).attr("id")==$(obj).attr("id")){
					id=$(lis[i]).attr("id");
					$(obj).css("background","url(img/left_li_bg.png)");
				}else{
					$(lis[i]).css("background","none");
				}
			}
		}
		function mouseOverEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("background","url(img/left_li_hover_bg.png)");
			}
		}
		function mouseMoveEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("background","none");
			}
		}
		function logout(){
			return confirm("是否注销?");
		}
	</script>
</head>

<body onLoad="init()">
    <!-- 顶部页面 -->
	<div class="main_div">
        <div class="bottom_div">
        	<img src="${pageContext.request.contextPath }/${applicationScope.Oversystems.sys_logo}" class="logo"/>
        	<p class="welcome">欢迎：<font>${sessionScope.broker.b_realname }</font></p>
        	<p class="integral">您的信誉积分：<font>${sessionScope.broker.b_grade }</font></p>
            <p class="today">今天是：<span id="year"></span>年<span id="month"></span>月<span id="day"></span>日</p>
            <p class="function"><a href="javascript:;" onclick="history.go(-1);">后退</a>&nbsp;<a href="javascript:;" onclick="history.go(1);">前进</a>&nbsp;<a href="${pageContext.request.contextPath}/Brokeres?method=logout" target="_top" onclick="return logout();">注销</a></p>
        </div>
    </div>
    <!-- 左侧页面 -->
    <div id="left_div">
		<div class="common">
	    	<p class="left_title">
	        	公共菜单
	        </p>
	        <div id="left_content">
	        	<ul id="menu_ul">
	            	<li id="menu_ul_li_1" onClick="clickLeft(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="brokerFrame/web_page/index.jsp" target="right">首页</a></li>
	            	<li id="menu_ul_li_1" onClick="clickLeft(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="brokerFrame/web_page/addHouse.jsp" target="right">添加房源</a></li>
	            	<li id="menu_ul_li_2" onClick="clickLeft(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="brokerFrame/web_page/updatePassword.jsp" target="right">修改密码</a></li>
	            	<li id="menu_ul_li_2" onClick="clickLeft(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="brokerFrame/web_page/updateData.jsp" target="right">修改资料</a></li>
	            	<li id="menu_ul_li_2" onClick="clickLeft(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseBybid&url=houseAndImgList" target="right">我的房源</a></li>
	            </ul>
	        </div>
        </div>
    </div>
    <!-- 右侧页面 -->
    <iframe src="${pageContext.request.contextPath }/brokerFrame/web_page/index.jsp" id="frame" frameborder="no" border="no" framespacing="0" name="right"></iframe>
</body>
</html>