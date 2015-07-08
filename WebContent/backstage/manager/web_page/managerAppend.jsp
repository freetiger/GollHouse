<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新增管理员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/manager/css/managerAppend.css" />
  </head>
  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
  <script type="text/javascript">
	function checkRegister(){
		var uname=$("#name").val();
		var pwd=$("#pwd").val();
		if(uname==null ||uname==""||pwd==null||pwd==""){
				alert("用户名密码不能为空");
			return;
			}
		var url="${pageContext.request.contextPath}/Managers";
		var par="method=add&name="+encodeURI(document.getElementById("name").value)+"&pwd="+encodeURI(document.getElementById("pwd").value)+"&power="+encodeURI(document.getElementById("power").value);
  		$.ajax({
			type:"POST",
			url:url,
			data:par,
			success:function(msg){
				if(msg==1){
  					alert("用户已存在，请重新输入");
  				}
  				else if(msg==2){
  					alert("添加成功");	
					}
				}
			});
		}
	var SubmitOrHidden = function(evt){
		evt = window.event || evt;
		    if(evt.keyCode==13){//如果取到的键值是回车
	          //do something      
	      		checkRegister();
	    }
	}
	window.document.onkeydown=SubmitOrHidden;
 </script>
  <body> 
  	<div class="main">
      <form action="${pageContext.request.contextPath}/Managers?method=add" method="post" id="form1">
	        <p style="margin-top:120px">用户名:<input type="text"  name="name" id="name"/><span id="yz"></span></p>
	          <p> 密 &nbsp;码:<input type="password" name="pwd" id="pwd"/></p>
	          <p> 权 &nbsp;限:<select name="power"  style="width:150px" id="power">
		               <c:forEach items="${requestScope.ps}" var="power">
		               		<option value="${power.p_id}">${power.p_name}</option>
		               </c:forEach>
	           		</select>
	          </p>
	    <p> <input type="button" value="保存" id="btn" onclick="checkRegister()"/></p>
     </form>
	</div>
  </body>
</html>
