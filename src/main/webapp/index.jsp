<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body style="text-align: center;">
	<h1>样机管理系统</h1>
	<c:if test="${sessionScope.regUser==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/user.jsp">用户注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">用户登录</a>
	</c:if>
	
	<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.username }!
		<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
	</c:if>
</body>
</html>
