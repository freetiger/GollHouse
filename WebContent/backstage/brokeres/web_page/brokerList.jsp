<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
  <head>
    <title>经纪人列表页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/brokeres/css/brokerList.css" />
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
	function nocheck(){
		window.location.href="${pageContext.request.contextPath}/Brokeres?method=query&ischeck=0";
	}
	function readycheck(){
		window.location.href="${pageContext.request.contextPath}/Brokeres?method=query&ischeck=1";
	}
	function readyAll(){
		window.location.href="${pageContext.request.contextPath}/Brokeres?method=query&ischeck=null";
	}
</script>
</head>

<body>
	<div class="main">
	<div class="content">
			<div class="top_content">
			当前位置:经纪人管理 » 
			<c:if test="${sessionScope.status==0}">
			审核经纪人
			</c:if>
			<c:if test="${sessionScope.status==1}">
			删除经纪人
			</c:if>
			<c:if test="${sessionScope.status==2}">
			查看经纪人
			</c:if>
			</div>
			<div class="content_table_title">
				<div class="left">
					<span style="float:left">根据条件查询：</span>
					<input type="button" value="未审核" class="btn_N" onclick="nocheck()"/>
					<input type="button" value="已审核" class="btn_Y" onclick="readycheck()"/>
					<input type="button" value="全部" class="btn_Y" onclick="readyAll()"/>
				</div>
				<div class="table_title_right" style="width:auto;">
					<input type="checkbox" value="全选"  id="checkall"  onclick="choice(this)"/>全选
					<input type="checkbox" value="反选"  id="checkall"  onclick="reverse()"/>反选
					<c:if test="${sessionScope.status==1}">
						<input type="button" class="button3"  onclick="return batchdel()" value="删除" style="cursor: pointer;" title="删除">
					</c:if>
					<c:if test="${sessionScope.status==0}">
						<input type="button" class="button3"  onclick="return checkAll()" value="审核" style="cursor: pointer;" title="审核">
					</c:if>
			  </div>								
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="Brokeres?method=deleteAll&page=${sessionScope.pages.currentPage}" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox"  onclick="choice(this)"/></th>
                        <th class="td2">编号</th>
                        <th class="td3">姓名</th><!-- 此处为真实姓名 -->
                        <th class="td4">身份证号</th>
                        <th class="td5">联系电话</th>
                        <th class="td6">所属公司</th>
                        <th class="td6">联系邮箱</th>
                        <th class="td7">积分等级</th>
                        <th class="td7">是否审核</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
               			<c:forEach items="${requestScope.brokerList}" var="b" varStatus="i">
                 			<tr>	
                 				<td><input type="checkbox"  name="broker"  value="${b.b_id}"/></td>
                 				<td>${b.b_id}</td>
                 				<td >${b.b_realname}</td>
                 				<td>${b.b_card}</td>
                 				<td>${b.b_tel}</td>
		                	 	<td><a href="Companys?method=queryByCid&c_id=${b.c_id}&type=0" title="点击查看公司信息">${b.b_company}</a></td>
		                	 	<td>${b.b_email}</td>
		                	 	<td>${b.b_level}</td>
		                	 	<td>
		                	 		<c:if test="${b.b_ischeck=='0'}">
		                	 			未审核
		                	 		</c:if>
		                	 		<c:if test="${b.b_ischeck=='1'}">
		                	 			已审核
		                	 		</c:if>
		                	 	</td>
		                	    <td>
		                	    	<c:if test="${sessionScope.status==0}">
		                	    		<a href="Brokeres?method=ischeck&page=${sessionScope.pages.currentPage}&id=${b.b_id}" onclick="return confirm('是否审核')"><input type="button" value="审核" class="button4" style="cursor: pointer;" title="审核"/></a>
		                    		</c:if>
		                    		<c:if test="${sessionScope.status==1}">
		                    			<a href="Brokeres?method=delete&page=${sessionScope.pages.currentPage}&id=${b.b_id}" onclick="return confirm('是否删除')"><input type="button" value="删除" class="button5" style="cursor: pointer;" title="删除"/></a>
		                			</c:if>
		                			<c:if test="${sessionScope.status==2}">
		                				此页面仅供查阅
		                			</c:if>
		                	    </td>
	                	   </tr>  
               			</c:forEach>
				</table>
			</form>
            </div>
            <div style="width:98.2%;height:30px;margin-left:6px;">
       		  <jsp:include page="../../../backstage/common/pager.jsp">
					<jsp:param value="${sessionScope.jspparam}" name="url"/>
			  </jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
