<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>GOLL-个人发布</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/person/css/person_publish.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<!-- ueditor -->
	<script type="text/javascript">window.UEDITOR_UPLOAD_URL = "${pageContext.request.contextPath}/upload/";</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
	
</head>

<body>
	<div id="main" style="width:980px;height:1500px;margin:0px auto;">
    	<!--logo-->
        <div class="logo">
        	<img src="${pageContext.request.contextPath}/${applicationScope.Oversystems.sys_logo}" alt="logo" class="logo_img" style="width:300px;"/>
            <p class="logo_menu"><a href="${pageContext.request.contextPath}/brokeres/web_page/brokerLogin.jsp">登录</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex">返回首页</a></p>
        </div>
        <p class="weizhi">&nbsp;<a href="">${applicationScope.Oversystems.sys_name}</a> &nbsp;»&nbsp;我要出租</p>
        <!--友情提示-->
        <div class="hint">
          <dl>
        	<dt style="text-indent:10px;">友情提示：</dt>
            <dd>1.您正在匿名发布房源，注册成为搜房网通行证会员，发布管理房源信息更加方便、快捷。</dd>
            <dd>2.每个手机号码最多可发布<span class="orange">5</span>条房源。</dd>
            <dd>3.中介客户发布房源请<a href="${pageContext.request.contextPath}/front/brokeres/web_page/register.jsp">免费注册网络经纪人</a>,享受更多服务。</dd>
          </dl>
        </div>
        
        <!-- 采集信息-->
        <div class="collect">
        	<form action="Houses?method=addNewHouse" method="post" onsubmit="return sub()">
        	<!--联系方式-->
        	<p class="title">联系方式</p>
        	<div class="information">
            	<p><span class="in_span1">联&nbsp;系&nbsp;人:</span><input type="text" name="p_name" maxlength="5" id="name" onblur="blurName()"><span id="p_name"></span></p>
                <p><span class="in_span1">联系电话:</span><input type="text" name="p_tel" id="phone" onblur="blurPhone()"><span id="p_tel"></span></p>
            </div>
            <!--基本数据-->
       		 <p class="title">基本信息</p>
        	<div class="information" style="height:400px;">
            	<p><span class="in_span1">房源名称:</span><input type="text" name="h_name" id="hName" onblur="blurHname()"><span id="h_name"></span></p>
            	<p><span class="in_span1">出租方式:</span>
            		<c:forEach items="${requestScope.rtList}" var="rt" varStatus="i">
            			<input type="radio" name="rt_type"
            				<c:if test="${i.index==0}">
            				 checked 
            				 </c:if>
            				value="${rt.rt_id}" style="width:10px;margin-left:10px"><span>${rt.rt_name}</span>
               		</c:forEach><span id="rt_type"></span>
               	</p>
                <p><span class="in_span1">房源状况:</span>
                	<select id="p_te" name="ht">
                	<c:forEach items="${requestScope.htList}" var="ht" varStatus="i">
                		<option value="${ht.ht_id}"
                		<c:if test="${i.index==0}">selected="selected"</c:if>
                		>${ht.ht_name}</option>
                	</c:forEach>
                	</select>
               		<span id="p_t"></span></p>
				<p><span class="in_span1">房屋大小:</span><input type="text" name="h_size" maxlength="3" id="size" onblur="blurSize()"><span>平米</span><span id="h_size"></span></p>   
                <p><span class="in_span1">所在楼层:</span><input type="text" name="h_floor" maxlength="2" id="floor" onblur="blueFloor()"><span>&nbsp;F</span><span id="h_floor"></span></p>	
                <p><span class="in_span1">共计楼层:</span><input type="text" name="h_all_floor" maxlength="2" id="AllFloor" onblur="blueAllFloor()"><span>&nbsp;F</span><span id="h_all_floor"></span></p>
                <p><span class="in_span1">租&nbsp;&nbsp;金:</span><input type="text" name="h_monry" maxlength="10" id="monry" onblur="blueMonry()"><span>元/月</span><span id="h_monry"></span></p> 
                <p><span class="in_span1">支付方式:</span><select style="width:150px;" name="py">
	                	<c:forEach items="${requestScope.pyList}" var="py" varStatus="i">
	                		<option value="${py.pt_id}" 
	                			<c:if test="${i.index==0}">selected="selected"</c:if>
	                		>${py.pt_name}</option>
	                	</c:forEach>
                	</select></p> 
                 <p><span class="in_span1">所在区域:</span><select style="width:150px;" name="area">
	                	<c:forEach items="${requestScope.alist}" var="area"  varStatus="i">
	                		<option value="${area.a_id}" 
	                			<c:if test="${i.index==0}">selected="selected"</c:if>
	                		>${area.a_name}</option>
	                	</c:forEach>
                	</select></p> 
                 <p><span class="in_span1">小&nbsp;&nbsp;区:</span><select style="width:150px;" name="smallArea">
	                	<c:forEach items="${requestScope.salist}" var="sa" varStatus="i">
	                		<option value="${sa.sa_id}" 
	                			<c:if test="${i.index==0}">selected="selected"</c:if>
	                		>${sa.sa_name}</option>
	                	</c:forEach>
                	</select></p> 
            </div>
           <!-- 详情-->
            <p class="title">房源详情</p>
        	<div class="information" style="height:420px;">
            	<p><span class="in_span1">房屋标题:</span><input type="text" name="h_info" style="width:250px;" maxlength="50" id="tag" onblur="blurTag()"><span id="h_info"></span></p>
            	<div style="width:100%;height:60px;margin-top:10px;"><span style="display:block;width:80px;height:30px;float:left;margin-left:80px">配&nbsp;&nbsp;置:</span>
                	<div style="width:450px;height:60px;float:left;">
	                	<c:forEach items="${requestScope.hetList}" var="het" varStatus="i"> 
	                    	<div style="width:100px;height:25px;float:left;margin:0px;"><input type="checkbox" name="deploy" value="${het.het_id}" style="width:10px;float:left"><span style="font-size:15px;line-height:25px;">${het.het_name}</span></div>
	                    </c:forEach>
	                 </div>
                </div>
                <div class="info" style="height:250px;">
               	 <p style="width:80px;height:30px;float:left;margin-left:60px;">房屋描述:</p>
                	<div style="width:600px;height:230px;float:left;">
                			<script type="text/plain"  id="myEditor" style="width:100%;height:80%;">该房源经济实惠,环境优雅,配套齐全，拎包即可入住</script>
							<script type="text/javascript">
						         UE.getEditor("myEditor");
						    </script>
						    <input type="hidden"  name="h_information"  id="info" />
                	</div>
                </div>
            </div>
           	<div style="width:100%;height:30px;text-align:center;">
                <input type="submit" value="提交" style="width:120px;height:30px;background:#1b99d;">
            </div>
        	</form>
        </div>
        
        
    </div>
