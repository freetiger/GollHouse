<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>左侧页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/frame/css/left_css.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script>
		var id="";
		function initHeight(){
			$("#main_div").css("height",window.screen.availHeight-176-28+"px");
			$("#menu_ul_li_1").css("background","url(../img/left_li_bg.png)");
			id=$("#menu_ul_li_1").attr("id");
		}
		function clickEven(obj){
			var lis=$("li");
			for(var i=0;i<lis.length;i++){
				if($(lis[i]).attr("id")==$(obj).attr("id")){
					id=$(lis[i]).attr("id");
					$(obj).css("background","url(../img/left_li_bg.png)");
				}else{
					$(lis[i]).css("background","none");
				}
			}
		}
		function mouseOverEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("background","url(../img/left_li_hover_bg.png)");
			}
		}
		function mouseMoveEven(obj){
			if($(obj).attr("id")!=id){
				$(obj).css("background","none");
			}
		}
		function lastLogin(){
			var url="${pageContext.request.contextPath}/Historys";
			par="method=queryTime";
			$.ajax({
				type:"POST",
				url:url,
				data:par,
				success:function(msg){
					alert(msg);
				}
			});
		}
		function savePwd(){
			var url="${pageContext.request.contextPath}/Managers";
			par="method=updatePwd&pwd="+encodeURI(document.getElementById("pwd").value)+"&newPwd="+encodeURI(document.getElementById("newPwd").value)+"&newPwd2="+encodeURI(document.getElementById("newPwd2").value);
			$.ajax({
				type:"POST",
				url:url,
				data:par,
				success:function(msg){
					if(msg==0)
						alert("密码输入错误！");
					else if(msg==1)
						alert("两次输入的新密码不一样！");
					else if(msg==2){
						alert("修改成功");		
						$("#div").css("display","none");
					}
				}
			});
		}
	</script>
  </head>
  
  <body onLoad="initHeight()">
	<div id="main_div">
		<div class="common">
	    	<p class="main_title">
	        	公共菜单
	        </p>
	        <div id="div" style="width:100px;height:250px;margin:0px auto;top:30%;position: absolute;background: #1B99DE;z-index:2000;text-align: center;;display: none;left:20px;color: purple">
	        	旧的密码：<input type="password" id="pwd" style="width: 80px">
	        	新的密码：<input type="password" id="newPwd" style="width: 80px">
	        	确认密码：<input type="password" id="newPwd2" style="width: 80px">
	           <input type="button" value="保存" onclick="savePwd();">
	           <input type="button" value="关闭" onclick="$('#div').css('display','none');">
	        </div>
	        <div id="main_content">
	        	<ul id="menu_ul">
	            	<li id="menu_ul_li_1" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="javascript:;" onclick="$('#div').css('display','block');">修改密码</a></li>
	            	<li id="menu_ul_li_2" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="${pageContext.request.contextPath}/backstage/common/calendar.html" target="right">查看日历</a></li>
	            	<li id="menu_ul_li_3" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="javascript:;" onclick="lastLogin()">上次登陆</a></li>
	            </ul>
	        </div>
        </div>
        <div class="personal">
        	<p class="main_title">
	        	个人菜单
	        </p>
	        <div id="personal_content">
	        	<ul id="personal_menu_ul">
	        	<c:forEach items="${sessionScope.menus}" var="menu" varStatus="i">
	        		<li id="personal_menu_ul_li_${i.index+1}" onClick="clickEven(this)" onMouseOver="mouseOverEven(this)" onMouseOut="mouseMoveEven(this)"><a href="${pageContext.request.contextPath}/${menu.m_url}" target="right"><img src="${pageContext.request.contextPath}/img/folder.gif"/>${menu.m_name}</a></li>
	        	</c:forEach>
	           </ul>
	        </div>
        </div>
    </div>
</body>
</html>
