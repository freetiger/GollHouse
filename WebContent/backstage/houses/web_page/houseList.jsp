<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>房源列表页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/houses/css/houseList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript"><!--
	function del(id){
		if(confirm("确定要删除吗?")){
			window.location.href="Houses?method=del&h_id="+id;
		}
	}
	function upone(id,isup,page){
		if(confirm("确定要置顶么?")){
			if(isup==1){
				alert("此房源已经置顶，不需要置顶，如果想重新置顶，请先取消再置顶");
				return;
				}
			window.location.href="Houses?method=isup&h_id="+id+"&isup=1&page="+page;
		}
	}
	function noupone(id,isup,page){
		if(confirm("确定要取消置顶么?")){
			if(isup==0){
				alert("此房源没有置顶，不需要取消， 只有置顶后，才能取消置顶");
				return;
				}
		
			window.location.href="Houses?method=isup&h_id="+id+"&isup=0&page="+page;
		}
	}
	function datchdel(){
		if(confirm("确定要删除吗?")){
			$("#tableid").submit();
		}
	}

	function choice(){
		$("input[name='h_id']").prop("checked",true);
	}
	function reverse(){
		$("input[name='h_id']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
	}
	
	function choose(obj){
		window.location.href=obj;
	}
	//审核
	function checkeHouse(id){
		window.location.href="Houses?method=check&h_id="+id;
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
			<div class="top_content"> 
			你当前的位置:房源管理»<c:if test="${param.state=='0'}">查看房源</c:if><c:if test="${param.state=='1'}">删除房源</c:if><c:if test="${param.state=='2'}">审核房源</c:if>
			</div>
			<div class="content_table_title">
				<div class="left">
					<input type="button" value="未审核" class="btn_N" onclick="choose('Houses?method=queryForCheck&h_isCheck=0&state=0')"/>
					<input type="button" value="已审核" class="btn_Y" onclick="choose('Houses?method=queryForCheck&h_isCheck=1&state=0')"/>
                    <input type="button" value="个人房源" class="btn_N" onclick="choose('Houses?method=queryForCharge&h_ischarge=0')"/>
					<input type="button" value="经纪人房源" class="btn_Y" onclick="choose('Houses?method=queryForCharge&h_ischarge=1')"/>
				</div>
				
				<div class="table_title_right" style="width:180px;float:right;">
					<c:if test="${param.state=='1'}">
						<input type="button"  class="button3" value="删除" onclick="datchdel()"/>
					</c:if>
					<input type="checkbox" value="全选"  id="checkall"  onclick="choice()"/>全选
					<input type="checkbox" value="全选"  id="checkall"  onclick="reverse()"/>反选
			  </div>								
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="Houses?method=datchDel" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox"  name="house"/></th>
                        <th class="td2">房源编号</th>
                        <th class="td3">房源名称</th>
                        <th class="td4">租金价格</th>
                        <th class="td5">面积</th>
                        <th class="td6">发布人</th>
                        <th class="td7">发布时间</th>
                        <th class="td7">状态</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	
               	 <c:forEach  items="${requestScope.houseList}" var="house" varStatus="i">
                 		<tr>
                 			<td><input type="checkbox"  name="h_id"  value="${house.h_id}"/></td>
                 			<td>${house.h_id}</td>
                 			<td ><a href="Houses?method=queryHouseById&skipTo=back&h_id=${house.h_id}" title="点击查看${house.h_name}详情">${house.h_name}</a></td>
                 			<td>${house.h_price}</td>
                 			<td>${house.h_proportion}</td>
		                 	<td>
		                 		<c:if test="${house.h_ischarge==0}">个人</c:if>
		                 		<c:if test="${house.h_ischarge==1}">经纪人</c:if>
		                 	</td>
		                 	<td>${house.h_publictime}</td>
		                 	<td>
		                 		<c:if test="${house.h_ischeck==0}">
		                 			未审核
		                 		</c:if>
		                 		<c:if test="${house.h_ischeck==1}">
		                 			已审核
		                 		</c:if>
		                 		<c:if test="${house.h_isup==1}">
		                 			<font color="red">&nbsp;已置顶</font>
		                 		</c:if>
		                 		
		                 	</td>
		                    <td>
		                    	<c:if test="${param.state=='2'}">
		                    		<input type="button" value="审核" class="button4" onclick="checkeHouse(${house.h_id})"/>
		                    	</c:if>
		                    	<c:if test="${param.state=='1'}">
		                    		<input type="button" value="删除" class="button5" onclick="del(${house.h_id})"/>
		                    	</c:if>
		                    	<c:if test="${param.state=='0'}">
		                    		<font color="#999">此栏无操作</font>
		                    	</c:if>
		                    	<c:if test="${param.state=='3'}">
		                    		<input type="button" value="置顶" class="button5" onclick="upone(${house.h_id},${house.h_isup},${sessionScope.pages.currentPage})"/>
		                    		<input type="button" value="取消" class="button5" onclick="noupone(${house.h_id},${house.h_isup},${sessionScope.pages.currentPage})"/>
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
