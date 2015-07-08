<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>history</title>
    
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
		$("input[name='history']").prop("checked",true);
	}
	function reverse(){
		$("input[name='history']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
	}
	
	
</script>
</head>

<body>
	<div class="main">
	<div class="content">
			<div class="top_content">
			你当前的位置:系统管理-历史记录表
			</div>
			<div class="content_table_title">
				<div class="left">
				</div>
				
				<div class="table_title_right" style="width:auto;">
					<input type="checkbox" value="全选"  id="checkall"  onclick="choice()"/>全选
					<input type="checkbox" value="全选"  id="checkall"  onclick="reverse()"/>反选
					<input type="button"  class="button3" value="删除" onclick="datchdel()"/>
			  </div>								
			</div>
            <!--table部分-->
            <div class="content_table">
              <form action="" id="tableid" method="post">
              <table cellspacing="0px">
                   <tr class="tr1">
                        <th class="td1"><input type="checkbox"  name="history"/></th>
                        <th class="td2">编号</th>
                        <th class="td3">操作者</th>
                        <th class="td4">操作动作</th>
                        <th class="td5">具体内容</th>
                        <th class="td6">事件</th>
                        <th class="td7">操作时间</th>
                        <th class="td8" style="border-top-right-radius:8px;">操作栏</th>
                 	</tr> 
                 	
               	<!--  <c:forEach  items="" var="" varStatus=""> -->
                 		<tr>
                 			<td><input type="checkbox"  name=""  value=""/></td>
                 			<td>1</td>
                 			<td >管理员</td>
                 			<td>添加房源</td>
                 			<td>添加了一个新的房源--中央花园</td>
		                 	<td>新增</td>
		                 	<td>2013-04-03</td>
		                    <td><input type="button" value="删除" class="button5" onclick="del(id号)"/>
		                    </td>
		                 </tr>
		            <!--</c:forEach>  -->                     
				</table>
			</form>
				
            </div>
       		  <jsp:include page="pager.jsp">
					<jsp:param value="www.baidu.com?m=0" name="url"/>
				</jsp:include>
				
		</div>
	</div>
</body>
</html>
