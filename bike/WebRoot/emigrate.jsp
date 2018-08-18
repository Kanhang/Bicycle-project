<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emigrate.jsp' starting page</title>
    
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
 table{
 border-collapse:collapse;
 border:solid 1px black;}
 th,td{
 padding:0.3em 1em;}

</style>  
<script type="text/javascript">
function goPage(currentPage){
var params={
"currentPage":  currentPage
};

$("#dataList").load("<%=path%>/bike/stationDatalist",params);
}
</script>
  <body onload="goPage(1)">
  	<div class="container">
	<div id="dataList" class="public-content-header">
			<div class="public-nav">
				您当前的位置：车点列表
			</div>
  <table cellspacing="1">
  <tr>
  <th>序号
  <th>车点ID
  <th>车点编号
  <th>车点名字
  <th>车桩数量
  <th>负责人
  <th>备注
  <th>操作
  </tr>
<c:forEach items="${page.dataList}" var="Bicycle_Station" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td>${Bicycle_Station.station_id}
						<td>${Bicycle_Station.station_code}</td>
						<td>${Bicycle_Station.station_name}</td>
						<td>${Bicycle_Station.bicycle_pile_num}</td>
						<td>${Bicycle_Station.person_in_charge}</td>
						<td>${Bicycle_Station.remark}</td>	
						<td><input type="button" value="查看车桩" onclick="window.location.href='http://localhost:8080/bike/bike/stationTransfer?station_id=${Bicycle_Station.station_id}'"></td>
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
