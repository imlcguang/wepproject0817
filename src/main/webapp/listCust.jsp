<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>客户列表页面</h1>
	<hr>
	<table border="1" width="100%">
		<tr>
			<th><input type="checkbox" onclick="checkAll(this)" />全选</th>
			<th>客户名称</th>
			<th>联系人姓名</th>
			<th>联系电话</th>
			<th>地址</th>
			<th>邮箱</th>
			<th>备注</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="cust">
			<tr>
				<td><input type="checkbox" name="delId" value="${cust.CustomerID }" /></td>
				<td><c:out value="${cust.CustomerName }" /></td>
				<td><c:out value="${cust.RelationName }" /></td>
				<td><c:out value="${cust.RelationPhone }" /></td>
				<td><c:out value="${cust.Address }" /></td>
				<td><c:out value="${cust.Email }" /></td>
				<td><c:out value="${cust.Remark }" /></td>
				
				<td><a
					href="${pageContext.request.contextPath }/CustInfoServlet?id=${cust.CustomerID }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelCustServlet?id=${cust.CustomerID }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>