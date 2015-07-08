<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>菜单管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/menu/css/menu.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		var menus=new Array(<c:forEach items="${requestScope.allmenus}" var="menu">[${menu.m_id},'${menu.m_name}','${menu.m_url}',${menu.f_id}],</c:forEach>null);
		$(document).ready(function(){
			menus.pop();
			var count=menus.length;
			for(var i=0;i<menus.length;i++){
				if(menus[i][3]==0){
					$("#m0").append("<li style='background:#1b99de;line-height:30px;'><input type='checkbox' name='mid' value='"+menus[i][0]+"' onclick='checkMenu(this)'/>"+
					"<input type='hidden' value='"+menus[i][0]+"' name='ids' id='id"+menus[i][0]+"'/>"+
					"<input type='text' name='names' value='"+menus[i][1]+"' id='n"+menus[i][0]+"'/>"+
					"&nbsp;链接：<input type='text' name='urls' value='"+menus[i][2]+"' id='u"+menus[i][0]+"'/>"+
					"<input type='hidden' value='"+menus[i][3]+"' name='fids'/>"+
					"<span style='float:right'><a href='javascript:;' onclick='addItem("+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/addmenu.png' class='add' title='新增'/></a>&nbsp;"+
					"<a href='javascript:;' onclick='delItem(this,"+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/delmenu.png' class='add'  title='删除'/></a>"+
					"&nbsp;<a href='javascript:;' onclick='saveMenu("+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/save.png' class='add'  title='保存'/></a></span>"+
					"<ul id='m"+menus[i][0]+"' style='background:#fff'></ul></li>");
					menus[i]=null;
					count--;
				}
			}
			while(count>0){
				for(var i=0;i<menus.length;i++){
					if(menus[i]!=null){
						var parent= $("#m"+menus[i][3]);
						if(parent!=null){
							$(parent).append("<li ><input type='checkbox' name='mid' value='"+menus[i][0]+"' onclick='checkMenu(this)'/>"+
								"<input type='hidden' value='"+menus[i][0]+"' name='ids' id='id"+menus[i][0]+"'/>"+
								"<input type='text' name='names' value='"+menus[i][1]+"' id='n"+menus[i][0]+"'/>"+
								"&nbsp;链接：<input type='text' name='urls' value='"+menus[i][2]+"' id='u"+menus[i][0]+"' style='width:160px'/>"+
								"<input type='hidden' value='"+menus[i][3]+"' name='fids'/>"+
								"<span style='float:right'><a href='javascript:;' onclick='addItem("+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/addmenu.png' class='add' title='新增'/></a>&nbsp;"+
								"<a href='javascript:;' onclick='delItem(this,"+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/delmenu.png' class='add' title='删除'/></a>"+
								"&nbsp;<a href='javascript:;' onclick='saveMenu("+menus[i][0]+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/save.png' class='add' title='保存'/></a></span>"+
								"<ul id='m"+menus[i][0]+"'></ul></li>");
							menus[i]=null;
							count--;
						}
					}
				}
			}	
		});
		//点击添加按钮实现向数据库添加一条数据，并返回添加菜单的id
		//pid=父级的id号,msg=添加数据数据后得到的id号
		function addItem(fid){
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/Menus",
				data:"method=add&fid="+fid,
				dataType:"text",
				success:function(msg){
					add(fid,msg);
					$("#div").html("操作成功");
					alertDiv();
					$("#div").css("display","block");
					$("#div").fadeOut(2000);
				}			
			})
			
		}
		//根据从数据库得到的id号和父级的id添加一条新的菜单。
		function add(fid,newId){
		var count=$("#m"+fid).find("li").size()+1;
			$("#m"+fid).append("<li ><input type='checkbox' name='mid' value='"+newId+"' onclick='checkMenu(this)'/>"+
								"<input type='hidden' value='"+newId+"' name='ids' id='id"+newId+"'/>"+
								"<input type='text' name='names' value='' id='n"+newId+"'/>"+
								"&nbsp;链接：<input type='text' name='urls' value='' id='u"+newId+"'/>"+
								"<input type='hidden' value='"+fid+"' name='fids'/>"+
								"&nbsp;<span style='float:right'><a href='javascript:;' onclick='addItem("+newId+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/addmenu.png' class='add' title='新增'/></a>&nbsp;"+
								"<a href='javascript:;' onclick='delItem(this,"+newId+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/delmenu.png' class='add' title='删除'/></a>"+
								"&nbsp;<a href='javascript:;' onclick='saveMenu("+newId+")'><img src='${pageContext.request.contextPath}/backstage/menu/img/save.png' class='add' title='保存'/></a></span>"+
								"<ul id='m"+newId+"'></ul></li>");	
								
		
		}
		//单条删除
		function delItem(obj,id){
			if(confirm("确定删除吗？")&&id>0){
				$("#delIds").val($("#delIds").val()+","+id);
				$(obj).parent().parent().remove();
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/Menus",
					data:"method=delete&id="+id,				
					dataType:"text",
					success:function(msg){
						if(msg=="true"){
								$("#txt").replaceWith("<font color='green'>操作成功</font>");
								$("#div").html("操作成功");
								alertDiv();
								$("#div").css("display","block");
								$("#div").fadeOut(2000);
							}
						else{
							$("#txt").replaceWith("<font color='red'>操作失败 </font>");
							$("#div").html("操作失败");
							alertDiv();
							$("#div").css("display","block");
							$("#div").fadeOut(2000);
						}
					}
				})
			}
		}
		//批量删除
		function batchMenus(){
		if(confirm("是否删除选中的菜单")){
			var str="";
			$("input[type=checkbox]").each(function(){
				if($(this).prop("checked")){
					$("#m"+$(this).val()).find("input[type=checkbox]").each(function(){
							str+=$(this).val()+",";
						})
						str+=$(this).val()+",";
					$(this).parent().remove();
				}
			});
			$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/Menus",
					data:"method=deleteAll&id="+str,				
					dataType:"text",
					success:function(msg){					
						if(msg=="true"){
								$("#txt").replaceWith("<font color='green'>操作成功</font>");
								$("#div").html("操作成功");
								alertDiv();
								$("#div").css("display","block");
								$("#div").fadeOut(2000);
							}
						else{
							$("#txt").replaceWith("<font color='red'>操作失败 </font>");
							$("#div").html("操作失败");
							alertDiv();
							$("#div").css("display","block");
							$("#div").fadeOut(2000);
						}
					}
				})
			}
		}
		function checkMenu(obj){			
			$(obj).parent().find("input[type=checkbox]").each(function(){
				$(this).prop("checked",$(obj).prop("checked"));
			});
		}
		//保存
		function saveMenu(obj){
		var id=obj;
		var name=$("#n"+obj).val();
		var url=$("#u"+obj).val().replace("&", "#");
		for(var i=0;i<url.length;i++){
			if(url.substring(i, i+1)=="&")
				url=url.replace("&", "#");	 
		}
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/Menus",
				data:"method=update&id="+id+"&name="+name+"&url="+url,
				dataType:"text",
				success:function(msg){
						if(msg=="true"){
								$("#txt").replaceWith("<font color='green'>操作成功</font>");
								$("#div").html("操作成功");
								alertDiv();
								$("#div").css("display","block");
								$("#div").fadeOut(2000);
							}
						else{
							$("#txt").replaceWith("<font color='red'>操作失败 </font>");
							$("#div").html("操作失败");
							alertDiv();
							$("#div").css("display","block");
							$("#div").fadeOut(2000);
						}
				}			
			})
		}
		function alertDiv(){
		document.getElementById("div").style.top=($(document).scrollTop()+document.documentElement.clientHeight/8)+"px";
		}
	</script>
  </head>
  
  <body>
 	 <div class="main">
	    <p class="title" >&nbsp;菜 单 管 理</p>
	    
	    <!--<form action="${pageContext.request.contextPath}/menu.do?method=update" method="post">
	    	--><input type="hidden" name="delIds" value="" id="delIds">
	    	<div id="div" onclick="$(this).fadeOut(2000)" style="width:100px;height:25px;left:50%;top:50%;position: absolute;margin-left: -100px;margin-top: -25px;background: #1B99DE;z-index:2000;text-align: center;color: blue;display: none;">成功</div>
		    <ul>
		    	<li>菜单选项：&nbsp;<img src="${pageContext.request.contextPath}/backstage/menu/img/addmenu.png" class="add" onclick="addItem(0)"/><font id="txt"></font>
		    		<ul id="m0"  style="width:700px;border:#1b99de 3px solid;border-radius:5px;padding:0px;margin-left:30px;">
		    			
		    		</ul>
		    	</li>
		    </ul>
		    <br/>
		    <input type="button" value="批量删除" onclick="batchMenus()" class="btu"/>
		   
	  <!--  </form>
    --></div>
  </body>
</html>
