<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>权限列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/power/css/powerList.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		function del(id){
			if(confirm("确定要删除吗?")){
				window.location.href="";
			}
		}
		function datchdel(){
			if(confirm("确定要删除吗?")){
				$("#tableid").submit();
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
	<div class="main">
	<div class="content">
			<div class="top_content">
			当前位置:权限管理 » 
			<c:if test="${param.status==1 }">
				查看权限
			</c:if>
			<c:if test="${param.status==2 }">
				修改权限
			</c:if>
			</div>
			<!--<div class="content_table_title">
				<div class="left">
					
				</div>
				
				<div class="table_title_right" style="width:auto;">
					<input type="checkbox" value="全选"  id="checkall"  onclick="choice()"/>全选
					<input type="checkbox" value="全选"  id="checkall"  onclick="reverse()"/>反选
					<input type="button"  class="button3" value="删除" onclick="datchdel()"/>
					
			  </div>								
			</div>
            --><!--table部分-->
            <div class="content_table">
              <form action="" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox" /></th>
                        <th class="td2">权限编号</th>
                        <th class="td3">权限名称</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	<c:forEach items="${requestScope.powerlist}" var="power">
                 		<tr>
                 			<td><input type="checkbox"  name=""  value=""/></td>
                 			<td>${power.p_id }</td>
                 			<td>${power.p_name }</td>
		                    <td>
		                    	<a href="${pageContext.request.contextPath}/Powers?method=update&status=1&id=${power.p_id }">
		                    	<c:if test="${param.status==1 }">
		                    		<input type="button" value="详情" class="button4" title="详情" style="cursor: pointer;"/>
		                    	</c:if>
		                    	</a>
		                    	<a href="${pageContext.request.contextPath}/Powers?method=update&status=2&id=${power.p_id }">
		                    	<c:if test="${param.status==2 }">
		                    		<input type="button" value="修改" class="button5" title="修改" style="cursor: pointer;"/>
		                    	</c:if>
		                    	</a>
		                    </td>
		                 </tr>
	                 </c:forEach>
				</table>
			</form>
				
            </div>
            <div style="width:98.2%;height:30px;margin-left:6px;">
       		  <jsp:include page="../../../backstage/common/pager.jsp">
					<jsp:param value="Powers?method=query&status=${param.status}" name="url"/>
				</jsp:include>
			</div>	
		</div>
	</div>
</body>
</html>
