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
    
    <title>My JSP 'immigrate_pile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	
		$("#dataList").load("<%=path%>/bike/pileImmigrateDatalist",params);
	}
	var httpRequest;
	function createHttpRequest(){
	if(window.XMLHttpRequest){
	httpRequest=new XMLHttpRequest();}
	else{
	httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	}
	function immigrate(pile_id){
	var bicycle_id= document.getElementById("bicycle_id").value;

	createHttpRequest();
	httpRequest.open("post","http://localhost:8080/bike/bike/immigrate?bicycle_id="+bicycle_id+"&pile_id="+pile_id);
		httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	httpRequest.send(null);
	httpRequest.onreadystatechange=function(){
	if(httpRequest.readyState==4&&httpRequest.status==200){
	
	var message=httpRequest.responseText;
alert(message);

window.location.href="http://localhost:8080/bike/bicycles.jsp";
	}};
	}
	

</script>

  </head>
			<input type="hidden" value="${bicycle_id}" id="bicycle_id">
  <!-- onload是重新加载页面，加载过后 应该request消失所以取到null值 -->
  <body onload="goPage(1)">
   	<div class="container">
	<div id="dataList" class="public-content-header">
			<div class="public-nav">
				您当前的位置：车桩列表
			</div>
			
  <table cellspacing="1">
  <tr>
  <th>序号
  <th>车桩id
  <th>车桩编码
 <th>车点id
  <th>状态
  <th>备注
  <th>操作
  </tr>
<c:forEach items="${page.dataList}" var="Bicycle_Pile" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
							<td>${Bicycle_Pile.pile_id}</td>
						<td>${Bicycle_Pile.pile_code}</td>
						<td>${Bicycle_Pile.station_id}
						<td>${Bicycle_Pile.status}</td>
						<td>${Bicycle_Pile.remark}</td>
						<c:choose>
						<c:when test="${Bicycle_Pile.status==2}">
						<td><input type="button" value="调入" onclick="immigrate(${Bicycle_Pile.pile_id})"></td>
						</c:when>
						<c:otherwise >
							<td><input type="button" value="调入" disabled="disabled"></td>
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
			<input type="button" value="返回选择车俩" onclick="window.location.href='http://localhost:8080/bike/bicycles.jsp'">
			共${page.totalPage}页${page.totalCount}条记录
<br>
<br>
<br>
 <br>
 </div>
 </div>
  </body>
</html>