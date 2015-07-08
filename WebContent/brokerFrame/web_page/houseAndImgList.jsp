<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图文模式的列表页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/brokerFrame/css/b_houseList.css"> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<title>楼盘列表</title>
</head>

<body>
	<div class="main">
    	<p class="title">经纪人&raquo;查看楼盘列表</p>   
    	<div class="list">
        	<p class="list_title">房源信息列表<span style="float:right"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseBybid&url=houseTextList">列表模式</a></span></p>
            <c:forEach items="${requestScope.hList}" var="h" varStatus="i">
            <div class="list_l">
            	<img src="${pageContext.request.contextPath}/${h.list[1]}">
                <div class="con1">
                	<ul>
                    	<li style="font-weight:bolder"><a href="${pageContext.request.contextPath }/brokerFrame/web_page/updateHouse.jsp?id=${h.h_id }">【${h.h_title }】</a></li>
                        <li>房源编号:<font color="red">${h.h_number }</font></li>
                        <li>面积:${h.h_proportion }平米&nbsp;楼层：${h.h_floor }/${h.h_all_floor }楼</li>
                        <li>出租方式:${h.list[0]}&nbsp;租金:${h.h_price }元/月</li>
                    </ul>
                </div>
                <div class="soldout">
                	<a href="javascript:;" title="让该房源下架吧"><img src="${pageContext.request.contextPath}/brokerFrame/img/del_1.jpg" onMouseOver="changeImg(this)" onMouseOut="returnImg(this)" onclick="del(this,${h.h_id })"></a>
                </div>
            </div>
            </c:forEach>
        </div>
        <!--分页-->
         <div style="width:90%;height:30px;margin:0px auto;">
            	  <jsp:include page="pager.jsp">
					<jsp:param value="${sessionScope.jspparam}" name="url"/>
				</jsp:include>
			</div>
    </div>
    <script type="text/javascript">
    	function changeImg(obj){
			$(obj).attr("src","${pageContext.request.contextPath}/brokerFrame/img/del.jpg");
		}
		function returnImg(obj){
			$(obj).attr("src","${pageContext.request.contextPath}/brokerFrame/img/del_1.jpg");
		}
	    function skip(url,number,num){	
			if(number==""){
				alert("请输入要跳转的页数");
				return;
			}else if(number>num){
				alert("当前最多只有"+num+"页,请正确输入");
				number=num;
			}else{
				var reg=/^[0-9]*$/;
				if(!reg.test(number)){
					alert("只能是数字，请正确输入");
					document.getElementById("returns").value="";
					return;
				}
			}
			window.location.href="${pageContext.request.contextPath}/"+url+number;
		}
		function del(obj,id){
		if(confirm("确定要删除吗?")){
			$(obj).parent().parent().parent().remove();
			var url="${pageContext.request.contextPath}/Houses";
			par="method=delHouseByhId&id="+id;
			$.ajax({
				type:"POST",
				url:url,
				data:par,
				success:function(msg){
					var data=msg;
					alert(data);
				}
			});
		}
	}
    </script>
</body>
</html>
