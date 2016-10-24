<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机明细查询</title>
<style>
.head {
	/* width: 960px;
	 font-weight: bold padding-top:3px; */
	margin: 0 auto;
	height: 140px;
	line-height: 15px;
	font-size: 25px;
	background: #FFFFCC;
	font-weight: bold;
	border-style: solid;
	border-color: #FFFFCC;
}

.datalist {
	border: 1px solid #0058a3; /* 表格边框 */
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
	line-height: 25px;
}

.datalist caption {
	padding-bottom: 5px;
	font: bold 1.4em;
	text-align: left;
}

.datalist th {
	border: 1px solid #0058a3; /* 行名称边框 */
	background-color: #4bacff; /* 行名称背景色 */
	color: #FFFFFF; /* 行名称颜色 */
	font-weight: bold;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 12px;
	padding-right: 12px;
	text-align: center;
}

.datalist td {
	border: 1px solid #0058a3; /* 单元格边框 */
	text-align: left;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 10px;
	padding-right: 10px;
}

.datalist tr.altrow {
	background-color: #c7e5ff; /* 隔行变色 */
}

a {
	font-weight: bold;
	  text-decoration:none;
}

a:hover {
	color: red;
	font-size: 16px;
}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
</style>
</head>
<body style="text-align: center;">
	<div class="head" style="text-align: left;">
		<h2>借还信息</h2>
		<hr>
		<h3>借机明细查询</h3>
	</div>
	<br>
	<form
		action="${pageContext.request.contextPath }/FindBorrowByCondServlet"
		method="POST">
	<font color="red">${msg }</font>
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
			value="${param.BorrowPermitPerson}" /> 借条编号:<input type="text"
			name="BorrowCheckNo" value="${param.BorrowCheckNo}" /> 归还日期:<input
			type="text" name="ReturnDatetime" value="${param.ReturnDatetime}" /><br>
		<br> 是否已归还:<input type="radio" name="Return" value="yes"
			<c:if test="${param.Return=='yes'}">checked='checked'</c:if> />是 <input
			type="radio" name="Return" value="no"
			<c:if test="${param.Return=='no'}">checked='checked'</c:if>>否
		<input type="radio" name="Return" value="any"
			<c:if test="${param.Return=='any'}">checked='checked'</c:if>>无
		<input type="submit" value="查询借机明细" /> <input type="reset" value="取消" />

	</form>
	<br>


	<table border="1" width="100%" class="datalist">
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
				<td><c:out value="${borrow.borrowPermitPerson.userName }" /></td>
				<td><c:out value="${borrow.borrowOperator.userName }" /></td>
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