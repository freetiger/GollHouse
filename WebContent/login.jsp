<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML >
<html>
  <head>    
  <title>登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<style>
*{margin:0px;padding:0px; list-style:none; text-decoration:none;}
.main{
	width:600px;height:500px; position:absolute;top:50%;left:50%;margin-left:-300px;margin-top:-250px;
}
.left{
	width:250px;height:200px;float:left; background:url(${pageContext.request.contextPath}/img/index.jpg) no-repeat;
}
.right{
	width:345px;height:200px;float:left;border-left:#CCC 1px dashed;background:#FFF9E7;	
}
.copyright{
	width:100%;height:30px;font-size:14px;color:#999; text-align:center; position:absolute;top:470px;
}
#welcome{
	width:100%;height:30px;font-weight:bolder;font-size: 20px;text-align:center;	
	}
input{width:120px;height:18px;float:left}
.login{
	width:300px;height:30px;line-height:30px;margin-left:20px;margin-top:5px;
	}
.num{width:125px;height:30px;float:left}
#code{width:60px;height:23px;float:left; cursor:pointer;}
#sp{width:100px;height:30px;float:left;font-size:12px;color:blue;cursor:pointer;}
.txt{width:60px;height:25px; display:block;float:left;text-align:center}
.sub{
	width:110px;height:30px;margin-left:100px;margin-top:30px;border:none;background:url(${pageContext.request.contextPath}/img/anniu.jpg) center no-repeat;font-weight:bolder;color:#FFF
}
</style>
</head>

<body>
	<div class="main">
    	<p id="welcome"> 欢迎登陆${applicationScope.Oversystems.sys_name}</p>
    	<div class="left"></div>
    	<div class="right">
        	<form method="post" action="Managers?method=login" id="form2" >
            	<p class="login" style="margin-top:20px;"><span class="txt">用户名:</span><input type="text" name="uname" maxlength="15" id="uname" value="test01"></p>
                <p class="login"><span class="txt">&nbsp;密&nbsp;码:&nbsp;</span><input type="password" name="pwd" maxlength="15" size="15" id="pwd" value="test01"></p>
                <div class="login"><p class="num"><span class="txt">验证码:</span><input type="text" name="code" maxlength="5" style="width:50px;" id="valicode"></p>
                	<img id="code" src="${pageContext.request.contextPath}/code.do" title="看不清，换一张"	onclick="changeImg()" /><span id="sp" onClick="changeImg()">看不清,换一张</span></div>
           		<input type="button" value="登&nbsp;陆" class="sub" onclick="checkLogin()"/>
            </form>        
        </div>
        <div class="copyright"><p><span style="font-size:16px">&copy;</span>CopyRight 2013 ${applicationScope.Oversystems.sys_name}版权所有</p></div>
    </div>
  	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
	function checkLogin(){
		var uname=$("#uname").val();
		var pwd=$("#pwd").val();
		if(uname==null ||uname==""||pwd==null||pwd==""){
				alert("用户名密码不能为空");
			return;
			}
		var url="${pageContext.request.contextPath}/Managers";
		par="method=checklogin&uname="+encodeURI(document.getElementById("uname").value)+"&pwd="+encodeURI(document.getElementById("pwd").value)+"&code="+encodeURI(document.getElementById("valicode").value);
		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				var data=msg;
				if(data==1){
					alert("输入密码有误，请仔细核对");
					}
				if(data==2){
					alert("没有此用户，请仔细核对");
					}
				if(data==3){
					alert("验证码输入错误！");
					}
				if(data==4){
					alert("该用户已登录！");
					}		
				if(data==0){
					$("#form2").submit();
					}	
				}
			});
		}
    function changeImg(){
 		var time=new Date();
 		var src="${pageContext.request.contextPath}/code.do?time="+time.getTime();
 		$("#code").attr("src",src);
	}
	var SubmitOrHidden = function(evt){
		evt = window.event || evt;
		    if(evt.keyCode==13){//如果取到的键值是回车
	          //do something      
	      		checkLogin();
	    }
	}
	window.document.onkeydown=SubmitOrHidden;
 </script>
</body>
</html>
