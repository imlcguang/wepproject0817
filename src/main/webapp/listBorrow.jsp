<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机明细查询</title>
</head>
<body style="text-align: center;">
	<h1>借机明细查询</h1>
	<hr>
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindBorrowByCondServlet"
		method="POST">
		<%--   <p>客户：</p>
		<select name="CustomerID"  >
		<option value="">请选择客户</option>
			<c:forEach items="${requestScope.list}" var="cust" >
				<option value="${cust.customerID.customerID}">${cust.customerID.customerName}</option>
			</c:forEach>
		</select>  --%>
		
		客户ID:<input type="text" name="CustomerID" value="${param.CustomerID }" />
		
		样机ID:<input type="text" name="ModelID" value="${param.ModelID }" />
		
		借机时间:<input type="text" name="BorrowOperatDatetime"
			value="${param.BorrowOperatDatetime }" /><br> <br>
		
		借机批准人ID:<input type="text" name="BorrowPermitPerson"
			value="${param.BorrowPermitPerson}" /> 
		借条编号:<input type="text"
			name="BorrowCheckNo" value="${param.BorrowCheckNo}" /> 
		归还日期:<input
			type="text" name="ReturnDatetime" value="${param.ReturnDatetime}" /><br><br> 
		是否已归还:<input type="radio" name="Return" value="yes"
			<c:if test="${param.Return=='yes'}">checked='checked'</c:if> />是 
			<input type="radio" name="Return" value="no"
			<c:if test="${param.Return=='no'}">checked='checked'</c:if>>否
		    <input type="radio" name="Return" value="any"
			<c:if test="${param.Return=='any'}">checked='checked'</c:if>>无
		<input type="submit" value="查询借机明细" /> <input type="reset" value="取消" />

	</form>
	<br>


	<table border="1" width="100%">
		<tr>
			<th>借机编号</th>
			<th>客户名称</th>
			<th>发货时间</th>
			<th>批准人</th>
			<th>借机操作员</th>
			<th>操作时间</th>
			<th>预计归还时间</th>
			<th>样机名称</th>
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
				<td><c:out value="${borrow.borrowNo }" /></td>
				<td><c:out value="${borrow.customerID.customerName }" /></td>
				<td><c:out value="${borrow.sendDatetime }" /></td>
				<td><c:out value="${borrow.borrowPermitPerson.loginName }" /></td>
				<td><c:out value="${borrow.borrowOperator.loginName }" /></td>
				<td><fmt:formatDate type="time"
						value="${borrow.borrowOperatDatetime}" pattern="yyyy-MM-dd" /></td>
				<%-- <td><c:out value="${borrow.borrowOperatDatetime }" /></td> --%>
				<td><c:out value="${borrow.planReturnDatetime }" /></td>
				<td><c:out value="${borrow.modelID.modelName }" /></td>
				<td><c:out value="${borrow.borrowNumber }" /></td>
				<td><c:out value="${borrow.borrowCheckNo }" /></td>
				<td><fmt:formatDate type="time"
						value="${borrow.returnDatetime}" pattern="yyyy-MM-dd" /></td>
				<%-- <td><c:out value="${borrow.returnDatetime }" /></td> --%>
				<td><c:out value="${borrow.returnOperator.loginName}" /></td>

				<td><c:if test="${borrow.returnDatetime==null}">
						<a
							href="${pageContext.request.contextPath }/returnBorrow.jsp?id=${borrow.borrowNo }">归还</a>
					</c:if> <c:if test="${borrow.returnDatetime!=null}">
						<c:out value="已归还" />
					</c:if></td>


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