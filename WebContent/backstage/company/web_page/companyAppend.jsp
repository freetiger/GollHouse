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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/company/css/companyAppend.css" />
  </head>
  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
  <body> 
  	<div class="main">
      <form action="${pageContext.request.contextPath}/login.do?method=add" method="post">
      	<div class="content">
      		<ul class="title">
      			<li>公司名称:</li>
      			<li>公司年限:</li>
      			<li>地址:</li>
      			<li>公司图片:</li>
      			<li>公司简介:</li>
      		</ul>
      		<ul class="input">
      			<li><input type="text"  name="name"/></li>
      			<li><input type="text" name="time1" class="time1"/>&nbsp;-&nbsp;<input type="text" name="time2" class="time2"/></li>
      			<li><input type="text" name="address"/></li>
      			<li><input type="file" name="picture"/></li>
      			<li><textarea rows="3" cols="24" style="resize:none;"></textarea></li>
      		</ul>
      	</div>
	    <input type="submit" value="保存" id="btn"/>
     </form>
	</div>
  </body>
</html>
