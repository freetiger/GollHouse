<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.goll.service.ICompanysService"%>
<%@page import="cn.goll.service.impl.CompanysServiceImpl"%>
<%@page import="cn.goll.entity.Companys"%>
<%@page import="cn.goll.entity.Brokers"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>修改资料</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/brokerFrame/css/updateData_css.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script>
		function init(){
			var main_div=document.getElementById("main_div");
			main_div.style.width=window.screen.availWidth-154-24+"px";
			main_div.style.height=window.screen.availHeight-160-24+"px";
		}
		function logoBack(mark,path){
			$("#h_img").attr("src","${pageContext.request.contextPath}/"+path);
			$("#head_img").val(path);
		}
	</script>
</head>
<body onLoad="init()">
	<div id="main_div">
	 <form action="${pageContext.request.contextPath}/Brokeres?method=update" method="post" >
    	<div class="title"><font>${sessionScope.broker.b_name }</font>&nbsp;<b>会员资料修改</b></div>
        <div class="div_1">
            <div class="header">
            	<div class="community_name">真实姓名：<input type="text" name="name" value="${sessionScope.broker.b_realname }" readonly="readonly"/></div>
                <div class="header_upload_div">
            		<span style="float:left;top:20px">上传头像：</span><iframe src="${pageContext.request.contextPath}/brokerFrame/web_page/upload.jsp?mark=1&fun=logoBack&type=3"   frameborder="0" height="50px"></iframe>
                </div>
                <p class="real_name">联系电话：<input type="text" name="tel" value="${sessionScope.broker.b_tel }"/></p>
                <p class="email">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="email" value="${sessionScope.broker.b_email }"/></p>
            </div>
            <p class="header_img">
            	头像
                <img src="${pageContext.request.contextPath }/${sessionScope.broker.b_head_img }" id="h_img" />
                <input type="hidden" name="head_img" id="head_img" value="${sessionScope.broker.b_head_img }">
            </p>
        </div>
        <div class="div_2">
            <p class="integral">积分：${sessionScope.broker.b_grade }</p>
            <p class="description">简介：<textarea rows="4" cols="50" name="infos">${sessionScope.broker.b_infos }</textarea></p>
        </div>
        <div class="div_3">
            <p class="company">所在公司：
            <select name="c_id">
            <%ICompanysService cs=new CompanysServiceImpl();
              List<Companys> list=cs.queryAllCompanys("1");
              for(int i=0;i<list.size();i++){	
              		Companys c=list.get(i);
             %>
             <option value="<%=c.getC_id() %>" <%if(c.getC_id()==((Brokers)request.getSession(false).getAttribute("broker")).getC_id()){ %>selected<%} %>><%=c.getC_name() %></option>
             <%} %>
             </select>
            <input type="submit" value="确认修改" id="submit"/>
        </div>
        </form>
    </div>
</body>
</html>
