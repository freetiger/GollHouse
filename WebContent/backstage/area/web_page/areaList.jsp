<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>区域列表</title>
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
				$("#position").html("查询区域信息");
			}
			else if(type=="1"){
				//删除
				$(".button1").each(function (){
					$(this).hide();
				});
				$(".button4").each(function (){
					$(this).hide();
				});
				$("#position").html("删除区域信息");
			}
			else if(type=="2"){
				//审核
				$(".button3").each(function (){
					$(this).hide();
				});
				$(".button5").each(function (){
					$(this).hide();
				});
				$("#position").html("审核区域信息");
			}
		}
		function del(id){
			if(confirm("确定要删除吗?")){
				window.location.href="Areas?method=remove&type=${param.type}&a_id="+id;
			}
		}
		function datchdel(){
			if(confirm("确定要删除吗?")){
				$("#tableid").submit();
			}
		}
		function check(id){
			window.location.href="Areas?method=check&type=${param.type}&a_id="+id;
		}
		function datchcheck(){
			$("#tableid").submit();
		}
		function choice(){
			$("input[name='a_id']").prop("checked",true);
		}
		function reverse(){
			$("input[name='a_id']").each(function(){
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
			你当前的位置:区域管理»<span id="position"></span>
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
                        <th class="td2">区域编号</th>
                        <th class="td3">区域名称</th>
                        <th class="td4">区域描述</th>
                        <th class="td7">是否审核</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	
               	<c:forEach  items="${requestScope.areaList}" var="area">
                 		<tr>
                 			<td><input type="checkbox"  name="a_id"  value="${area.a_id}"/></td>
                 			<td>${area.a_id}</td>
                 			<td ><a href="Areas?method=querySmallAreas&type=0&a_id=${area.a_id}" title="点击查看(该区域)相关小区">${area.a_name}</a></td>
                 			<td>${area.a_infos}</td>
		                 	<td><c:if test="${area.a_ischeck==1}">已审核</c:if>
		                 	<c:if test="${area.a_ischeck==0}">未审核</c:if></td>
		                    <td class="operate"><input type="button" value="审核" class="button4" onclick="check(${area.a_id})"/>
		                    	<input type="button" value="删除" class="button5" onclick="del(${area.a_id})"/>
		                    </td>
		                 </tr>
		            </c:forEach>                 
				</table>
			</form>
				
            </div>
             <div style="width:98.2%;height:30px;margin-left:6px;">
       		  <jsp:include page="../../../backstage/common/pager.jsp">
					<jsp:param value="Areas?method=query&type=${param.type}" name="url"/>
				</jsp:include>
			 </div>	
		</div>
	</div>
</body>
</html>
