<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data" id="form">
    	<input type="hidden" name="mark" value="${param.mark}"/>
    	<input type="hidden" name="fun" value="${param.fun}"/>
    	<input type="hidden" name="fileType" value="${param.type}"/>
    	<input type="file" style="width:68px;" name="fileName"/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
