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
    
    <title>My JSP 'bicycles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
 table{
 border-collapse:collapse;
 border:solid 1px black;}
 th,td{
 padding:0.3em 1em;}

</style>  
    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript">
function goPage(currentPage){
var params={
"currentPage":  currentPage
};

$("#dataList").load("<%=path%>/bike/bicyclesDatalist",params);
}
</script>
<body onload="goPage(1)">
  	<div class="container">
	<div id="dataList" class="public-content-header">
			<div class="public-nav">
				您当前的位置：被普通调出的小车车们
			</div>
  <table cellspacing="1">	
  <tr>
  <th>序号
  <th>自行车id
  <th>自行车编码
  <th>状态
  <th>自行车卡id
  <th>备注
  <th>操作
  </tr>
<c:forEach items="${page.dataList}" var="Bicycle_Info" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td>${Bicycle_Info.bicycle_id}
						<td>${Bicycle_Info.bicycle_code}</td>
						<td>${Bicycle_Info.status}</td>
						<td>${Bicycle_Info.card_id}</td>
						<td>${Bicycle_Info.remark}</td>
						<td><input type="button" value="选择车桩" onclick="window.location.href='http://localhost:8080/bike/bike/bicycleTransfer?bicycle_id=${Bicycle_Info.bicycle_id}'"></td>
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
 <br>
 </div>
 </div>
  </body>
</html>
