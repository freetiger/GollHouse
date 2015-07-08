<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML >
<html>
  <head>
    
    <title>searchBar</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<style>
*{margin:0px;padding:0px;}
.search{
	width:596px;height:100px;background:#EFF6FF;border:#0048B4 2px solid;
	}
#search_condition{
	margin-top:10px;float:left;margin-left:20px;width:380px;height:32px; border-radius:5px 0px 0px 5px;border:#85A4C1 1px solid;color:#999;
	}
#subm{
	width:110px;height:34px;margin-top:10px;float:left; background:url(${pageContext.request.contextPath}/front/houses/img/search.png) no-repeat;border:none;	
	}
.p_static{
	clear:both;width:500px;height:30px; margin-left:30px;font-size:14px;line-height:35px;
	}
.p_static a{ text-decoration:none;}
.p_static a:hover{color:red;}
</style>
</head>

<body>
	<div class="search">
    	<form method="post" action="">
        	<input type="text" name="search_condition" value="请输入你要搜索的条件" id="search_condition" onfocus="removeText()">
        	<input type="submit" value="" id="subm"/>
        </form>
        <p class="p_static">关键字：<a href="">租房</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">求租</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">小区</a></p>
    </div>
</body>
<script>
	function removeText(){
		if($("#search_condition").val() == "请输入你要搜索的条件")
			$("#search_condition").val("");
		}
</script>
</html>
