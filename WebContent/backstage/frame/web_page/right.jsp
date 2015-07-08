<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/frame/css/right_css.css"/>
</head>
	
<body>
<div id="mainbody">
		<div id="trendsInfo">
        	<div class="title"> <span> 动态信息</span></div>
            <div class="trend_context">
            	<p>在线人数(${applicationScope.online })</p> 
                <p>房源总数(${applicationScope.OverhouseAll })</p> 
                <p>经纪人(${applicationScope.OverbrokerAll })</p> 
                <p>中介公司(${applicationScope.OvercompanysAll })</p>       
                <p>求租房源(${applicationScope.OverSrAll })</p>       
            </div>
        </div>
        <!--快捷菜单-->
        <div id="shortcut">
        	<div class="title"> <span> 快捷菜单</span></div>
            <div class="shortcut_context">
            	<div class="menu" onclick="javascript:;">
            			<a href="${pageContext.request.contextPath}/Houses?method=queryAll" style="display:block;text-decoration: none;">
            				<img alt="查看房源列表" src="${pageContext.request.contextPath}/backstage/frame/img/house.jpg">
            				<p>查看房源</p>
            			</a>
            	</div>
               <div class="menu" onclick="javascript:;">
              		 <a href="${pageContext.request.contextPath}/Brokeres?method=query&ischeck=null&status=2" style="display:block;text-decoration: none;">
            			<img alt="添加经纪人列表" src="${pageContext.request.contextPath}/backstage/frame/img/broker.png">
            			<p>查看经纪人</p>
            		 </a>
            	</div>
            	<div class="menu" onclick="javascript:;">
            		<a href="${pageContext.request.contextPath}/SmallAreas?method=query&type=0" style="display:block;text-decoration: none;">
            			<img alt="查看小区列表" src=" ${pageContext.request.contextPath}/backstage/frame/img/area.png">
            			<p>查看小区</p>
            	    </a>	
            	</div>  
                <div class="menu" onclick="javascript:;">
                	<a href="${pageContext.request.contextPath}/Historys?method=query" style="display:block;text-decoration: none;">
            			<img alt="历史记录" src="${pageContext.request.contextPath}/backstage/frame/img/history.png">
            			<p>历史记录</p>
            		</a>	
            	</div>       
            </div>
       	 </div>
         <!--系统审核-->
         <div id="trendsInfo">
        	<div class="title"> <span> 尚未审核</span></div>
            <div class="trend_context">
            	<p>用户总数(<a href="${pageContext.request.contextPath }/Managers?method=selForcheck&ischeck=0" id="hc" style="color: red;text-decoration: none;">${applicationScope.OverManager }</a>)</p> 
            	<p>房源总数(<a href="${pageContext.request.contextPath }/Houses?method=queryForCheck&h_isCheck=0&state=2" id="hc" style="color: red;text-decoration: none;">${applicationScope.Overhouse }</a>)</p> 
                <p>经纪人(<a href="${pageContext.request.contextPath }/Brokeres?method=query&ischeck=0&status=0" style="color: red;text-decoration: none;">${applicationScope.Overbroker }</a>)</p> 
                <p>中介公司(<a href="${pageContext.request.contextPath }/Companys?method=query&type=2" style="color: red;text-decoration: none;">${applicationScope.Overcompanys }</a>)</p>       
                <p>求租房源(<a href="${pageContext.request.contextPath}/SeekRent?method=selAll&state=2&ischeck=0" style="color: red;text-decoration: none;">${applicationScope.OverSr }</a>)</p>       
            </div>
        </div>
        <!--服务器信息-->
        <div id="systemInfo">
        	<div class="title"> <span>服务器信息</span></div>
             <div class="systemInfo_context">
            	<table width="90%"  id="tab" >
                	<tr><td class="menu_table">服务器名称：</td><td>${sessionScope.sys.sys_name }</td>
                	<td class="menu_table">服务器版本：</td><td>${sessionScope.sys.sys_infos }</td></tr>
                	<tr><td class="menu_table">端口：</td><td>${sessionScope.sys.sys_logo }</td>
                	<td class="menu_table">开发团队：</td><td>Goll小组</td></tr>
            </table>            
            </div>
        </div>
        
    </div>
</body>
</html>
