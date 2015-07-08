<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML >
<html>
  <head>
    <title>GOLL-我要求租</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/front/person/css/qiuzu.css"/>
<title>我要求租</title>
</head>

<body>
	<div class="qiuzu">
		<div class="logo">
        	<img src="${pageContext.request.contextPath}/${applicationScope.Oversystems.sys_logo}" alt="logo" class="logo_img" style="width:300px;"/>
            <p class="logo_menu"><a href="">登录</a>&nbsp;|&nbsp;<a href="">返回首页</a></p>
        </div>
        <p class="menu"><a href="${pageContext.request.contextPath}/FrontHouses?method=queryIndex">首页</a><a href="">出租</a><a href="">求租</a><a href="${pageContext.request.contextPath}/relevance?method=selForFront&state=publish">发布信息</a></p>
        <p class="weizhi">&nbsp;<a href="${pageContext.request.contextPath}/front/houses/web_page/index.jsp">${applicationScope.Oversystems.sys_name}</a> &nbsp;»&nbsp;我要求租</p>
        <!--友情提示-->
        <div class="hint">
          <dl>
        	<dt style="text-indent:10px;">友情提示：</dt>
            <dd>1.您正在匿名发布求租，注册成为GOLL网通行证会员，发布信息更加方便、快捷。</dd>
            <dd>2.每个手机号码最多可发布<span class="orange">5</span>条求租。</dd>
            <dd>3.中介客户发布房源请免费注册网络经纪人,享受更多服务。</dd>
          </dl>
        </div>
        <!--个人发布消息-->
        <div class="person">
        	<div class="info">
            	<p class="title">发布求租信息</p>
                <div class="cont">
                	<form method="post" action="${pageContext.request.contextPath}/SeekRent?method=saveSeek">
                    	<p><span>姓&nbsp;&nbsp;名:</span><input type="text" name="name"/></p>
                        <p><span>联系电话:</span><input type="text" name="tel"/></p>
                         <p><span>理想价格:</span><input type="text" name="price1" style="width:50px;"/><span style="margin-left:0px;width:15px;">--</span><input type="text" name="price2" style="width:50px;"><span style="margin-left:0px;">元/月</span></p>
                         <p><span>区&nbsp;&nbsp;域:</span><select name="area">
                         	<c:forEach items="${requestScope.alist}" var="area" varStatus="i">
                         		<option value="${area.a_id}"
                         			<c:if test="${i.index==0}">selected="selected"</c:if>
                         		>${area.a_name}</option>
                         	</c:forEach>                       
                         </select></p>
                          <p><span>小&nbsp;&nbsp;区:</span><select name="small_area">
                         	<c:forEach items="${requestScope.salist}" var="sa" varStatus="i">
                         		<option value="${sa.sa_id}"
                         			<c:if test="${i.index==0}">selected="selected"</c:if>
                         		>${sa.sa_name}</option>
                         	</c:forEach>                       
                         </select></p>
                         <div class="desc">
                         	<span>具体描述:</span>
                         	<textarea name="sr_infos" ></textarea> 
                         </div>
                         <p class="subm"><input type="submit" value="提交" id="sub"></p>
                	</form>
                </div>
            </div>
       <!-- 	其他相关信息-->
       		<div class="other">
            	<p class="title">热门房源</p>
                <div class="hot_house">
                	
                	<c:forEach items="${requestScope.houselist}" var="house">
	                	<div class="houses">
	                      	<img src="${pageContext.request.contextPath}/front/person/img/360x270.jpg">
	                       <p><a href="${pageContext.request.contextPath}/Houses?method=queryHouseById&skipTo=front&h_id=${house.h_id}" title="点击查看详情">${house.h_name}</a></p>
	                        <p><font color="#FF0000">${house.h_price}</font>元/月</p>
	                    </div>
                    </c:forEach>
                  
                </div>
            </div>
        </div>
        <img src="${pageContext.request.contextPath}/front/person/img/1386144886738.jpg" style="width:980px;height:60px;"/>
    	<iframe src="${pageContext.request.contextPath}/front/common/footer.jsp" style="width:100%;height:200px;" frameborder="0"></iframe>
    </div>
</body>
</html>
