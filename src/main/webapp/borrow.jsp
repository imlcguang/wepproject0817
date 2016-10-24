<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机登记</title>
<style type="text/css">
.label {
	width: 20%
}

.controler {
	width: 80%
}
</style>
   <style>
.label {
	width:20%;
}

.controler {
width:80%;
	
}

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
.table{
width:30%;
}
.datalist {
border-radius:8px;
	border: 1px solid #0058a3;  /* 表格边框 */ 
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
	width:333px;
}
.datalist td {
border-radius:8px;
	/* border: 1px solid #0058a3; */  /* 单元格边框 */
	text-align: left;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 10px;
	padding-right: 10px;
	font-weight: bold;
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
	font-size: 14px;
}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
.main{
width:40%;
text-align:left;
}
</style>

</head>
<body>
<div class="head">
		<h2>借还信息</h2>
		<hr>
		<h3>借机登记</h3>
	</div>
	<br>
	
	<font color="red">${msg }</font>
	<form name="BorForm"
		action="${pageContext.request.contextPath}/BorrowServlet"
		method="post" class="datalist">
		<%-- <%=request.getContextPath()%>  --%>
		<table border="0" width="800" cellspacing="0" cellpadding="0">
			<tr>
				<td class="lalel">客户：</td>
				<td class="controler"><select name="CustomerID">
						<option value="">请选择客户名</option>
						<c:forEach items="${listc}" var="cust">
							<option value="${cust.customerID }">${cust.customerName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">发货时间：</td>
				<td class="controler"><input type="text" id="SendDatetime"
					name="SendDatetime" value="${param.SendDatetime }"></td>

			</tr>
			<tr>
				<td class="label">批准人：</td>
				<td class="controler"><select name="BorrowPermitPerson">
						<option value="">请选择批准人</option>
						<c:forEach items="${listu}" var="user">
							<option value="${user.userID }">${user.userName }</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td class="label">借机操作员：</td>
				<td class="controler"><select name="BorrowOperator">
						<option value="">请选择操作员</option>
						<c:forEach items="${listu}" var="user">
							<option value="${user.userID }">${user.userName }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td class="label">预计归还时间：</td>
				<td class="controler"><input type="text"
					id="PlanReturnDatetime" name="PlanReturnDatetime"
					value="${param.PlanReturnDatetime }"></td>
			</tr>

			<tr>
				<td class="label">样机：</td>
				<td class="controler"><select name="ModelID">
						<option value="">请选择样机名</option>
						<c:forEach items="${listm}" var="model">
							<option value="${model.modelID }">${model.modelName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">借机数量：</td>
				<td class="controler"><input type="text" id="BorrowNumber"
					name="BorrowNumber" value="${param.BorrowNumber }"></td>
			</tr>
			<tr>
				<td class="label">借条编号：</td>
				<td class="controler"><input type="text" id="BorrowCheckNo"
					name="BorrowCheckNo" value="${param.BorrowCheckNo }"></td>
			</tr>
			<tr>

				<td colspan="1" align="center"><br>
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册" />&nbsp;&nbsp;
					&nbsp; <input type="reset" value="取消" />&nbsp;</td>
			</tr>
		</table>
	</form>
	<a href=index.jsp>返回主页</a>
</body>
</html>