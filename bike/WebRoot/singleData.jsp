<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'singleData.jsp' starting page</title>
    
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
<script type="text/javascript">
			function goPage(currentPage){
		var name=$.trim($("#name").val());
		var params={
	"currentPage":currentPage,
	
    "name":name};
    		var card_code= document.getElementById("card_code").value;
    $.ajaxSettings.traditional=true;
    	$("#dataList").load("<%=path%>/bike/singleData?card_code="+card_code,params);    
    	}
    	
</script>
 <input id="card_code" value="${param.card_code}" type="hidden">
  <body onload="goPage(1)">
  
<div  id="dataList" class="container">
<!-- bicycle_record 和card中获取 -->
			<div class="public-nav">您当前的位置：单卡实时费用统计</div>
			<!-- 消费金额和余额互不影响的原因，是因为，租车消费并不是我做的，所以card_record的数据和bicycle_record的数据不互通 -->
			<table cellspacing="1">
				<tr>
		
					<th>卡id
					<th>总充值金额
					<th>总消费金额
					<th>现冻结金额
					<th>现可用余额
					<th>总租车小时数
					<th>总租车次数
				</tr>
				<tr>
				<!-- 卡号72 75需补充充值数据  -->
				<td>${card_id}
				<td>${singleData.total_recharge}
				<td>${singleData.total_spent}
				<td>${singleData.frozen_balance}
				<td>${singleData.balance}
				<td>${singleData.total_rent_hours}
				<td>${singleData.total_rent_count}x
				</tr>
			</table>
	
	--------------------------------------------------------------------------------华丽丽的分割线-----------------------------------------------------------------------------------------------
	
		<div id="dataList" class="public-content-header">
			<!-- 费用流水表  bicycle_deal（消费记录）-->
			<table cellspacing="1">
				<tr>
					<th>序号
					<th>自行车ID
					<th>卡ID
					
					<th>租的时间
					<th>租的车桩ID
					<th>还的时间
					<th>还的车桩ID
					<th>价格
					<th>备注
			
				</tr>
				<c:forEach items="${page.dataList}" var="Bicycle_Record"
					varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td>${Bicycle_Record.bicycle_id}
						<td>${Bicycle_Record.card_id}
				
						<td>${Bicycle_Record.rent_time}
						<td>${Bicycle_Record.rent_pile_id}
							<td>${Bicycle_Record.return_time}
						<td>${Bicycle_Record.return_pile_id}
						<td>${Bicycle_Record.money}
						<td>${Bicycle_Record.remark}
						</td>
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
			共${page.totalPage}页${page.totalCount}条记录 <br> <br> <br>
			<br>	
		
			<br>
<!-- 还有一张表，该车的费用流水，通过查询该费用流水表， -->
			
		</div>
	</div>
  </body>
</html>
