<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机统计</title>
</head>
<body>
	<h1>借还信息</h1>
	<hr>
	<h2>借机统计</h2>
	<form action="${pageContext.request.contextPath }/CountServlet"
		method="POST">
		排序方式:<input type="radio" name="Count" value="Cus"
			<c:if test="${param.Count=='Cus'}">checked='checked'</c:if> />按客户 <input
			type="radio" name="Count" value="Model"
			<c:if test="${param.Count=='Model'}">checked='checked'</c:if>>按样机
		<input type="submit" value="排序" />
	</form>
	<br>
	<c:if test="${param.Count=='Cus'}">
		<table border="1" width="60%">
			<tr>
				<th>客户名称</th>
				<th>样机名称</th>
				<th>借机数量</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="map">
				<tr>
					<td rowspan="${map['detail'].size()+1}" align="center"><c:out value="${map['cal'].customerID.customerName}" /></td>
					<td><c:out value="${map['cal'].modelID.modelName}" /></td>
					<td><c:out value="${map['cal'].borrowNumber}" /></td>
				</tr>
				<c:forEach items="${map['detail']}" var="value">
					<tr>
					<%-- ${value.customerID.customerName} --%>
						<td><c:out value="${value.modelID.modelName }" /></td>
						<td><c:out value="${value.borrowNumber }" /></td>
					</tr>
				</c:forEach>
				
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${param.Count=='Model'}">
		<table border="1" width="60%">
			<tr>
				<th>样机名称</th>
				<th>客户名称</th>
				<th>借机数量</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="map">
				<tr>
					<td rowspan="${map['detail'].size()+1}" align="center"><c:out value="${map['cal'].modelID.modelName}" /></td>
					<td><c:out value="${map['cal'].customerID.customerName}" /></td>
					<td><c:out value="${map['cal'].borrowNumber}" /></td>
				</tr>
				<c:forEach items="${map['detail']}" var="value">
					<tr>
						<td><c:out value="${value.customerID.customerName}" /></td>
						<td><c:out value="${value.borrowNumber }" /></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</c:if>

	<a href=index.jsp>返回主页</a>
</body>
</html>