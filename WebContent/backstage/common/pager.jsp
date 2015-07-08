<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
.table_buttom{
	width:100%;
	height:30px;
	background:#1b99de;
	padding:0px;
	border-radius:0px 0px 5px 5px;
	}
.buttom_left{
	width:200px;
	height:30px;
	line-height:30px;
	color:#004200;
	font-size:14px;
	float:left;
	margin-left:10px;
	margin:0px;
	padding:0px;
	}
.buttom_right{
	width:450px;
	height:30px;
	line-height:30px;
	font-size:14px;
	float:right;
	margin:0px;
	padding:0px;
}
</style>
 <div class="table_buttom">
		<div class="buttom_left">
			 共${sessionScope.pages.counts}条记录，当前第 ${sessionScope.pages.currentPage}/${sessionScope.pages.pageCount} 页
		</div>
	    <div class="buttom_right">
      	<a href="${param.url}&page=1"><input type="button" value="首页"></a>
        <a href="${param.url}&page=${sessionScope.pages.currentPage-1}"><input type="button" value="上一页"/></a>
        <a href="${param.url}&page=${sessionScope.pages.currentPage+1}"><input type="button" value="下一页"/></a>      
        <a href="${param.url}&page=${sessionScope.pages.pageCount}"><input type="button" value="尾页"/></a>
				                        跳转至第<input type="text" style="width:30px;" id="returns"/> 页
				                    <input type="button" value="→转" onclick="skip('${param.url}&page=',$('#returns').val(),${sessionScope.pages.pageCount})"/>
				                    </div>
				                </div>
