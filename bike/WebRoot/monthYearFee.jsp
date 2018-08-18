<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>My JSP 'monthYearFee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
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
<body onload="goPage(1)" marginwidth="0" marginheight="0">
	<div class="container">
		<div id="dataList" class="public-content-header">
			<div class="public-content">
			<h3>月度卡总费用统计</h3></div>
			<!-- 这张表是查询bicycle_record的 -->
			<table cellspacing="1">
				<tr>
				
					<th>总消费金额
					<th>总租车次数
					<th>平均租车次数
					<th>总租车小时数
					<th>平均租车小时数
				</tr>
				<tr>
			
					<td>${totalData.total_spent}
					<td>${totalData.frozen_balance}
					<td>${totalData.balance}
					<td>${totalData.total_rent_hours}
					<td>${totalData.total_rent_count}
				</tr>
			</table>
			<!--  还有一张表，写所有注册卡信息-->
			<br>


			<!-- 还需提供一个 查询注册卡的功能，可通过姓名模糊查询-->
			<br>
			</div>
			--------------------------------------------------------------------------------华丽丽的分割线-----------------------------------------------------------------------------------------------
			<div id="dataList" class="public-content-header">
			<div class="public-content">
			<h3>年度卡总费用统计</h3></div>
			<!-- 这张表是查询bicycle_record的 -->
			<table cellspacing="1">
				<tr>
				<!-- 根本就不能统计年度充值月度充值 -->
					<th>总消费金额
					<th>总租车次数
					<th>平均租车次数
					<th>总租车小时数
					<th>平均租车小时数
				</tr>
				<tr>
					<td>${totalData.total_spent}
					<td>${totalData.frozen_balance}
					<td>${totalData.balance}
					<td>${totalData.total_rent_hours}
					<td>${totalData.total_rent_count}
				</tr>
			</table>
			<!--  还有一张表，写所有注册卡信息-->
			<br>


			<!-- 还需提供一个 查询注册卡的功能，可通过姓名模糊查询-->
			<br>
			</div>
			--------------------------------------------------------------------------------华丽丽的分割线-----------------------------------------------------------------------------------------------
			<div id="dataList" class="public-content-header">
				<div class="public-content">
					<h3>查询条件</h3>
				</div>
				<div class="public-content-cont">
					<br> 名字: <input type="text" id="name"><input
						type="button" value="查询" onclick="goPage(1)">

				</div>
				<br>
				<br>
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

					</tr>

					<c:forEach items="${page.dataList}" var="Card" varStatus="i">
						<tr>
							<td><a ondblclick="go()">${i.index+1}</a>
							</td>
							<td><a ondblclick="go()">${Card.card_code}</a> <input
								id="card_code" type="hidden" value="${Card.card_code}">
							</td>

							<c:choose>
								<c:when test="${Card.card_type==1}">
									<td><a ondblclick="go()">A卡</a>
									</td>
								</c:when>
								<c:when test="${Card.card_type==2}">
									<td><a ondblclick="go()">D卡</a>
									</td>
								</c:when>
								<c:when test="${Card.card_type==3}">
									<td><a ondblclick="go()">市民卡/社保卡</a>
									</td>
								</c:when>
								<c:when test="${Card.card_type==4}">
									<td><a ondblclick="go()">员工卡</a>
									</td>
								</c:when>
								<c:when test="${Card.card_type==5}">
									<td><a ondblclick="go()">调度卡</a>
									</td>
								</c:when>
							</c:choose>

							<!-- change -->
							<td><a ondblclick="go()">${Card.name}</a>
							</td>
							<td><a ondblclick="go()">${Card.idcard}</a>
							</td>
							<c:choose>
								<c:when test="${Card.sex==1}">
									<td><a ondblclick="go()">男</a>
									</td>
								</c:when>
								<c:when test="${Card.sex==0}">
									<td><a ondblclick="go()">女</a>
									</td>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${Card.ZXBJ==0}">
									<td><a ondblclick="go()">未注销</a>
									</td>
								</c:when>
								<c:when test="${Card.ZXBJ==1}">
									<td><a ondblclick="go()">已注销</a>
									</td>
								</c:when>
							</c:choose>
							<td><a ondblclick="go()">${Card.monthly_money}</a>
							</td>
							<td><a ondblclick="go()">${Card.frozen_money}</a>
							</td>
							<td><a ondblclick="go()">${Card.wallet_money}</a>
							</td>
							<c:choose>
								<c:when test="${Card.status==1}">
									<td><a ondblclick="go()">未锁定</a>
									</td>
								</c:when>
								<c:when test="${Card.status==2}">
									<td><a ondblclick="go()">已锁定</a>
									</td>
								</c:when>
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
				<c:if
					test="${page.currentPage==0||page.currentPage==page.totalPage}">
					<input type="button" value="尾页" disabled="disabled">
					<input type="button" value="下一页" disabled="disabled">
				</c:if>
				<c:if
					test="${page.currentPage!=0&&page.currentPage!=page.totalPage}">
					<input type="button" value="尾页" onclick="goPage(${page.totalPage})">
					<input type="button" value="下一页"
						onclick="goPage(${page.currentPage+1})">
				</c:if>
				共${page.totalPage}页${page.totalCount}条记录

			</div>
		</div>
	
</body>
</html>
