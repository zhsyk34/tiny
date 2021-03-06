<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面不存在</title>
</head>
<link href="${ctx}/css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<link href="${ctx}/css/home/style.css" rel="stylesheet">
<script src="${ctx}/script/jquery.js"></script>
<script src="${ctx}/script/bootstrap.js"></script>
<body>
	<div id="wrap">
		<div class="container">
			<div class="page-header">
				<h1>页面不存在！</h1>
			</div>
			<p class="lead">在 <a href="${ctx}/home">Tiny</a>中没有发现您想要访问的页面。</p>
			<p>
				点击此处返回 <a href="${ctx}/home">首页</a>。
			</p>
		</div>
	</div>
</body>
</html>