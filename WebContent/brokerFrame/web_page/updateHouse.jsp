<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.goll.dao.IRent_TypesDao"%>
<%@page import="cn.goll.service.IRent_TypesService"%>
<%@page import="cn.goll.service.impl.Rent_TypesServiceImpl"%>
<%@page import="cn.goll.entity.Rent_Types"%>
<%@page import="cn.goll.service.IHouse_TypesService"%>
<%@page import="cn.goll.service.impl.House_TypesServiceImpl"%>
<%@page import="cn.goll.entity.House_Types"%>
<%@page import="cn.goll.service.ISmall_AreasService"%>
<%@page import="cn.goll.service.impl.Small_AreasServiceImpl"%>
<%@page import="cn.goll.entity.Small_Areas"%>
<%@page import="cn.goll.service.IPay_TypesService"%>
<%@page import="cn.goll.service.impl.Pay_TypesServiceImpl"%>
<%@page import="cn.goll.entity.Pay_Types"%>
<%@page import="cn.goll.service.IHouse_Equip_TypesService"%>
<%@page import="cn.goll.service.impl.House_Equip_TypesServiceImpl"%>
<%@page import="cn.goll.entity.House_Equip_Types"%>
<%@page import="cn.goll.service.IHousesService"%>
<%@page import="cn.goll.service.impl.HousesServiceImpl"%>
<%@page import="cn.goll.entity.Houses"%>
<%String id=request.getParameter("id");
 	IHousesService 	hs=new HousesServiceImpl();
 	Houses house=hs.queryHouseById(Integer.parseInt(id));
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>经纪人后台添加房源页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- ueditor -->
	<script type="text/javascript">window.UEDITOR_UPLOAD_URL = "${pageContext.request.contextPath}/upload/";</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/brokerFrame/css/addHouse.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=846b0044865e29d73dc3af374b6d7a47"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var map=new BMap.Map("map");
		var point=new BMap.Point(<%=house.getH_xpoint()%>,<%=house.getH_ypoint()%>);
		map.centerAndZoom(point,15);
		map.enableScrollWheelZoom();
		var contr=new BMap.NavigationControl();
		map.addControl(contr);
		var mark=new BMap.Marker(point);
		map.addOverlay(mark);
		mark.enableDragging();
		var opt={width:100,height:30,title:"改变坐标"} 
		var infor=new BMap.InfoWindow("拖动该气泡改变楼盘的地图坐标",opt);
		mark.addEventListener("mouseover",function(){
			mark.openInfoWindow(infor,opt);
		});
		mark.addEventListener("dragend",function(e){
			map.closeInfoWindow();
			$("#bd_x").val(e.point.lng);
			$("#bd_y").val(e.point.lat);
		})
	});	
	</script>
	<!-- 网页编辑器 -->
	<script type="text/javascript">
		window.UEDITOR_UPLOAD_URL = "${pageContext.request.contextPath}/upload/";//修正根路径
		function getContent() {
	        $("#infos").val(UE.getEditor('myEditor').getContent());
	        return true;
	    }
	    var i=1;
	    function add(){
	  	  i++;
	  	  str="<p><span class='in_span1'>上传图片:</span><input type='text' id='photo"+i+"'  name='path' readonly='readonly'><iframe src='${pageContext.request.contextPath}/brokerFrame/web_page/upload.jsp?mark="+i+"&fun=logoBack&type=2'   frameborder='0'></iframe><input type='button' value='添加' style='float:right;width: 50px' onclick='add()'/><input type='button' value='删除' style='float:right;width: 50px;' onclick='$(this).parent().remove();'/></p>";
          	$("#photos").append(str);	
	    }
	    function logoBack(mark,path){
			$("#photo"+mark).val(path);
		}
	</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
	
</head>

