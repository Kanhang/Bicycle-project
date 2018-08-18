<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

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
  <!-- 找到一个bug，因为error一直保存在session中，所以充值了50块之后，5块充不进去了，要重新消掉那个bug -->
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">管理首页</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>充值</h3>
			</div>
			<div class="public-content-cont">
			<form id="rechargeForm"action="<%=path %>/bike/recharge">
				<div class="form-group">
					<label for="">卡号</label>
					<input class="form-input-txt" type="text" id="card_code"name="card_code" value="${param.card_code}"readonly="readonly" />
				</div>
				<div class="form-group">
						<label for="">卡类别</label>
							
							<c:choose>
				   		<c:when test="${param.card_type =='1'}">	 <!-- 如果用jstl接受上一个页面传过来的值需要加 param -->
                  <input class="form-input-txt" type="text"id="card_type" name="card_type" value="A卡"readonly="readonly"  />
				  
				   		</c:when>
				   			<c:when test="${param.card_type=='2'}">	 
                  <input class="form-input-txt" type="text" id="card_type" name="card_type" value="D卡"readonly="readonly"  />
				  
				   		</c:when>
				   		<c:when test="${param.card_type=='3'}">	 
                  <input class="form-input-txt" type="text"  id="card_type" name="card_type" value="市民卡/社保卡"readonly="readonly"  />
				  
				   		</c:when>
				   		</c:choose>
				</div>
			
				<div class="form-group" >
				   <label for="">充值类别</label>		
				   		<c:choose>
				   		<c:when test="${param.card_type=='1' or param.card_type=='3'}">	 
				   		<select class="form-input-txt" name="fee_type" id="fee_type">
			           <option value="monthly">月票
			           <option value="wallet">钱包
				   		</select>
				   		</c:when>
				   		  		<c:when test="${param.card_type=='2'}">	 
				   		<select class="form-input-txt" name="fee_type" id="fee_type">
	
			           <option value="wallet">
				   		</select>
				   		</c:when>
				   		</c:choose>
				   		
				</div>
			<br>
			<div class="form-group">
			<label for="">充值金额</label>
			<input  id="amount" name="amount"class="form-input-txt"type="text" value="0.0">
			</div>
			<br>
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</form>
			</div>
			
				<div class="clearfix"></div>
		</div>
	</div>
<script src="http://localhost:8080/bike/kingediter/kindeditor-all-min.js"></script>
<script>
	 KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
        function checkData()
        { var fee_type=document.getElementById("fee_type");
          var amount= document.getElementsByName("amount"); 
          var flag=true;
          if (fee_type.value=="monthly"){
          if(amount%5!=0){
          flag=false;
          alert("月票充值金额必须是5的倍数");}     
          }
          if(fee_type.value=="wallet"){
          if(amount%50!=0){
              flag=false;
          alert("充值钱包金额必须是50的倍数");}
          if(amount>500){
              flag=false;
          alert("每次充值金额不能大于500");}
          
          }
        if(flag==true){
        document.getElementById("rechargeForm").submit;
        }
        }
</script>
</body>
</html>
