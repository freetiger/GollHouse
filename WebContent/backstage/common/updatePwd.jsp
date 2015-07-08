<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <style>
	.alertPwd{width:400px;height:300px;border:#1d44de 3px solid;border-radius:5px; box-shadow:5px 5px #0099CC;position:absolute;left:50%;top:50%;margin-left:-150px;margin-top:-150px;background:#6CF}
	.alertPwd p{
		width:300px;height:30px;line-height:30px;margin-left:30px;margin-top:20px;
		}
	.txt{width:80px;float:left; display:block;height:30px; text-align:center;}
	input{width:150px;height:20px;}
</style>
</head>

<body>
	<div class="alertPwd">
    	<form action="" method="post">
        	<p><span class="txt">用户名:</span><input type="text" value="" name="uname"></p>
            <p><span class="txt">旧密码:</span><input type="password" value="" name="old_pwd"></p>
            <p><span class="txt">新密码:</span><input type="password" value="" name="new_pwd"></p>
            <p><span class="txt">确认密码:</span><input type="password" value="" name="new_pwd"></p>
            <input type="submit" value="保存" style="width:80px;height:30px;background:#13820B;margin-left:160px;">
        </form>    
    </div>
</body>
</html>
