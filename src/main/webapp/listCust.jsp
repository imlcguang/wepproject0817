<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<!-- <script type="text/javascript">
	function checkAll(allC) {
		var otherCs = document.getElementsByName("delId");
		for (var i = 0; i < otherCs.length; i++) {
			otherCs[i].checked = allC.checked;
		}
	}
</script> -->
</head>
<body style="text-align: center;">
	<h1>客户列表页面</h1>
	<hr>
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindCustByCondServlet"
		method="POST">
		客户名称:<input type="text" name="customerName" value="${param.customerName }" /> 
			联系人姓名:<input type="text" name="relationName" value="${param.relationName }" /> 
			联系电话:<input type="text" name="relationPhone" value="${param.relationPhone }" />
		<input type="submit" value="条件查询客户" />
	</form>

	
	<table border="1" width="100%">
		<tr>
			<th>客户 ID</th>
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
				<td><c:out value="${cust.customerID }" /></td>
				<td><c:out value="${cust.customerName }" /></td>
				<td><c:out value="${cust.relationName }" /></td>
				<td><c:out value="${cust.relationPhone }" /></td>
				<td><c:out value="${cust.address }" /></td>
				<td><c:out value="${cust.email }" /></td>
				<td><c:out value="${cust.remark }" /></td>

				<td><a
					href="${pageContext.request.contextPath }/CustInfoServlet?id=${cust.customerID }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelCustServlet?id=${cust.customerID }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href=index.jsp>返回主页</a>
</body>
</html>