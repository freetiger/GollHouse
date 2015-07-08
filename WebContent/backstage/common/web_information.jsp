<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>网站基本信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <style>
*{	margin:0px;	paddding:0px;text-decoration: none;list-style:none;
	}
	.main{
		width:80%;height:100%;	border:#ccc 1px solid;margin:0px auto;background:#E7F8FF
	}
	td{
		height:50px;	border-bottom:#CCC 1px dashed;
		}
	.t_td{
			text-align:center;	font-size:15px;	font-family:"宋体";
		}
	input{		
		width:300px;	
		}
	#framed{
		width:200px;height:30px;	
	}
	.logo_img_div{
		float:left;
		width:20%;
		height:20px;
		position:relative;
		top:50%;
		margin-top:-10px;
		border:1px red solid;
	}
</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function logoBack(mark,path){
			$("#logo").val(path);
		}
		function check(){
			if($("#name").val()==""||$("#name").val().length==0){
				alert("网站名称不能为空");
				return false;
			} 
			if($("#dns").val()==""||$("#dns").val().length==0){
				alert("网站域名不能为空");
				return false;
			} 
			if($("#tag").val()==""||$("#tag").val().length==0){
				alert("关键字不能为空");
				return false;
			} 
			if($("#logo").val()==""||$("#logo").val().length==0){
				alert("LOGO不能为空");
				return false;
			} 
			if($("#qq").val()==""||$("#qq").val().length==0){
				alert("QQ不能为空");
				return false;
			} 
			if($("#tel").val()==""||$("#tel").val().length==0){
				alert("客服电话不能为空");
				return false;
			} 
			if($("#date").val()==""||$("#date").val().length==0){
				alert("建站时间不能为空");
				return false;
			} 
			if($("#infos").val()==""||$("#infos").val().length==0){
				alert("描述不能为空");
				return false;
			} 
			alertDiv();
			$("#div").css("display","block");
			$("#div").fadeOut(2000);
			return true;
		}
		function alertDiv(){
		document.getElementById("div").style.top=($(document).scrollTop()+document.documentElement.clientHeight/3)+"px";
		}
	</script>
</head>

<body>
	<div class="main">
    	<form method="post" action="Systems?method=update&status=2" onsubmit="return check()"><!-- 提交网站信息 -->
    		<div class="table">
	        	<table width="70%" height="80%" cellspacing="0" >
	            	<caption><h2>GOLL网站基本信息</h2></caption>
	            	<tr>
	                	<td class="t_td">网站名称:</td><td><input id="name" type="text" name="name" value="${sessionScope.systems.sys_name}"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">网站域名:</td><td><input type="text" id="dns" name="dns" value="${sessionScope.systems.sys_dns}"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">关键字 :</td><td><input type="text" id="tag" name="tag" value="${sessionScope.systems.sys_tag}"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">LOGO:</td><td><input type="text" id="logo" name="logo" value="${sessionScope.systems.sys_logo}" readonly="readonly"><iframe src="${pageContext.request.contextPath}/backstage/common/upload.jsp?mark=1&fun=logoBack&type=1" id="framed"  frameborder="0"></iframe></td>
	                </tr>
	                <tr>
	                	<td class="t_td">QQ:</td><td><input type="text" id="qq" name="qq" value="${sessionScope.systems.sys_qq}"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">客服电话:</td><td><input type="text" id="tel" name="tel" value="${sessionScope.systems.sys_tel}"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">建站时间:</td><td><input type="text" id="date" name="date" value="${sessionScope.systems.sys_date}" onclick="WdatePicker()" class="Wdate"></td>
	                </tr>
	                <tr>
	                	<td class="t_td">描  述:</td><td><textarea name="infos" id="infos" rows="5" cols="50" style="resize:none;" >${sessionScope.systems.sys_infos}</textarea></td>
	                </tr>
	            </table>
            </div>
            <!--
            <div class="logo_img_div"><img src="" id="logo_img"/></div>
            -->
            <div id="div" onclick="$(this).fadeOut(2000)" style="width:100px;height:25px;left:50%;top:50%;position: absolute;margin-left: -100px;margin-top: -25px;background: #1B99DE;z-index:2000;text-align: center;color: blue;display: none;">成功</div>
            <c:if test="${param.status==2}">
          	  <input type="submit" value="保存" style="width:80px;height:30px;margin-left:200px;margin-top:20px;"/>
          	  <input type="hidden" value="${sessionScope.systems.sys_id}"  name="id"/>
       	    </c:if>
        </form>    
    </div>
</body>

</html>
