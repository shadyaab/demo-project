<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css/" />
<spring:url var="js" value="/resources/js/" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>
<body>

	<div class="wrapper center">
		<!-- Header Section -->
		<%@include file="header.jsp" %>
		
		<!-- Content Section -->
		<div class="content marginLeftRight20PX borderBottom">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp" %>
			</c:if>
			
			<c:if test="${userClickManagement == true}">
				<%@include file="management.jsp" %>
			</c:if>
			
			<c:if test="${userClickNotification == true}">
				<%@include file="notification.jsp" %>
			</c:if>
			
		</div>
		
		<!-- Footer Section -->
		<%@include file="footer.jsp" %>
		
		
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.js"></script>

		<script src="${js}/myapp.js"></script>
	</div>
</body>
</html>