<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.IData" %>
<%@ page import="com.lgwind.controller.LogController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-calendar.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-calendar.js"></script>

<div id="calendar">
	<table>
		<tr class="year-month">
			<td title="当前年月：<%=IData.year() %>-<% if (IData.month()<10){ %>0<%}%><%=IData.month() %>" colspan="3" onclick="window.open('${pageContext.request.contextPath }/log/logPage?year=<%=IData.year() %>&month=<%=IData.month() %>','_self');"><span><%=IData.year %>-<% if (IData.month<10){ %>0<%}%><%=IData.month %></span></td>
			<td title="上一年：<%=IData.year-1 %>年" class="week" onclick="window.open('${pageContext.request.contextPath }/log/logPage?year=<%=IData.year-1 %>','_self');">&lt;</td>
			<td title="下一年：<%=IData.year+1 %>年" class="week" onclick="window.open('${pageContext.request.contextPath }/log/logPage?year=<%=IData.year+1 %>','_self');">&gt;</td>
			<td title="上一月：<%=IData.month-1 %>月" class="week" onclick="window.open('${pageContext.request.contextPath }/log/logPage?month=<%=IData.month-1 %>','_self');">&lt;</td>
			<td title="下一月：<%=IData.month+1 %>月" class="week" onclick="window.open('${pageContext.request.contextPath }/log/logPage?month=<%=IData.month+1 %>','_self');">&gt;</td>
		</tr>
		<tr class="week">
			<td>日</td>
			<td>一</td>
			<td>二</td>
			<td>三</td>
			<td>四</td>
			<td>五</td>
			<td>六</td>
		</tr>
		<%
		String link=LogController.checkName+"-日志";
		link+=IData.year;
		if(IData.month<10)link+="0";
		link+=IData.month;
		%>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<7 }">
					<c:if test="${item!='' }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>0${item }','_self');">${item }</td>
					</c:if>
					<c:if test="${item=='' }">
					<td></td>
					</c:if>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<14 && i.index>=7 }">
					<c:if test="${fn:length(item)==1 }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>0${item }','_self');">${item }</td>
					</c:if>
					<c:if test="${fn:length(item)>1 }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>${item }','_self');">${item }</td>
					</c:if>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<21 && i.index>=14 }">
					<c:if test="${fn:length(item)==1 }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>0${item }','_self');">${item }</td>
					</c:if>
					<c:if test="${fn:length(item)>1 }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>${item }','_self');">${item }</td>
					</c:if>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<28 && i.index>=21 }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					onclick="window.open('#<%=link %>${item }','_self');">${item }</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<35 && i.index>=28 }">
					<c:if test="${item!='' }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					 onclick="window.open('#<%=link %>${item }','_self');">${item }</td>
					</c:if>
					<c:if test="${item=='' }">
					<td></td>
					</c:if></c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${days }" varStatus="i" var="item">
				<c:if test="${i.index<42 && i.index>=35 }">
					<c:if test="${item!='' }">
					<td title="<%=IData.year %>年<%=IData.month %>月${item }日" 
					 onclick="window.open('#<%=link %>${item }','_self');">${item }</td>
					</c:if>
					<c:if test="${item=='' }">
					<td></td>
					</c:if>
				</c:if>
			</c:forEach>
		</tr>
	</table>
	
<!-- 	<a href="#刘小黑-日志20180422">点击跳转test</a> -->
<!-- 	<br> -->
	<!-- onBlur 当用户离开输入字段时对其进行验证,属性在元素失去焦点时触发,常用于表单验证 -->
	<input title='输入要查询的日志作者名称'id="checkName" type="text" onmouseover="checkNameFocus();" onmouseout="checkName();" class="input-lgwind" placeholder="输入要查询的姓名" value="<%=LogController.checkName %>"/>
</div>
