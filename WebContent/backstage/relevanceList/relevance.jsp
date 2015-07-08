<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
  <head>
   
    <title>系统设置的关联表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
*{padding:0px;margin:0px; text-decoration:none; list-style:none;}
.main{
	width:100%;height:100%;
	}
.big{width:90%;height:90%;margin-top:20px;margin-left:5%;}
.payType{width:30%;height:250px;float:left;border:3px #1b99de solid; overflow:auto}
.houseYear{width:30%;height:250px;float:left;border:3px #1b99de solid;overflow:auto;margin-left:5px;}
.rtType{width:30%;height:250px;float:left;border:#1b99de 3px solid;overflow:auto;margin-left:5px;}
.houseType{width:30%;height:250px;float:left;border:#1b99de 3px solid;overflow:auto;margin-top:5px;}
.houseHaving{width:30%;height:250px;float:left;border:#1b99de 3px solid;overflow:auto;margin-top:5px;margin-left:5px}
.rentMoney{width:30%;height:250px;float:left;border:#1b99de 3px solid;overflow:auto;margin-top:5px;margin-left:5px;}
.title{width:100%;height:30px;background:#1b99de;font-size:15px;font-weight:bolder;color:#FFF;line-height:30px; text-indent:10px;}
.save,.del{width:40px;height:25px;font-size:13px;float:right;}
input{width:100px;height:25px;}
tr{height:30px;}
a{font-size:13px;display:block;width:50px;height:25px;line-height:25px;float:right;color:#C60;}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>

</head>

<body>
	<div class="main">
    	<div class="big">
    		<div class="payType"><!--付款方式-->
            	<p class="title">付款方式 <a href="javascript:;" onclick="add('pt')">添加</a></p>
                <table>
                	<tr id="pt"><th>编号</th><th>付款方式</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.pyList}" var="pay_type">
                	 	<tr id="pt${pay_type.pt_id}"><td>${pay_type.pt_id}</td><td><input type="text" value="${pay_type.pt_name}"  id="${pay_type.pt_id}pt"/></td><td>
                	  	<input type="button" value="保存" onclick="save('pt',${pay_type.pt_id})" class="save"/><input type="button" value="删除" onclick="dels('pt',${pay_type.pt_id})" class="del"/></td></tr>
                	</c:forEach>
                   
                </table>                
            </div>
            <div class="houseYear"><!--房源年限-->
				<p class="title">房源年限 <a href="javascript:;" onclick="add('hy')">添加</a></p>  
				 <table>
                	<tr id="hy"><th>编号</th><th>年份范围</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.hyList}" var="house_year">
                	 	<tr id="hy${house_year.hy_id}"><td>${house_year.hy_id}</td><td><input type="text" value="${house_year.hy_years}"  id="${house_year.hy_id}hy"/></td><td>
                	  	<input type="button" value="保存" onclick="save('hy',${house_year.hy_id})" class="save"/><input type="button" value="删除" onclick="dels('hy',${house_year.hy_id})" class="del"/></td></tr>
                	</c:forEach>
               	 </table>   
                        
            </div>
            <div class="rtType"><!--出租方式-->
            	<p class="title">出租方式 <a href="javascript:;" onclick="add('rt')">添加</a></p>
            	 <table>
                	<tr id="rt"><th>编号</th><th>名称</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.rtList}" var="rent_type">
                	 	<tr id="rt${rent_type.rt_id}"><td>${rent_type.rt_id}</td><td><input type="text" value="${rent_type.rt_name}"  id="${rent_type.rt_id}rt"/></td><td>
                	  	<input type="button" value="保存" onclick="save('rt',${rent_type.rt_id})" class="save"/><input type="button" value="删除" onclick="dels('rt',${rent_type.rt_id})" class="del"/></td></tr>
                	</c:forEach>
               	 </table> 
                
            </div>
            <div class="houseType"><!--房源类型-->
                <p class="title">房源类型 <a href="javascript:;" onclick="add('ht')">添加</a></p>
                <table>
                	<tr id="ht"><th>编号</th><th>房源类型</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.htList}" var="house_type">
                	 	<tr id="ht${house_type.ht_id}"><td>${house_type.ht_id}</td><td><input type="text" value="${house_type.ht_name}"  id="${house_type.ht_id}ht"/></td><td>
                	  	<input type="button" value="保存" onclick="save('ht',${house_type.ht_id})" class="save"/><input type="button" value="删除" onclick="dels('ht',${house_type.ht_id})" class="del"/></td></tr>
                	</c:forEach>
               	 </table> 
                
            </div>
            <div class="houseHaving"><!--房源配置-->
            	<p class="title">房源配置<a href="javascript:;" onclick="add('het')">添加</a></p>
                <table>
                	<tr id="het"><th>编号</th><th>房源配置</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.hetList}" var="het">
                	 	<tr id="het${het.het_id}"><td>${het.het_id}</td><td><input type="text" value="${het.het_name}"  id="${het.het_id}het"/></td><td>
                	  	<input type="button" value="保存" onclick="save('het',${het.het_id})" class="save"/><input type="button" value="删除" onclick="dels('het',${het.het_id})" class="del"/></td></tr>
                	</c:forEach>
               	 </table>
                
            </div>
              <div class="rentMoney"><!--租金范围-->
            	<p class="title">租金范围<a href="javascript:;" onclick="add('rm')">添加</a></p>
                <table>
                	<tr id="rm"><th>编号</th><th>租金范围</th><th>操作</th></tr>
                	<c:forEach items="${requestScope.rmList}" var="rent_money">
                	 	<tr id="rm${rent_money.rm_id}"><td>${rent_money.rm_id}</td><td><input type="text" value="${rent_money.rm_count}"  id="${rent_money.rm_id}rm"/></td><td>
                	  	<input type="button" value="保存" onclick="save('rm',${rent_money.rm_id})" class="save"/><input type="button" value="删除" onclick="dels('rm',${rent_money.rm_id})" class="del"/></td></tr>
                	</c:forEach>
               	 </table>
                
            </div>
          
    	</div>
    </div>
<script type="text/javascript">

	function add(flag){
		$.ajax({
			type:"POST",
			url:"relevance",
			data:"method=insert&flag="+flag,
			dataType:"text",
			success:function(msg){
				var arr=msg.split(",");
				$("#"+arr[0]).after("<tr id="+arr[0]+arr[1]+"><td>"+arr[1]+"</td><td><input type='text' value='' id='"+arr[1]+arr[0]+"'/></td><td> <input type='button' value='保存' onclick=save('"+arr[0]+"',"+arr[1]+") class='save'/><input type='button' value='删除' onclick=dels('"+arr[0]+"',"+arr[1]+") class='del'/></td></tr>");
			}	
		})
		
	}
	function dels(flag,id){
		if(confirm("确定要删除吗?")){
			$("#"+flag+id).remove();
			$.ajax({
				type:"POST",
				url:"relevance",
				data:"method=del&flag="+flag+"&id="+id,
				dataType:"text",
				success:function(msg){
					if(msg==0){alert("操作失败");}
					if(msg==1)alert("操作成功");
				}		
			})
		}
	}
	function  save(flag,id){
		var con=$("#"+id+flag).val();
		if(con!=""){
			$.ajax({
				type:"POST",
				url:"relevance",
				data:"method=update&flag="+flag+"&id="+id+"&text="+con,
				success:function(msg){
					if(msg==0){alert("操作失败");}
					if(msg==1)alert("操作成功");
				}			
			
			})		
		}else return;
				
	}
</script>
</body>
</html>
