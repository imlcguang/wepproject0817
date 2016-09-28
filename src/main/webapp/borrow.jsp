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
</head>
<body>
	<h1>借还信息</h1>
	<hr>
	<h2>借机登记</h2>
	<font color="red">${msg }</font>
	<form name="BorForm"
		action="${pageContext.request.contextPath}/BorrowServlet"
		method="post">
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