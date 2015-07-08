<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>修改密码</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/brokerFrame/css/updatePassword_css.css"/>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script>
		function init(){
			$("#oldPwd").val("");
			var main_div=document.getElementById("main_div");
			main_div.style.width=window.screen.availWidth-154-24+"px";
			main_div.style.height=window.screen.availHeight-160-24+"px";
		}
		var num=60;
		var timer="";
		function prepUpdatePwd(){
		var url="${pageContext.request.contextPath}/Brokeres";
		par="method=preupdatePwd";
		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				var data=msg;
				timer=setInterval("setBtnVal()", 1000);
				alert(data);
				}
			});
		}
		function setBtnVal(){
			$("#btn").val("剩余:"+(--num)+"s");
			if(num==0){
				window.clearInterval(timer);
				$("#btn").val("获取验证码");
				num=60;
			}
		}
		function UpdatePwd(){
		var url="${pageContext.request.contextPath}/Brokeres";
		par="method=updatePwd&oldPwd="+encodeURI(document.getElementById("oldPwd").value)+"&newPwd="+encodeURI(document.getElementById("newPwd").value)+"&newPwd2="+encodeURI(document.getElementById("newPwd2").value)+"&code="+encodeURI(document.getElementById("code").value);
		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				alert(msg);
				}
			});
		}
		var SubmitOrHidden = function(evt){
		evt = window.event || evt;
		    if(evt.keyCode==13){//如果取到的键值是回车
	          //do something      
	      		UpdatePwd();
	    }
	}
	window.document.onkeydown=SubmitOrHidden;
	</script>
</head>

<body onLoad="init()">
	<div id="main_div">
    	<div class="title"><font>${sessionScope.broker.b_realname }</font>&nbsp;<b>会员密码、安全问答和安全设置</b>(注意：修改后可能需要重新登录)</div>
    	<div class="myDiv">
    		<form action="" id="form1">
	        <div class="old_pwd_div">
	            <p class="old_pwd_p">原密码：<input type="password" name="oldPwd" id="oldPwd"/></p>
	            <p class="code">邮箱验证码：<input type="text" name="code" id="code"/><input type="button" onclick="prepUpdatePwd()" id="btn" value="获取验证码" style="width: 100px">
	        </div>
	        <div class="new_pwd_div">
	            <p class="new_pwd_p">新密码：<input type="password" name="newPwd" id="newPwd"/></p>
	            <p class="new_pwd_again">新密码确认：<input type="password" name="newPwd2"  id="newPwd2"/></p>
	            <input type="button" value="确认修改" id="submit" onclick="UpdatePwd()"/>
	        </div>
	        </form>
       	</div>
       	<div class="myPicture"><img src="${pageContext.request.contextPath}/${sessionScope.broker.b_head_img }" style="width: 100%;height: 100%"/></div>
    </div>
</body>
</html>