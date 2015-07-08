<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
a{color:black;text-decoration:none;}
a:hover{color:red;text-decoration:underline;}
.table_buttom {
	width: 984px;
	height: 30px;
	background: url(images/tab_05.gif) repeat-x;
	margin: 0px;
	padding: 0px;
}

.buttom_left {
	width: 200px;
	height: 30px;
	line-height: 30px;
	color: #004200;
	font-size: 14px;
	float: left;
	margin-left: 10px;
	margin: 0px;
	padding: 0px;
}

.buttom_right {
	width: 450px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	margin: 0px auto;
	padding: 0px;
}
</style>
<div class="table_buttom">
	<div class="buttom_left">
		共有${requestScope.pager.counts}条记录，当前第${requestScope.pager.currentPage}/${requestScope.pager.pageCount}页
	</div>
	<div class="buttom_right">
		<a href="${param.url}&page=1">首页</a>
		<a href="${param.url}&page=${requestScope.pager.currentPage-1}">上一页</a>
		<a href="${param.url}&page=${requestScope.pager.currentPage+1}">下一页</a>
		<a href="${param.url}&page=${requestScope.pager.pageCount}">尾页</a> 跳转至第
		<input type="text" style="width: 30px;" id="returns" />
		页
		<a href="javascript:;" onclick="skip(skip('${param.url}&page=',$('#returns').val(),${sessionScope.pages.pageCount}))">转→</a>
	</div>
</div>
