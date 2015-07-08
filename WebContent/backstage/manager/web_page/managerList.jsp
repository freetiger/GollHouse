<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>管理员列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/manager/css/managerList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("确定要删除吗?")){
			window.location.href="Managers?method=del&id="+id;
		}
	}
	function datchdel(){
		if(confirm("确定要删除吗?")){
			$("#tableid").submit();
		}
	}
	
	function choice(){
		$("input[name='id']").prop("checked",true);
	}
	function reverse(){
		$("input[name='id']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
	}
	
	function addManager(){
		window.location.href="${pageContext.request.contextPath}/backstage/manager/web_page/managerAppend.jsp";
	}
	function checkManager(id){
		window.location.href="Managers?method=check&id="+id;
	}
	$(document).ready(function(){
		if(${param.flag=="0"})alert("操作失败");
		if(${param.flag=="1"})alert("操作成功");
	
	})
</script>
</head>

<body>
	<div class="main">
	<div class="content">
			<div class="top_content">
			你当前的位置:管理员管理 »<c:if test="${param.state=='0'}">查看管理员</c:if><c:if test="${param.state=='1'}">删除管理员</c:if><c:if test="${param.state=='2'}">审核管理员</c:if>
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="Managers?method=datchDel" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox" /></th>
                        <th class="td2">用户编号</th>
                        <th class="td3">用户名称</th>
                        <th class="td4">权限等级</th>
                        <th class="td4">是否审核</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	
               	  <c:forEach  items="${requestScope.list}" var="manager" varStatus="i">
                 		<tr>
                 			<td><input type="checkbox"  name="id"  value="${manager.id}"/></td>
                 			<td>${manager.id}</td>
                 			<td >${manager.uname}</td>
                 			<td>${manager.p_name}</td>
                 			<td>
                 				<c:if test="${manager.ischeck==0}">未审核</c:if>
                 				<c:if test="${manager.ischeck==1}">已审核</c:if>
                 			</td>
		                    <td>
		                    	<c:if test="${param.state=='2'}">
		                    		<input type="button" value="审核" class="button4"  onclick="checkManager(${manager.id})"/>
		                    	</c:if>
		                    	<c:if test="${param.state=='1'}">
		                    		<input type="button" value="删除" class="button5"  onclick="del(${manager.id})"/>
		                    	</c:if>
		                    	<c:if test="${param.state=='0'}"><font color="#999" size="-1">此栏只能查看</font></c:if>
		                    </td>
		                 </tr>
		            </c:forEach>                     
				</table>
			</form>
				
            </div>
            <div style="width:98.2%;height:30px;margin-left:6px;">
       		  <jsp:include page="../../../backstage/common/pager.jsp">
					<jsp:param value="${requestScope.jspParam}" name="url"/>
				</jsp:include>
			</div>	
		</div>
	</div>
</body>
</html>
