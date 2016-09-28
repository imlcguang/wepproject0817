<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
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
		<h2>客户信息</h2>
		<hr>
		<h3>客户列表页面</h3>
	</div>
	<br>
	<form
		action="${pageContext.request.contextPath }/FindCustByCondServlet"
		method="POST">
	<font color="red">${msg }</font>
		客户名称:<input type="text" name="customerName" value="${param.customerName }" /> 
			联系人姓名:<input type="text" name="relationName" value="${param.relationName }" /> 
			联系电话:<input type="text" name="relationPhone" value="${param.relationPhone }" />
		<input type="submit" value="条件查询客户" />
	</form>
<br>
	
	<table border="1" width="100%" class="datalist">
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
		<c:forEach items="${listc}" var="cust">
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