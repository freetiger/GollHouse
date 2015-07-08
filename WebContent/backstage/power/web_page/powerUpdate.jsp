<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>新增公司信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/power/css/powerUpdate.css" />
  </head>
  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
  <body> 
  	<div class="main">
      <form action="${pageContext.request.contextPath}/login.do?method=add" method="post">
      	<div class="content">
      		<ul class="title">
      			<li>权限编号:</li>
      			<li>权限名称:</li>
      			<li>权限菜单:</li>
      		</ul>
      		<ul class="input">
      			<li><input type="text"  name="id" value="1"/></li>
      			<li><input type="text" name="name" value="超级管理员"/></li>
      			<li>
      				<ul class="menu_ul">
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>添加房源</li>
      					<li><input type="checkbox" name="menus" value=""/>修改房源</li>
      					<li><input type="checkbox" name="menus" value=""/>小区列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      					<li><input type="checkbox" name="menus" value=""/>房源列表</li>
      				</ul>
      			</li>
      		</ul>
      	</div>
	    <input type="submit" value="保存" id="btn"/>
     </form>
	</div>
  </body>
</html>
