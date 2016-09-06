<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>样机管理系统</title>
</head>
<body style="text-align: center;">
	<h1>样机管理系统</h1>
	<c:if test="${sessionScope.regUser==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/user.jsp">用户注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">用户登录</a>
	</c:if>

	<c:if test="${sessionScope.regUser!=null}">
		欢迎回来!${sessionScope.regUser.loginName }!
		<a href="${pageContext.request.contextPath }/OutServlet">注销</a>
		<br>
		<br>
		<p>功能选择</p><hr>
		
		<p>用户信息：</p>
		<a href=user.jsp>注册用户信息</a>
		<a href=${pageContext.request.contextPath}/ListUserServlet >用户信息管理（查改删）</a>
		
		
		<p>客户信息：</p>
		<a href=customer.jsp>注册客户信息</a>
		<a href=${pageContext.request.contextPath}/ListCustServlet >客户信息管理（查改删）</a>
		
		
		<p>样机信息：</p>
		<a href=model.jsp>注册样机信息</a>
		<a href=${pageContext.request.contextPath}/ListModelServlet >样机信息管理（查改删）</a>
		
		<p>借还信息：</p>
		<a href=borrow.jsp>借机登记</a>
		<a href=${pageContext.request.contextPath}/ListBorrowServlet>借机明细查询</a>
		<a href=count.jsp>借机统计</a>
	</c:if>
</body>
</html>
