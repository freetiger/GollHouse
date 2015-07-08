<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'center.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="utf-8" />
    <title>中间</title>
    <style>
		*{margin:0;padding:0px;}
		#main_div{width:6px;height:200px;background:#0048b4;}
		#middle_div{width:6px;height:40px;position:relative;top:50%;margin-top:-40px;background:black;cursor:pointer;}
	</style>
    <script>
		function initHeight(){
			var main_div=document.getElementById("main_div");
			main_div.style.height=window.screen.availHeight-164+"px";
		}
	</script>
</head>

<body onLoad="initHeight()">
	<div id="main_div"><div id="middle_div"></div></div>
</body>
</html>
