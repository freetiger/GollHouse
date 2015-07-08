<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>列表模式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/brokerFrame/css/houseTextList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">
	function del(id,obj){
		if(confirm("确定要删除吗?")){
			$(obj).parent().parent().remove();
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
	function skip(){	
		window.location.href="";
	}
	function choice(){
		$("input[name='house']").prop("checked",true);
	}
	function reverse(){
		$("input[name='house']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
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
	
</script>
</head>

<body>
	<div class="main" style="width:98%;">
		<p class="title">经纪人&raquo;查看楼盘列表</p>   
    	<div class="list">
        	<p class="list_title">房源信息列表<span style="float:right"><a href="${pageContext.request.contextPath}/Houses?method=queryHouseBybid&url=houseAndImgList">图文模式</a></span></p>				
		
            <!--table部分-->
            <div class="content_table">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1">房源编号</th>
                        <th class="td1">房源名称</th>
                        <th class="td1">面积</th>
                        <th class="td1">租金</th>
                        <th class="td1">是否被置顶</th>
                        <th class="td1">楼层</th>
                        <th class="td1">发布时间</th>
                        <th class="td1">出租方式</th>
                        <th class="td7">操作栏</th>
                 	</tr> 
                 <c:forEach items="${requestScope.hList}" var="h" varStatus="i">	
                 		<tr>
                 			<td>${h.h_number }</td>
                 			<td ><a href="${pageContext.request.contextPath }/brokerFrame/web_page/updateHouse.jsp?id=${h.h_id }">【${h.h_title }】</a></td>
                 			<td>${h.h_proportion }平米</td>
                            <td>${h.h_price }元/月</td>
                 			<td><c:if test="${h.h_isup==0}">否</c:if><c:if test="${h.h_isup==1}">是</c:if></td>
		                 	<td>${h.h_floor }/${h.h_all_floor }</td>
		                 	<td>${h.h_publictime}</td>
		                 	<td>${h.list[0]}</td>
		                    <td>
		                    	<input type="button" value="下架" class="button5" onclick="del(${h.h_id },this)"/>
		                    </td>
		                 </tr>
		           </c:forEach>              
				</table>
            </div>
            
            <div style="width:98%;height:30px;margin-left:6px;">
            	  <jsp:include page="pager.jsp">
					<jsp:param value="${sessionScope.jspparam}" name="url"/>
				</jsp:include>
			</div>
				
		</div>
	</div>
</body>
</html>
