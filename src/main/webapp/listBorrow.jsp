<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机明细查询</title>
<script type="text/javascript">
	function checkAll(allC) {
		var otherCs = document.getElementsByName("delId");
		for (var i = 0; i < otherCs.length; i++) {
			otherCs[i].checked = allC.checked;
		}
	}
</script>
</head>
<body style="text-align: center;">
	<h1>借机明细查询</h1>
	<hr>
	<font color="red">${msg }</font>
	<%-- <form
		action="${pageContext.request.contextPath }/FindCustByCondServlet"
		method="POST">
		客户名称:<input type="text" name="customerName" value="${param.customerName }" /> 
			联系人姓名:<input type="text" name="relationName" value="${param.relationName }" /> 
			联系电话:<input type="text" name="relationPhone" value="${param.relationPhone }" />
		<input type="submit" value="条件查询借机明细" />
	</form> --%>


	<table border="1" width="100%">
		<tr>
			<th><input type="checkbox" onclick="checkAll(this)" /> 借机编号</th>
			<th>客户ID</th>
			<th>发货时间</th>
			<th>批准人</th>
			<th>借机操作员</th>
			<th>操作时间</th>
			<th>预计归还时间</th>
			<th>样机ID</th>
			<th>借机数量</th>
			<th>借条编号</th>
			<th>归还时间</th>
			<th>归还操作员</th>
			
			<th>归还</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="borrow">
			<tr>
				<td><input type="checkbox" name="delId"
					value="${borrow.borrowNo }" /> ${borrow.borrowNo }</td>
				<td><c:out value="${borrow.customerID.customerName }" /></td>
				<td><c:out value="${borrow.sendDatetime }" /></td>
				<td><c:out value="${borrow.borrowPermitPerson.loginName }" /></td>
				<td><c:out value="${borrow.borrowOperator.loginName }" /></td>
				<td><c:out value="${borrow.borrowOperatDatetime }" /></td>
				<td><c:out value="${borrow.planReturnDatetime }" /></td>
				<td><c:out value="${borrow.modelID.modelName }" /></td>
				<td><c:out value="${borrow.borrowNumber }" /></td>
				<td><c:out value="${borrow.borrowCheckNo }" /></td>
				<td><c:out value="${borrow.returnDatetime }" /></td>
				<td><c:out value="${borrow.returnOperator.loginName}" /></td>
				
				<td><a
					href="${pageContext.request.contextPath }/returnBorrow.jsp?id=${borrow.borrowNo }">归还</a></td>
				<td><a
					href="${pageContext.request.contextPath }/BorrowInfoServlet?id=${borrow.borrowNo }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelBorrowServlet?id=${borrow.borrowNo }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href=index.jsp>返回主页</a>

</body>
</html>