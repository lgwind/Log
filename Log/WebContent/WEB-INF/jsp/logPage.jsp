<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lgwind日志系统</title>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-lgwind.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-logPage.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/js-lgwind.js"></script>
</head>
<body>
	<h1 class="title">Lgwind日志系统</h1>
	<!-- 用户登录表单div -->
	<div class="left">
		<!-- 添加日历模块 -->
		<jsp:include page="part/calendar.jsp"></jsp:include>
	</div>
	<div class="right">
		<!-- 添加日志模块 -->
		<jsp:include page="part/log.jsp"></jsp:include>
	</div>
	
</body>
</html>