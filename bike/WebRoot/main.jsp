<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
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
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/content.css" />
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<style type="text/css">
table {
	border-collapse: collapse;
	border: solid 1px Black;
}

th,td {
	padding: 0.3em 1em;
}
</style>
<script type="text/javascript">
	function goPage(currentPage){
	var card_code=$.trim($("#card_code").val());
	var name=$.trim($("#name").val());
	var card_type=$.trim($("#card_type").val());
	var sex=$.trim($("#sex").val());
	var params={
	"currentPage":currentPage,
	"card_code":card_code,
	"name":name,
	"card_type":card_type,
	"sex":sex
	};
	$.ajaxSettings.traditional=true;
	$("#dataList").load("<%=path%>/bike/datalist",params);
	}

	</script>
</head>
<body marginwidth="0" marginheight="0" onload="goPage(1)">
	<div class="container">

		<div id="dataList" class="public-content-header">
			<div class="public-nav">
				您当前的位置：<a href="">已注册的自行车卡列表</a>
			</div>
			
			<div class="public-content">
		
				<h3>查询条件</h3>

				<div class="public-content-cont">
					卡号:<input type="text" id="card_code"> 名字:<input type="text"
						id="name"> 类型:<input type="text" id="card_type">
					性别:<input type="text" id="sex"> <input type="button"
						value="查询" onclick="goPage(1)" /> <br> <br>

				</div>
			</div>
			<table cellspacing="1">
				<tr>
					<th>编号</th>
					<th>卡号</th>
					<th>类型</th>
					<th>姓名</th>
					<th>身份证</th>
					<th>性别</th>
					<th>注销标记</th>
					<th>月费</th>
					<th>冻结金额</th>
					<th>钱包金额</th>

					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${page.dataList}" var="Card" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td>${Card.card_code}</td>
						<c:choose>
							<c:when test="${Card.card_type==1}">
								<td>A卡</td>
							</c:when>
							<c:when test="${Card.card_type==2}">
								<td>D卡</td>
							</c:when>
							<c:when test="${Card.card_type==3}">
								<td>市民卡/社保卡</td>
							</c:when>
							<c:when test="${Card.card_type==4}">
								<td>员工卡</td>
							</c:when>
							<c:when test="${Card.card_type==5}">
								<td>调度卡</td>
							</c:when>
						</c:choose>

						<!-- change -->
						<td>${Card.name}</td>
						<td>${Card.idcard}</td>
						<c:choose>
							<c:when test="${Card.sex==1}">
								<td>男</td>
							</c:when>
							<c:when test="${Card.sex==0}">
								<td>女</td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${Card.ZXBJ==0}">
								<td>未注销</td>
							</c:when>
							<c:when test="${Card.ZXBJ==1}">
								<td>已注销</td>
							</c:when>
						</c:choose>
						<td>${Card.monthly_money}</td>
						<td>${Card.frozen_money}</td>
						<td>${Card.wallet_money}</td>
						<c:choose>
							<c:when test="${Card.status==1}">
								<td>未锁定</td>
							</c:when>
							<c:when test="${Card.status==2}">
								<td>已锁定</td>
							</c:when>
						</c:choose>
						<td><input type="button" value="修改"
							onclick="window.location.href='http://localhost:8080/bike/bike/searchCard?card_code=${Card.card_code}'">
							<c:choose>
								<c:when test="${Card.ZXBJ==1 || Card.status==2}">
									<input type="button" value="挂失" disabled="disabled"
										onclick="window.location.href='http://localhost:8080/bike/bike/lossCard?card_code=${Card.card_code}'">
								</c:when>
								<c:otherwise>
									<input type="button" value="挂失"
										onclick="window.location.href='http://localhost:8080/bike/bike/lossCard?card_code=${Card.card_code}'">
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${Card.ZXBJ==1}">
									<input type="button" value="注销" disabled="disabled"
										onclick="window.location.href='http://localhost:8080/bike/bike/logOffCard?card_code=${Card.card_code}'">
								</c:when>
								<c:otherwise>
									<input type="button" value="注销"
										onclick="window.location.href='http://localhost:8080/bike/bike/logOffCard?card_code=${Card.card_code}'">
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${Card.card_type==4 ||Card.card_type==5||Card.ZXBJ==1}">
									<input type="button" value="充值" disabled="disabled"
										onclick="window.location.href='http://localhost:8080/bike/recharge.jsp?card_code=${Card.card_code}&card_type=${Card.card_type}'">

								</c:when>
								<c:otherwise>
									<input type="button" value="充值"
										onclick="window.location.href='http://localhost:8080/bike/recharge.jsp?card_code=${Card.card_code}&card_type=${Card.card_type}'">
								</c:otherwise>
							</c:choose> 
					</tr>
				</c:forEach>
			</table>
			当前第${page.currentPage}页
			<c:if test="${page.currentPage==0||page.currentPage==1}">
				<input type="button" value="首页" disabled="disabled">
				<input type="button" value="上一页" disabled="disabled">
			</c:if>
			<c:if test="${page.currentPage!=1 && page.currentPage!=0}">
				<input type="button" value="首页" onclick="goPage(1)">
				<input type="button" value="上一页"
					onclick="goPage(${page.currentPage-1})">
			</c:if>
			<c:if test="${page.currentPage==0||page.currentPage==page.totalPage}">
				<input type="button" value="尾页" disabled="disabled">
				<input type="button" value="下一页" disabled="disabled">
			</c:if>
			<c:if test="${page.currentPage!=0&&page.currentPage!=page.totalPage}">
				<input type="button" value="尾页" onclick="goPage(${page.totalPage})">
				<input type="button" value="下一页"
					onclick="goPage(${page.currentPage+1})">
			</c:if>
			共${page.totalPage}页${page.totalCount}条记录
<br>
<br>
<br>
			${error}

		</div>

	</div>
</body>
</html>