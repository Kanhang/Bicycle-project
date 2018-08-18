<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="UTF-8">
	<title>后台欢迎页</title>
	<link rel="stylesheet" href="http://localhost:8080/bike/css/reset.css" />
	<link rel="stylesheet" href="http://localhost:8080/bike/css/content.css" /><!-- 以后写绝对路径 -->
  </head>
  
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">管理首页</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>信息搜索</h3>
			</div>
			<div class="public-content-cont">
			<form action="" method="post">
				<div class="form-group">
					<label for="">卡号</label>
					<input class="form-input-txt" type="text" name="card_code" value="" />
				</div>
				<div class="form-group">
						<label for="">卡类别</label>
                   <select class="form-input-txt" name="cardType">
                   	<option value="ACard" >A卡</option>
                   	 	<option value="DCard" >D卡</option>
                   	 	<option value="citizenCard">市民卡</option>
                   	 	<option value="socialSecurityCard">社保卡</option>
                   	 	<option value="employeeCard">市民卡</option>
                   	 	<option value="transferCard">调度卡</option>
                   </select>
				</div>
				<div class="form-group">
					<label for="">用户姓名</label>
					  <input class="form-input-txt" type="text" name="name" value="" />
				</div>
				<div class="form-group" >
				   <label for="">身份证号</label>		
				   		  <input class="form-input-txt" type="text" name="idcard" value="" />		
				</div>
				<div class="form-group">
					<label for="">性别</label>
					       <select class="form-input-txt" name="sex">
                   	<option value="男" >男</option>
                   	 	<option value="女" >女</option>
                 
                   </select>
				</div>
					<div class="form-group" >
				   <label for="">固定电话</label>		
				   		  <input class="form-input-txt" type="text" name="telphone" value="" />		
				</div>
						<div class="form-group" >
				   <label for="">移动电话</label>		
				   		  <input class="form-input-txt" type="text" name="mobile" value="" />		
				</div>
					<div class="form-group" >
				   <label for="">邮箱</label>		
				   		  <input class="form-input-txt" type="text" name="email" value="" />		
				</div>
				<div class="form-group" >
				   <label for="">地址</label>		
				   		  <input class="form-input-txt" type="text" name="address" value="" />		
				</div><div class="form-group" >
				   <label for="">工作</label>		
				   		  <input class="form-input-txt" type="text" name="work" value="" />		
				</div>
			<br>
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</form>
			</div>
				<div class="clearfix"></div>
		</div>
	</div>
<script src="http://localhost:8080/kingediter/kindeditor-all-min.js"></script>
<script>
	 KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>
</body>
</html>
