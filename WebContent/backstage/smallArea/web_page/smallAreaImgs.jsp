<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>小区图片</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{margin:0;padding:0;}
		.object_img{float:left;width:200px;height:250px;margin:12px 20px;position:relative;overflow:hidden;background:#888;}
		.object_img_div{width:100%;height:100%;}
		.operate{width:100%;height:24px;position:absolute;top:250px;text-align:center;}
		.operate a{color:#1b99de;text-decoration:none;}
		.operate_check{float:left;width:100px;height:24px;line-height:24px;text-align:center;}
		.operate_remove{float:left;width:100px;height:24px;line-height:24px;text-align:center;color:#1b99de;cursor:pointer;}
	</style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script>
		var widthOld;
		var heightOld;
		var widthNew;
		var heightNew;
    	function init(){
			var margin;
    		var value;
    		var marginPosition;
			$("#main_div").css({width:window.screen.availWidth-180+"px",height:window.screen.availHeight-262+"px"});//108
			$("img").each(function(index, element) {
				widthOld=parseInt($(this).css("width"));
				heightOld=parseInt($(this).css("height"));
				if(widthOld>heightOld){
					marginPosition="margin-top";
					widthNew=parseInt($(this).parent().css("width"));
					scale=widthOld/widthNew;
					heightNew=heightOld/scale;
					$(this).css({position:"absolute",top:"50%"});
				}else if(widthOld<=heightOld){
					marginPosition="margin-left";
					heightNew=parseInt($(this).parent().css("height"));
					scale=heightOld/heightNew;
					widthNew=widthOld/scale;
					$(this).css({position:"absolute",left:"50%"});
				}
				$(this).css({width:widthNew,height:heightNew});
				if(marginPosition=="margin-left")
					margin=$(this).css("width");
				else if(marginPosition="margin-top")
					margin=$(this).css("height");
				value=parseInt(margin)/2;
				$(this).css(marginPosition,"-="+value);
			});;
		}
		function over(obj){
			$(obj).css("background","#999");
			$(obj).find(".operate").animate({marginTop:"-24px"},{speed:50,queue:false});
		}
		function out(obj){
			$(obj).css("background","#888");
			$(obj).find(".operate").animate({marginTop:"0px"},{speed:50,queue:false});
		}
		function del(sai_id,sa_id){
			if(confirm("确定要删除吗?")){
				window.location.href="SmallAreaImgs?method=remove&type=1&sai_id="+sai_id+"&sa_id="+sa_id;
			}
		}
    </script>
</head>

<body onLoad="init()">
	<div id="main_div">
		<c:forEach items="${requestScope.smallAreaImgs}" var="smallAreaImg">
	    	<div class="object_img" onMouseOver="over(this)" onMouseOut="out(this)">
	        	<div class="object_img_div"><img src="${pageContext.request.contextPath}/img/img/${smallAreaImg.sai_url}"/></div>
	        	<div class="operate">
	    			<p class="operate_check"><a href="SmallAreaImgs?method=check&type=2&sai_id=${smallAreaImg.sai_id}&sa_id=${requestScope.sa_id}">审核</a></p>
	                <p class="operate_remove" onclick="del(${smallAreaImg.sai_id},${requestScope.sa_id})">删除</p>
	            </div>
	        </div>
        </c:forEach>
    </div>
</body>
</html>