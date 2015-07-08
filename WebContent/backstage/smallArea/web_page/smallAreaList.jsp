<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>小区列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/houses/css/houseList.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		function init(){
			var type=${param.type};
			if(type=="0"){
				//查询
				$("#tit").hide();
				$(".button4").each(function (){
					$(this).hide();
				});
				$(".button5").each(function (){
					$(this).hide();
				});
				$(".operate").each(function (){
					$(this).html("此页面仅供查阅");
				});
				$("#position").html("查询小区信息");
			}
			else if(type=="1"){
				//删除
				$(".button1").each(function (){
					$(this).hide();
				});
				$(".button4").each(function (){
					$(this).hide();
				});
				$("#position").html("删除小区信息");
			}
			else if(type=="2"){
				//审核
				$(".button3").each(function (){
					$(this).hide();
				});
				$(".button5").each(function (){
					$(this).hide();
				});
				$("#position").html("审核小区信息");
			}
		}
		function del(id){
			if(confirm("确定要删除吗?")){
				window.location.href="SmallAreas?method=remove&type=${param.type}&sa_id="+id;
			}
		}
		function datchdel(){
			if(confirm("确定要删除吗?")){
				$("#tableid").submit();
			}
		}
		function check(id){
			window.location.href="SmallAreas?method=check&type=${param.type}&sa_id="+id;
		}
		function imgs(id){
			window.location.href="SmallAreaImgs?method=query&type=${param.type}&sa_id="+id;
		}
		function datchcheck(){
			$("#tableid").submit();
		}
		function choice(){
			$("input[name='sa_id']").prop("checked",true);
		}
		function reverse(){
			$("input[name='sa_id']").each(function(){
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

<body onload="init()">
	<div class="main">
	<div class="content">
			<div class="top_content">
			你当前的位置:小区管理»<span id="position"></span>
			</div>
			<div class="content_table_title" id="tit">
				<div class="left"></div>
				<div class="table_title_right" style="width:auto;">
					<input type="checkbox" value="全选"  id="checkall"  onclick="choice()"/>全选
					<input type="checkbox" value="全选"  id="checkall"  onclick="reverse()"/>反选
					<input type="button"  class="button1" value="审核" onclick="datchcheck()"/>
					<input type="button"  class="button3" value="删除" onclick="datchdel()"/>
			  </div>								
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="${requestScope.action}" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"></th>
                        <th class="td2">小区编号</th>
                        <th class="td3">小区名称</th>
                        <th class="td4">小区地址</th>
                        <th class="td5">物业公司</th>
                        <th class="td6">物业费</th>
                        <th class="td7">所在区域</th>
                        <th class="td7">是否审核</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
               	<c:forEach  items="${requestScope.smallAreaList}" var="smallArea">
                 		<tr>
                 			<td><input type="checkbox"  name="sa_id"  value="${smallArea.sa_id}"/></td>
                 			<td>${smallArea.sa_id}</td>
                 			<td ><a href="Houses?method=queryHousesBySa_id&sa_id=${smallArea.sa_id}&state=0" title="点击查看(房源名称)详情">${smallArea.sa_name}</a></td>
                 			<td>${smallArea.sa_address}</td>
                 			<td>${smallArea.sa_real_company}</td>
		                 	<td>${smallArea.sa_real_money}</td>
		                 	<td><c:forEach  items="${requestScope.areaList}" var="area">
		                 		<c:if test="${smallArea.a_id==area.a_id}">${area.a_name}</c:if>
		                 	</c:forEach></td>
		                 	<td><c:if test="${smallArea.sa_ischeck==1}">已审核</c:if>
		                 	<c:if test="${smallArea.sa_ischeck==0}">未审核</c:if></td>
		                    <td class="operate"><input type="button" value="审核" class="button4" onclick="check(${smallArea.sa_id})"/>
		                    	<input type="button" value="删除" class="button5" onclick="del(${smallArea.sa_id})"/>
		                    	<c:if test="${param.type==2}">
		                    		<input type="button" value="图片管理" style="padding-left:24px;width:80px;" class="button4" onclick="imgs(${smallArea.sa_id})"/>
		                    	</c:if>
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
