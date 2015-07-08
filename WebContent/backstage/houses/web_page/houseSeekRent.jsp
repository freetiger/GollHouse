<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>求租列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/houses/css/houseList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("确定要删除吗?")){
			window.location.href="SeekRent?method=del&state=1&id="+id;
		}
	}
	function checkToServlet(id){
		window.location.href="SeekRent?method=check&state=2&ischeck=0&id="+id;
	}
	function skipTo(obj){	
		window.location.href="${pageContext.request.contextPath}/"+obj;
	}
	function choice(){
		$("input[name='seekRent']").prop("checked",true);
	}
	function reverse(){
		$("input[name='seekRent']").each(function(){
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
		window.location.href=url+number;
	}
	
</script>
</head>

<body>
	<div class="main">
	<div class="content">
			<div class="top_content">&nbsp; 
			你当前的位置:系统管理-<c:if test="${param.state=='0'}">查询信息</c:if><c:if test="${param.state=='1'}">删除信息</c:if><c:if test="${param.state=='2'}">审核信息</c:if> 
			</div>
			<div class="content_table_title">
				<div class="left">
					<input type="button" value="查看" class="btn_N"  onclick="skipTo('SeekRent?method=selAll&state=0')"/>
					<input type="button" value="审核" class="btn_Y"   onclick="skipTo('SeekRent?method=selAll&state=2&ischeck=0')"/>
					<input type="button" value="删除" class="btn_N"  onclick="skipTo('SeekRent?method=selAll&state=1')"/>
				</div>						
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox" /></th>
                        <th class="td2">求租编号</th>
                        <th class="td3">求租价格</th>
                        <th class="td4">求租电话</th>
                        <th class="td5">是否审核</th>
                        <th class="td6">区域名</th>
                        <th class="td7">小区名</th>
                        <th class="td7">备注</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	
               <c:forEach  items="${requestScope.srList}" var="sr" > 
                 		<tr>
                 			<td><input type="checkbox"  name="seekRent"  value="${sr.sr_id}"/></td>
                 			<td>${sr.sr_id}</td>
                 			<td >${sr.sr_price}元/月</td>
                 			<td>${sr.sr_tel}</td>
                 			<td><c:if test="${sr.sr_ischeck=='0'}">未审核</c:if><c:if test="${sr.sr_ischeck=='1'}">已审核</c:if></td>
		                 	<td>${sr.list[0].a_name }</td>
		                 	<td>${sr.list[1].sa_name}</td>
		                 	<td><p  style="height:20px;overflow:hidden;line-height:20px;" id="infos">${sr.sr_infos}</p></td>
		                    <td>
			                    <c:if test="${param.state=='0'}"><font color="#999">此操作栏无操作</font></c:if>
			                    <c:if test="${param.state=='2'}"><input type="button" value="审核" class="button4" onclick="checkToServlet(${sr.sr_id})"/></c:if>
			                    <c:if test="${param.state=='1'}"><input type="button" value="删除" class="button5" onclick="del(${sr.sr_id})"/></c:if>	                    	
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
