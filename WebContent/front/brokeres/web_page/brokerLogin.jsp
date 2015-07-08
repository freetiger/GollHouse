<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
	<head>

		<title>登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/front/brokeres/css/register.css" />
		<script type="text/javascript" language="javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">
//hours为空字符串时,cookie的生存期至浏览器会话结束。hours为数字0时,建立的是一个失效的cookie,这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。   
function setCookie(name,value,hours,path){   
    var name = escape(name);   
    var value = escape(value);   
    var expires = new Date();   
    expires.setTime(expires.getTime() + hours*3600000);   
    path = path == "" ? "" : ";path=" + path;   
    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();   
    document.cookie = name + "=" + value + _expires + path;   
}   
//获取cookie值    方法  
function getCookieValue(name){   
    var name = escape(name);   
    //读cookie属性，这将返回文档的所有cookie   
    var allcookies = document.cookie;          
    //查找名为name的cookie的开始位置   
    name += "=";   
    var pos = allcookies.indexOf(name);       
    //如果找到了具有该名字的cookie，那么提取并使用它的值   
    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败   
        var start = pos + name.length;                  //cookie值开始的位置   
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置   
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie   
        var value = allcookies.substring(start,end);  //提取cookie的值   
        return unescape(value);                           //对它解码         
        }      
    else return "";                                             //搜索失败，返回空字符串   
}


 
//登录事件  
            
	function checkLogin() {  
		 var userName = document.getElementById("b_name");  
         var pwd = document.getElementById("b_pwd");  
         if(userName.value.replace(/ /g,"")==""){  
                         alert("用户名不能为空！");  
                         userName.focus();  
                         return;  
                 }  
         if(pwd.value==""){  
                         alert("密码不能为空！");  
                         pwd.focus();  
                         return;  
                 }  
		var url="${pageContext.request.contextPath}/Brokeres";
		par="method=checklogin&b_name="+encodeURI(document.getElementById("b_name").value)+"&b_pwd="+encodeURI(document.getElementById("b_pwd").value);
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
					alert("该用户已登录");
					}	
				if(data==0){
					 setTime();
					 setCookie('cookUser', userName.value, time, '/');//set 获取用户名和密码 传给cookie  
	                 setCookie('cookPass', pwd.value, time, '/');  
					 $("#form1").submit();
					}	
				}
			});
                   
          }  
                    //设置Cookie保存时间  
                    var time = 0;  
                                   
                    $(document).ready(function(){  
                    //获取Cookie保存的用户名和密码  
                    var username = getCookieValue("cookUser");  
                    var password = getCookieValue("cookPass");  
                    if (username !='' && password !='' ) {  
                            $("#b_name").val(username);  
                            $("#b_pwd").val(password);  
                            $("#rememberPW").prop("checked", true);  
                    }else  
                            $("#rememberPW").prop("checked", false);  
                    });  

		function setTime(){
                 if($("#rememberPW").prop("checked")){  
                            time = 7*24 * 60 * 60;  
                    }  
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
	</head>
	<body>
		<div class="main">
			<div class="logo">
				<img
					src="${pageContext.request.contextPath}/front/brokeres/imgs/logo_index.png" />
				<p class="title" style="width:340px">
					<a
						href="${pageContext.request.contextPath}/front/houses/web_page/index.jsp">租房首页</a>&nbsp;|&nbsp;
					<a href="">使用帮助</a>&nbsp;|&nbsp;
					<a href="">客服电话:<font color="#FF0000">${applicationScope.Oversystems.sys_tel}</font>
					</a>
				</p>
			</div>

			<!-- 登录信息-->
			<div class="login">
				<p class="login_t">
					<img
						src="${pageContext.request.contextPath}/front/brokeres/imgs/login_16.gif" />
				</p>
				<div class="login_con">
					<form method="post" action="${pageContext.request.contextPath}/Brokeres?method=login" id="form1">
						<p class="l_p">
							<span>用户名:</span>
							<input type="text" name="b_name" id="b_name" maxlength="20">
						</p>
						<p class="l_p">
							<span>密&nbsp;&nbsp;码:</span>
							<input type="password" name="b_pwd" id="b_pwd" maxlength="20">
						</p>
						<p class="l_p">
							<input type="checkbox" name="num" style="width: 10px" checked="checked"  id="rememberPW" onclick="setTime(this)">
							&nbsp;记住密码
						</p>
						<p class="l_p">
							<input type="button" value="" id="sub" onclick="checkLogin()"/>
							&nbsp;&nbsp;
							<a href="javascript:;" onclick="showforgetPwd()">忘记密码了？</a>
						</p>
					</form>
				</div>
				<div class="login_l">
					<p class="gool">
						<a href="javascript:;" style="margin-left: 0px">设为桌面图标</a><a
							href="javascript:;">保存</a>
							<a href="javascript:;" style="margin-left: 70px;" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://localhost:8080/GollHouse/front/brokeres/web_page/brokerLogin.jsp');">设为首页</a>
					</p>
					<p class="gool2">
						您还没有注册为${applicationScope.Oversystems.sys_name}用户？
						<a
							href="${pageContext.request.contextPath}/front/brokeres/web_page/register.jsp"><img
								src="${pageContext.request.contextPath}/front/brokeres/imgs/10833.png" />
						</a>
					</p>
				</div>
			</div>
			<div class="right">
				<img
					src="${pageContext.request.contextPath}/front/brokeres/imgs/bg.jpg" />
				<p
					style="font-size: 15px; color: ; margin-top: 10px; text-indent: 10px;">
					为经纪人打造全新理念的工作系统,提供最便捷的工作方式。
				</p>
			</div>
			<img
				src="${pageContext.request.contextPath}/front/brokeres/imgs/960601015.gif"
				style="width: 100%; margin-top: 30px;" />
			<iframe
				src="${pageContext.request.contextPath}/front/common/footer.jsp"
				frameborder="0" style="width: 100%; height: 210px; font-size: 13px"
				scrolling="no"></iframe>
		</div>
		<!--弹出层-->
		<div style="width:100%;height:100%;position:absolute;left:0px;top:0px;background:url(../imgs/opacitis.png) repeat;display:none;" id="forgetPwd">
			<div style="width:300px;height:100px;border:3px #1b99de solid;border-radius:5px;position:relative;left:50%;margin-left:-150px;top:50%;margin-top:-150px;background:#73CED6">
							<h3>找回密码</h3>
				邮箱：<input type="text" id="email"><br/>
				<input type="button" value="取消" onclick="outForgetPwd()">
				<input type="button" value="提交申请" onclick="findPwd()">
			</div>
		</div>
		<script type="text/javascript">
			function showforgetPwd(){
				$("#forgetPwd").css("display","block");
			}
			function outForgetPwd(){
				$("#forgetPwd").css("display","none");
			}
			function findPwd(){
				var url="${pageContext.request.contextPath}/Brokeres";
				par="method=findPwd&email="+encodeURI(document.getElementById("email").value);
				$.ajax({
					type:"POST",
					url:url,
					data:par,
					success:function(msg){
						var data=msg;
						outForgetPwd();
						alert(data);
						}
					});
			}
		</script>
	</body>
</html>
