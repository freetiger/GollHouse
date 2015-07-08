<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
  <head>
    <title>历史记录列表页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/history/css/brokerList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("确定要删除吗?")){
			window.location.href="";
		}
	}
	function batchdel(){
		var number=0;
		$("input[name='broker']").each(function(){
			if($(this).prop("checked")==true)
				number++;
		});
		if(number==0){
			alert("您当前没有选中任何对象,请先选择！！！");
			return false;
		}
		if(confirm("确定要删除选中的"+number+"项吗?"))
			$("#tableid").submit();
	}
	function checkAll(){
		var number=0;
		$("input[name='broker']").each(function(){
			if($(this).prop("checked")==true)
				number++;
		});
		if(number==0){
			alert("您当前没有选中任何对象,请先选择！！！");
			return false;
		}
		if(confirm("确定要审核选中的"+number+"项吗?")){
	    	document.getElementById("tableid").action="Brokeres?method=ischeckAll&page=${sessionScope.pages.currentPage}";
	    	$("#tableid").submit();
		}
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
	function choice(obj){
		$("input[name='broker']").prop("checked",$(obj).prop("checked"));
	}
	function reverse(){
		$("input[name='broker']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
	}
</script>
</head>

<body>
	<div class="main">
	<div class="content">
			<div class="top_content">
			当前位置:首页 > 历史记录
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox"  onclick="choice(this)"/></th>
                        <th class="td2">编号</th>
                        <th class="td3">是否经纪人</th><!-- 此处为真实姓名 -->
                        <th class="td4">是否管理员</th>
                        <th class="td5">操作员</th>
                        <th class="td6">操作对象</th>
                        <th class="td6">操作动作</th>
                        <th class="td7">操作时间</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
               			<c:forEach items="${requestScope.historyList}" var="h" varStatus="i">
                 			<tr>	
                 				<td><input type="checkbox"  name="broker"  value="${h.his_id}"/></td>
                 				<td>${h.his_id}</td>
                 				<td >
                 					<c:choose> 
                 						<c:when test="${h.his_b_id==0}">否</c:when>
                 						<c:otherwise>是</c:otherwise>
                 					</c:choose>
                 				</td>
                 				<td>
                 					<c:choose> 
                 						<c:when test="${h.his_manager_id==0}">否</c:when>
                 						<c:otherwise>是</c:otherwise>
                 					</c:choose>
                 				</td>
                 				<td>${h.his_do_name}</td>
		                	 	<td>${h.his_do_actions}</td>
		                	 	<td>${h.his_do_event}</td>
		                	 	<td>${h.his_date}</td>
		                	    <td>
		                    			<a href="Historys?method=delete&page=${sessionScope.pages.currentPage}&id=${h.his_id}" onclick="return confirm('是否删除')"><input type="button" value="删除" class="button5" style="cursor: pointer;" title="删除"/></a>
		                	    </td>
	                	   </tr>  
               			</c:forEach>
				</table>
			</form>
            </div>
            <div style="width:98%;height:30px;margin-left:6px;">
       		  <jsp:include page="../../../backstage/common/pager.jsp">
					<jsp:param value="${sessionScope.jspparam}" name="url"/>
			  </jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