<body>
	<div id="main" style="width:980px;height:800px;margin:0px auto;">
    	<p> 经纪人&raquo;修改房源</p>
        <!-- 采集信息-->
        <div class="collect">
        	<form action="${pageContext.request.contextPath }/Houses?method=add&h_ischarge=1" method="post" onsubmit="return getContent()" target="_top">
            <!--基本数据-->
       		<div style="width:420px;float:left;">
                 <p class="title" style="width:422px;border-radius:5px 5px 0px 0px;">基本信息</p>
               	 <div class="information" style="height:360px;width:420px;border:#1b99de 1px solid;">
                    <p><span class="in_span1">房源编号:</span><input type="text" name="h_number" value="<%=house.getH_number()%>"><span id="h_number"></span></p>
                    <p><span class="in_span1">出租方式:</span>
                    <%IRent_TypesService rtService=new Rent_TypesServiceImpl();
                      List<Rent_Types> rtList=rtService.queryAllRent_Types();
                      for(int i=0;i<rtList.size();i++){	
                      	Rent_Types rt=rtList.get(i);
                    %>
                      <input type="radio" name="rt_id" value="<%=rt.getRt_id() %>" checked style="width:10px;margin-left:10px"><span><%=rt.getRt_name()%></span>
                    <%} %>
                    <p><span class="in_span1">房屋大小:</span><input type="text" name="h_proportion" maxlength="3" value="<%=house.getH_proportion()%>"><span>平米</span><span id="h_proportion"></span></p>   
                    <p><span class="in_span1">所在楼层:</span><input type="text" name="h_floor" maxlength="2" value="<%=house.getH_floor()%>"><span>&nbsp;F</span><span id="h_floor"></span></p>				                
                    <p><span class="in_span1">共计楼层:</span><input type="text" name="h_all_floor" maxlength="2" value="<%=house.getH_all_floor()%>"><span>&nbsp;F</span><span id="h_all_floor"></span></p>
                    <p><span class="in_span1">租&nbsp;&nbsp;金:</span><input type="text" name="h_price" maxlength="3" value="<%=house.getH_price()%>"><span>元/月</span><span id="h_price"></span></p> 
                    <p><span class="in_span1">房源状况:</span>
                    <select style="width:150px;" name="ht_id">
                    <%IHouse_TypesService htService=new House_TypesServiceImpl();
                      List<House_Types>	htList=htService.queryAllHouse_Types();
                      for(int i=0;i<htList.size();i++){
                      	House_Types ht=htList.get(i);
                    %>
                    	<option value="<%=ht.getHt_id() %>" 
                    	<% if(ht.getHt_id()==house.getHt_id()){%>
                    	selected
                    	<%}%>><%=ht.getHt_name() %></option>
                    <%} %>
                    </select></p> 
                    <p><span class="in_span1">所在小区:</span>
                     <select style="width:150px;" name="sa_id">
                     <%ISmall_AreasService saService=new Small_AreasServiceImpl();
                      List<Small_Areas>	saList=saService.querySmall_Areas("1");
                      for(int i=0;i<saList.size();i++){
                      	Small_Areas sa=saList.get(i);
                    %>
                    	<option value="<%=sa.getA_id()%>"
                    	><%=sa.getSa_name()%></option>
                    <%} %>
                    </select></p> 
                    <p><span class="in_span1">支付方式:</span>
                    <select style="width:150px;" name="pt_id">
                    <%IPay_TypesService ptService=new Pay_TypesServiceImpl();
                      List<Pay_Types> ptList=ptService.queryAllPay_Types();
                      for(int i=0;i<ptList.size();i++){
                      	Pay_Types pt=ptList.get(i);
                     %>
                     	<option value="<%=pt.getPt_id() %>"
                     	<% if(pt.getPt_id()==house.getPt_id()){%>
                    	selected
                    	<%}%>><%=pt.getPt_name()%></option>
                     <%} %>
                    </select></p> 
                </div>
            </div>
            <!--地图-->
            <div class="maplist">
	          	<p class="title">地图定位:</p>
	          		<span  style="margin-left:10px;">经度</span><input type="text" name="h_xpoint" id="bd_x" style="width:100px;" value="<%=house.getH_xpoint() %>"/>
	          	<span>纬度</span><input type="text" name="h_ypoint" id="bd_y" style="width:100px;" value="<%=house.getH_ypoint()%>"/>
	          	<div id="map" style="width:100%;height:85%;margin-top:8px;border:#ccc 1px solid"></div>
	          </div>  
            
           <!-- 详情-->
            <p class="title" style="clear:both">房源详情</p>
        	<div class="information" style="height:420px;">
            	<p><span class="in_span1">房屋标题:</span><input type="text" name="h_title" style="width:250px;" maxlength="50" value="<%=house.getH_title()%>"><span id="h_title"></span></p>
            	<p><span class="in_span1">房屋关键字:</span><input type="text" name="h_tag" style="width:250px;" maxlength="50" value="<%=house.getH_tag()%>"><span id="h_tag"></span></p>
            	<div style="width:100%;height:60px;margin-top:10px;"><span style="display:block;width:50px;height:30px;float:left;margin-left:80px">配&nbsp;&nbsp;置:</span>
                	<table style="float:left;">
                		<tr>
                		<%IHouse_Equip_TypesService hetService=new House_Equip_TypesServiceImpl();
                		  List<House_Equip_Types> hetList=hetService.queryAllHouse_Equip_Types();
                		  for(int i=0;i<hetList.size();i++){	
                			House_Equip_Types het=hetList.get(i);
                		%>
                		<td><input type="checkbox" name="het_ids" value="<%=het.getHet_id()%>" style="width:10px" ><%=het.getHet_name() %></td>
                		<%} %>
                		</tr>
                    </table>
                </div>
                <div class="info">
               	 <p style="width:80px;height:30px;float:left;margin-left:60px;">房屋描述:</p>               	 
                	<div style="width:700px;height:200px;float:left;border:green 1px solid;">
                  			<input type="hidden" name="infos" id="infos"/>
							<script type="text/plain" id="myEditor" style="width:690px">
      						  <p>可以重新进行描述</p>
   							</script>
				   			 <script type="text/javascript">
				     		   var ue = UE.getEditor("myEditor");
				   			 </script>
                    </div>
                </div>
                <div id="photos">
            	 <p><span class="in_span1">上传图片:</span>
            	<input type="text" id="photo1"  name="path" readonly="readonly">
            	<iframe src="${pageContext.request.contextPath}/brokerFrame/web_page/upload.jsp?mark=1&fun=logoBack&type=2"   frameborder="0"></iframe>
          		<input type="button" value="添加" style="float:right;width: 50px" onclick="add();"/><input type="button" value="删除" style="float:right;width: 50px;" onclick="$(this).parent().remove();"/>
          		</p>
          		</div>	
            </div>
            <br/>
           	<div style="width:100%;height:30px;text-align:center">
                <input type="submit" value="提交" style="width:120px;height:30px;background:#1b99d;">
                <input type="button" value="返回" onclick="history.go(-1);" style="width:120px;height:30px;background:#1b99d;"/>
            </div>
        	</form>
        </div>
        
        
    </div>
    
</body>
</html>