<script type="text/javascript">
	var  phone=/^[0-9]{1,11}$/;//电话号码
	var h_size=/^[1-9][0-9]{0,2}$/;//房屋面积
	var h_floor=/^[1-9][0-9]{0,2}$/;//楼层
	var h_monry=/^\d$/;//租金
	//姓名的验证
	function blurName(){
		if($("#name").val()!=""){
			$("#p_name").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#p_name").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;
		}
	}
	//联系电话
	function blurPhone(){
		if(phone.test($("#phone").val())){
			$("#p_tel").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#p_tel").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}	
	}
	//房源名称
	function blurHname(){
		if($("#hName").val()!=""){
			$("#h_name").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_name").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;
		}	
	}
	//面积
	function blurSize(){
		if(h_size.test($("#size").val())){
			$("#h_size").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_size").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}	
	}
	//楼层
	function blueFloor(){
		if(h_floor.test($("#floor").val())){
			$("#h_floor").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_floor").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}	
	}
	//楼层
	function blueAllFloor(){
		if(h_floor.test($("#AllFloor").val())&&$("#AllFloor").val()>=$("#floor").val()){
			$("#h_all_floor").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_all_floor").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}	
	}
	//租金
	function blueMonry(){
		if(h_floor.test($("#monry").val())){
			$("#h_monry").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_monry").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}	
	}
	function blurTag(){
		if(h_floor.test($("#monry").val())){
			$("#h_info").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/true.png'/>");
			return true;
		}else{
			$("#h_info").html("&nbsp;<img style='width:25px;height:25px;' src='${pageContext.request.contextPath}/img/li_err.gif'/>");
			return false;		
		}
	}
	
	function sub(){
		if(blurName()&&blurPhone()&&blurHname()&&blurSize()&&blueFloor()&&blueAllFloor()&&blueMonry()&&blurTag()){
			$("#info").val(UE.getEditor("myEditor").getContent());
			return true;
			}
		else{alert("亲,还有资料没有填哟！"); return false;}
	}
</script>
</body>
</html>
