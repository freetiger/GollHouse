<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'powerList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="js/jquery-1.9.0.js"></script>
  <style type="text/css">
  body{
  		background:#E7F8FF;
  		font-size: 12px;
  }
  div{
	display:block;	
	position:absolute;
	z-index:10;
	margin-top:-10px;
	background-color:none;
  }
  #tabMenu{
	width:310px;
	}
  #tabMenu td{
	width:100px;
	height:30px;
  }
  #tabMenu a{
  	font-size:12px;
	text-decoration:none;
	width:100px;
	height:30px;
	text-align:center;
	line-height:30px;
	color:black;
	margin:5px;
	display:block;
	background-color:#cccccc;
  }
  #tabMenu a:hover{
	background-color:red;
	color:white;
	}
	 #main_topbar{
			background-image:url("images/main_26.gif");
			background-repeat:repeat-x;
			width:98.5%;
			position:absolute;
			top:0px;
	}
  #max_bottom{
			background: url("images/main_48.gif") repeat-x;
			width:98.5%;
			position: absolute;
			bottom: 0px;
	}
  </style>
   
  <script type="text/javascript">
	 function check(ch,obj){
			//$("input[name=ch"+obj+"]").each(function(){
		$("#div"+obj).find("a>input").each(function(){
		$(this).prop("checked",$(ch).prop('checked'));
		});
		}
	 function checkMenu(ch,obj){
		$("#"+obj).prop("checked",true);
		}
  </script>
  
  <body>
  <form action="${pageContext.request.contextPath}/Powers?method=updateAll&status=2" method="post">
   <span style="text-align: center">                    
      当前职位：${requestScope.power.p_name }
     <c:if test="${param.status==2}">
	 	<input type="submit" value="保存">	
	 </c:if>	
	 <input type="hidden" value="${requestScope.power.p_id }" name="pid">		
	</span>	
  <table id="tabMenu" cellpadding="0" cellspacing="0" border="0" align="center">
  	<tr id="root">
	${param.str }
	</tr>
	<tr id="head">
	<c:forEach items="${requestScope.divStr}" var="ds">
		${ds}
	</c:forEach>
	</tr>
  </table>
  </form>
  </body>
</html>
