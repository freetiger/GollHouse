<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.goll.service.ICompanysService"%>
<%@page import="cn.goll.service.impl.CompanysServiceImpl"%>
<%@page import="cn.goll.entity.Companys"%>
<!DOCTYPE HTML >
<html>
  <head>
    
 <title>经纪人注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/front/brokeres/css/brokerLogin.css"/>
</head>
<body>
	<div class="title">
    	<div class="logo"><img src="${pageContext.request.contextPath}/front/brokeres/imgs/logo_index.png" style="width:240px;height:80px;float:left"/><p style="width:100px;height:20px;float:right;margin-top:60px;"><a href="${pageContext.request.contextPath}/front/houses/web_page/index.jsp">首页</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath }/front/brokeres/web_page/brokerLogin.jsp">登陆</a></p></div>
    </div>
    <!--注册-->
    <div class="b_login">
    	<p class="b_title">欢迎注册${applicationScope.Oversystems.sys_name }经纪人用户<span style="font-size:13px;float:right">请仔细填写</span></p>
    	<form method="post" action="${pageContext.request.contextPath}/Brokeres?method=register" id="formNam">
        <ul>
           <li><span class="b_context">用&nbsp;户&nbsp;名:</span><input type="text" name="b_name" id="name" onFocus="name_focus()" onkeyup="checkName()"/><span id="b_name"></span></li>
           <li><span class="b_context">真实姓名:</span><input type="text" name="b_realname" id="realname" onFocus="realname_focus()" onBlur="realname_blur()"/><span id="b_realname"></span></li>
           <li><span class="b_context">身份证号:</span><input type="text" name="b_card" maxlength="18" id="card" onFocus="card_focus()" onBlur="card_blur()"/><span id="b_card"></span></li>
           <li><a></a><span class="b_context">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span><input type="text" name="b_email" id="email" onFocus="email_focus()"  onkeyup="checkEmail()"/><span id="b_email"></span></li>
           <li><span class="b_context">联系电话:</span><input type="text" name="b_tel" id="tel" onFocus="tel_focus()" onBlur="tel_blur()"/><span id="b_tel"></span></li> 
           <li><span class="b_context">所在公司:</span><select name="c_id" id="con">
           										<% ICompanysService cs=new CompanysServiceImpl();
           										   List<Companys> list=cs.queryAllCompanys("1");
           										   for(int i=0;i<list.size();i++){
           												Companys c=list.get(i);
           										%>							
           											<option value="<%=c.getC_id() %>"><%=c.getC_name() %></option><!--从数据库读取-->
           										<%} %>	
           										</select><span id="b_company"></span></li>  
           <div class="info"><span class="b_context">个人简介:</span>
           			<textarea id="b_infos" name="b_infos" >&nbsp;&nbsp;这个人很懒，什么都没有留下。</textarea>
           </div>
        </ul>
       	  <div class="sub"><input type="button" value="提交" onClick="submites()"></div><font color="#FF0000"></font>
        </form>
        <iframe src="${pageContext.request.contextPath}/front/common/footer.jsp" style="height:130px" class="ifram" frameborder="0" scrolling="no"></iframe>
    </div>  
    <script type="text/javascript">
	//正则表达式
		
		var r_card = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; //身份证
		var r_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/; //邮箱
		var r_phone=/^[0-9]{1,11}$/;//电话
		var r_name=/^\w{3,15}$/;
		function name_focus(){
			$("#b_name").html("<font color='green'>&nbsp;请输入你的呢称(以字母，下划线或者数字组成)</font>");
			$("#b_name").parent().css("list-style","none");
		}
		function name_blur(){
			if(r_name.test($("#name").val())){
				$("#b_name").html("&nbsp;<img style='width:25px;height:25px;' src='../imgs/true.png'/>");
				return true;
			}
			else{
				$("#b_name").html("<font color='red'>请按正确格式输入</font>");
				return false;
			}
		}
		
		function realname_focus(){
			 $("#b_realname").html("<font color='green'>&nbsp;请输入真实有效的姓名</font>");
			$("#b_realname").parent().css("list-style","none");
		}
		function realname_blur(){
			if($("#realname").val()!=""){
				$("#b_realname").html("&nbsp;<img style='width:25px;height:25px;' src='../imgs/true.png'/>");
				return true;
			}
			else{
				$("#b_realname").html("<font color='red'>请按正确格式输入</font>");
				return false;
			}
			
		}
		
		function card_focus(){
			$("#b_card").html("<font color='green'>&nbsp;请输入身份证号</font>");
			$("#b_card").parent().css("list-style","none");
		}
		function card_blur(){
			if(r_card.test($("#card").val())){
				$("#b_card").html("&nbsp;<img style='width:25px;height:25px;' src='../imgs/true.png'/>");
				return true;
			}
			else{
				$("#b_card").html("<font color='red'>请按正确格式输入</font>");
				return false;
			}			
		}
		
		function email_focus(){
			$("#b_email").html("<font color='green'>&nbsp;邮箱可以找回密码哟</font>");
			$("#b_email").parent().css("list-style","none");
		}
		function email_blur(){
			if(r_email.test($("#email").val())){
				$("#b_email").html("&nbsp;<img style='width:25px;height:25px;' src='../imgs/true.png'/>");
				return true;
			}
			else{
				$("#b_email").html("<font color='red'>请按正确格式输入</font>");
				return false;
			}			
		}
		
		function tel_focus(){
			$("#b_tel").html("<font color='green'>&nbsp;联系电话可以提高你的业务哟</font>");
			$("#b_tel").parent().css("list-style","none");
		}
		function tel_blur(){
			if(r_phone.test($("#tel").val())){
				$("#b_tel").html("&nbsp;<img style='width:25px;height:25px;' src='../imgs/true.png'/>");
				return true;
			}
			else{
				$("#b_tel").html("<font color='red'>请按正确格式输入</font>");
				return false;
			}
			
		}
		
		var times;
		var t=5;
		function submites(){
			if(name_blur()&&realname_blur()&&card_blur()&&email_blur()&&tel_blur()){
				getDiv();				
			}
		}
    	function getDiv(){
			var addDiv="<div style='width:100%;height:100%;background:#ccc;position:absolute;left:0px;top:0px; background:none;' id='se'><div class='addDiv'style='height:280px;width:400px'>注册成功,<font color='green'>默认密码</font>已经前往你的邮箱。<br><font color='#FF0000'>"+t+"</font>秒后前往登陆页登陆吧！<br>如果您一直收不到激活邮件，请检查：1. 请确认是否填写正确的邮箱地址："+encodeURI(document.getElementById("email").value)+" 2.请注意查看您邮箱中的垃圾邮件，可能 oschina 的邮件被误杀了</div>";
			$("body").append(addDiv);			
			$("#se").css("background","url(../imgs/opacitis.png) repeat");			
			t--;
			
			times=setTimeout("getDiv()",1000);
			if(t<=0){
				clearTimeout(times);
				$("#formNam").submit();//提交表单
			}	
		}
		function checkName(){
		document.getElementById("b_name").innerHTML="<img src='${pageContext.request.contextPath }/img/ajax-loader.gif'/><font color='red'>正在验证此用户是否被注册,请稍后。。。</font>";
		var url="${pageContext.request.contextPath}/Brokeres";
		par="method=check&b_email=&b_name="+encodeURI(document.getElementById("name").value);
		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				var data=msg;
				document.getElementById("b_name").innerHTML="<font color='red'>"+data+"</font>";
				}
			});
		}	
		function checkEmail(){
		document.getElementById("b_email").innerHTML="<img src='${pageContext.request.contextPath }/img/ajax-loader.gif'/><font color='red'>正在验证此邮箱是否被注册,请稍后。。。</font>";
		var url="${pageContext.request.contextPath}/Brokeres";
		par="method=check&b_name=&b_email="+encodeURI(document.getElementById("email").value);
		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				var data=msg;
				document.getElementById("b_email").innerHTML="<font color='red'>"+data+"</font>";
				}
			});
		}
    </script>
 
</body>
</html>
