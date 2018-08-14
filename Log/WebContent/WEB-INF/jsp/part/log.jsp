<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.IData" %>
<%@ page import="com.lgwind.controller.LogController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-log.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-log.js"></script>
<div id="log">
	<c:forEach items="${logList }" varStatus="i" var="item">
<!-- 		<form class='update-log' action='/Log/log/updateLog' method='post' onmouseleave='this.submit();'> -->
		<div id="${item.name }-${item.title }" 
		     onmouseleave="logDivChangeOut(this, '${item.title }', '${item.name }', '${item.content }');" 
		     onclick="logDivChange(this, '${item.title }', '${item.name }', '${item.content }');" 
		     class="log-item">
			<div class="log-title">${item.title }&nbsp;&nbsp;<span class="log-name">${item.name }</span></div>
			<div class="log-content">${item.content }</div>
		</div>
<!-- 		</form> -->
	</c:forEach>
</div>
<div title="写日志" id="addlog" onclick="showlogaddPage()" onmouseover="addlogOver()" onmouseout="addlogOff()">
+
</div>
<!-- 遮罩div 盖章整个页面 -->
<div id="logMask" class="mask-lgwind"></div>
<!-- 添加日志div -->
<div id="addlogPage">
	<h3>新增日志</h3>
	<img onclick="closelogaddPage();" title="点击退出" class="quit" alt="退出" src="${pageContext.request.contextPath }/picture/quit.png">
	<form class="center-form" action="${pageContext.request.contextPath }/log/addLog" method="post">
		<table>
			<tr>
				<td><input id="log-input-title" class="input-lgwind" type="text" name="title" value="日志<%=IData.year() %><%if(IData.month()<10){%>0<%} %><%=IData.month() %><%if(IData.day()<10){%>0<%} %><%=IData.day() %>" />
				<input id="log-input-name" class="input-lgwind" type="text" name="name" value="<%=LogController.checkName %>" /></td>
			</tr>
			<tr>
				<td><textarea class="input-lgwind" rows="11" cols="67" name="content" >1. </textarea></td>
			</tr>
			<tr></tr>
			<tr><td><input class="input-lgwind" type="submit" value="确认新增" /></td></tr>
		</table>
	</form>
</div>